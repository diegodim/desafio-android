package com.picpay.desafio.android.features.contatcs.ui.contactslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import com.picpay.desafio.android.domain.contactsusecase.usecase.GetContactsUseCase
import com.picpay.desafio.android.domain.contactsusecase.usecase.RefreshContactsUseCase
import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACTS_MODEL
import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACT_MODEL_1
import com.picpay.desafio.android.features.contatcs.data.mapper.mapFromDomain
import com.picpay.desafio.android.features.contatcs.ui.contactslist.ContactsListViewAction.Navigate
import io.mockk.*
import org.junit.*
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

class ContactsListViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ContactsListViewModel
    private lateinit var action: (ContactsListViewAction) -> Unit

    private val getContactsUseCase: GetContactsUseCase = mockk()
    private val refreshContactsUseCase: RefreshContactsUseCase = mockk()
    private val navigation: ContactsListNavigation = mockk()

    private val testModule = module {
        single { getContactsUseCase }
        single { refreshContactsUseCase }
        single { navigation }
    }

    @Before
    fun setup() {
        GlobalContext.startKoin { modules(testModule) }
        MockKAnnotations.init()
        viewModel = ContactsListViewModel()
        action = viewModel::dispatchViewAction
    }

    @After
    fun reset() {
        GlobalContext.stopKoin()
    }

    @Test
    fun `WHEN dispatch Navigate_Contact action, navigate MUST be called`() {
        coEvery { navigation.navigateToContactDetails(any()) } returns Unit

        action(Navigate.Contact(CONTACT_MODEL_1.mapFromDomain()))

        verify(exactly = 1) { navigation.navigateToContactDetails(any()) }
    }

    @Test
    fun `WHEN dispatch Clear_Error action the view state value MUST be the null`() {
        action(ContactsListViewAction.Clear.UnexpectedError)

        Assert.assertNull(viewModel.viewState.unexpectedError)
    }

    @Test
    fun `WHEN dispatch Get_ContactList action and HAS success MUST be update list of contacts and set loading false`() {
        stubGetContactsSuccess()
        stubRefreshContactsSuccess()

        action(ContactsListViewAction.Get.ContactList)

        Assert.assertEquals(viewModel.viewState.contactList, CONTACTS_MODEL.mapFromDomain())
        Assert.assertNull(viewModel.viewState.unexpectedError)
        Assert.assertFalse(viewModel.viewState.isLoading)
    }

    @Test
    fun `WHEN dispatch Get_ContactList action and HAS success on GetContacts MUST be update list of contacts and, set loading false, and the unexpected errorr`() {
        stubGetContactsSuccess()
        val error = UnknownError()
        stubRefreshContactsFailure(error)

        action(ContactsListViewAction.Get.ContactList)

        Assert.assertEquals(viewModel.viewState.contactList, CONTACTS_MODEL.mapFromDomain())
        Assert.assertEquals(viewModel.viewState.unexpectedError, error)
        Assert.assertFalse(viewModel.viewState.isLoading)
    }

    @Test
    fun `WHEN dispatch Get_ContactList action and HAS success on RefreshContacts MUST be set loading false, and the unexpected error`() {
        stubRefreshContactsSuccess()
        val error = UnknownError()
        stubGetContactsFailure(error)

        action(ContactsListViewAction.Get.ContactList)

        Assert.assertEquals(viewModel.viewState.unexpectedError, error)
        Assert.assertFalse(viewModel.viewState.isLoading)
    }

    @Test
    fun `WHEN dispatch Get_ContactList action and HAS failure MUST be set loading false, and the unexpected error`() {
        val error = UnknownError()
        stubRefreshContactsFailure(error)
        stubGetContactsFailure(error)

        action(ContactsListViewAction.Get.ContactList)

        Assert.assertEquals(viewModel.viewState.unexpectedError, error)
        Assert.assertFalse(viewModel.viewState.isLoading)
    }

    private fun stubGetContactsSuccess() {
        every {
            getContactsUseCase.invoke(onFailure = any(), onSuccess = captureLambda())
        } answers {
            lambda<(List<ContactModel>) -> Unit>().invoke(CONTACTS_MODEL)
        }
    }

    private fun stubGetContactsFailure(throwable: Throwable) {
        every {
            getContactsUseCase.invoke(onSuccess = any(), onFailure = captureLambda())
        } answers {
            lambda<(Throwable) -> Unit>().invoke(throwable)
        }
    }

    private fun stubRefreshContactsSuccess() {
        every {
            refreshContactsUseCase.invoke(onFailure = any(), onSuccess = captureLambda())
        } answers {
            lambda<(Unit) -> Unit>().invoke(Unit)
        }

    }

    private fun stubRefreshContactsFailure(throwable: Throwable) {
        every {
            refreshContactsUseCase.invoke(onSuccess = any(), onFailure = captureLambda())
        } answers {
            lambda<(Throwable) -> Unit>().invoke(throwable)
        }
    }
}

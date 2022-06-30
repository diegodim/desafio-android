package com.picpay.desafio.android.features.contatcs.ui.contactslist

import android.content.Context
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.picpay.desafio.android.core.uikit.R.string
import com.picpay.desafio.android.features.contatcs.assertBackgroundColor
import com.picpay.desafio.android.core.uikit.component.TAG_SCAFFOLD_PROGRESS_INDICATOR
import com.picpay.desafio.android.core.uikit.theme.ColorPrimary
import com.picpay.desafio.android.core.uikit.theme.DesafioandroidTheme
import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACT_BINDING_1
import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACT_BINDING_2
import com.picpay.desafio.android.features.contatcs.ContactsFactory.VIEW_STATE_LIST
import com.picpay.desafio.android.features.contatcs.ContactsFactory.VIEW_STATE_LOADING
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ContactsListScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var context: Context

    @Before
    fun setup() {
        context = getApplicationContext<Context?>().applicationContext
    }

    @Test
    fun testIfShouldDisplayTitleAndAssertBackgroundColor() {
        val contactsText = context.getText(string.content_contacts_title).toString()
        composeTestRule.setContent {
            DesafioandroidTheme {
                Content(viewState = ContactsListViewState(), action = {})
            }
        }

        composeTestRule.onRoot().assertBackgroundColor(ColorPrimary)
        composeTestRule.onNodeWithText(contactsText).assertIsDisplayed()
    }

    @Test
    fun testIfShouldDisplayList() {

        composeTestRule.setContent {
            DesafioandroidTheme {
                Content(viewState = VIEW_STATE_LIST, action = {})
            }
        }

        composeTestRule.onNodeWithText(CONTACT_BINDING_1.name).assertIsDisplayed()
        composeTestRule.onNodeWithText("@${CONTACT_BINDING_1.username.lowercase()}")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(CONTACT_BINDING_2.name).assertIsDisplayed()
        composeTestRule.onNodeWithText("@${CONTACT_BINDING_2.username.lowercase()}")
            .assertIsDisplayed()
    }

    @Test
    fun testIfShouldDisplayLoading() {

        composeTestRule.setContent {
            DesafioandroidTheme {
                Content(viewState = VIEW_STATE_LOADING, action = {})
            }
        }

        composeTestRule.onNodeWithTag(testTag = TAG_SCAFFOLD_PROGRESS_INDICATOR).assertIsDisplayed()
            .assertRangeInfoEquals(ProgressBarRangeInfo.Indeterminate)
    }
}
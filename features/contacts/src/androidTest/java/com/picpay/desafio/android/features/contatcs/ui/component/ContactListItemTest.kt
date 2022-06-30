package com.picpay.desafio.android.features.contatcs.ui.component

import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.core.app.ApplicationProvider
import com.picpay.desafio.android.core.uikit.theme.DesafioandroidTheme
import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACT_BINDING_1
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ContactListItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext<Context?>().applicationContext
    }

    @Test
    fun testIfShouldDisplayTitle() {
        composeTestRule.setContent {
            DesafioandroidTheme {
                ContactListItem(contact = CONTACT_BINDING_1, onClick = {})
            }
        }

        composeTestRule.onNodeWithText(CONTACT_BINDING_1.name).assertIsDisplayed()
        composeTestRule.onNodeWithText("@${CONTACT_BINDING_1.username.lowercase()}")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = TAG_CONTACT_IMAGE, useUnmergedTree = true)
            .assertIsDisplayed().assertHeightIsEqualTo(80.dp)
            .assertWidthIsEqualTo(80.dp)
    }
}

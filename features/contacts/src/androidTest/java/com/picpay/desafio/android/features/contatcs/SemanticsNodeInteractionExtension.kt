package com.picpay.desafio.android.features.contatcs

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.captureToImage
import org.junit.Assert.assertEquals

fun SemanticsNodeInteraction.assertBackgroundColor(expectedBackground: Color) {
    val capturedName = captureToImage().colorSpace.name
    assertEquals(expectedBackground.colorSpace.name, capturedName)
}
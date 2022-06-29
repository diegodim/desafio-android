package com.picpay.desafio.android.features.contatcs.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.picpay.desafio.android.core.uikit.theme.ColorDetail
import com.picpay.desafio.android.core.uikit.theme.ColorWhite
import com.picpay.desafio.android.core.uikit.theme.Spacing
import com.picpay.desafio.android.core.uikit.theme.Spacing.Companion.ExtraLarge
import com.picpay.desafio.android.features.contatcs.data.model.ContactBinding
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ContactListItem(
    contact: ContactBinding,
    onClick: (ContactBinding) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick(contact) }
    ) {
        GlideImage(
            modifier = Modifier
                .padding(start = Spacing.Large, top = Spacing.Small, bottom = Spacing.Small)
                .clip(CircleShape)
                .size(size = ExtraLarge),
            imageModel = contact.img,
            circularReveal = CircularReveal()
        )
        Column(
            Modifier
                .padding(top = Spacing.Tiny, start = Spacing.Normal, end = Spacing.Normal)
                .fillMaxHeight()
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(top = Spacing.Tiny),
                text = "@${contact.username.lowercase()}",
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                modifier = Modifier.padding(bottom = Spacing.Tiny),
                text = contact.name,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}

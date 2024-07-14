package com.benaka.jetpack.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.benaka.jetpack.presentation.Dimen
import com.benaka.jetpack.presentation.onboarding.Page
import com.benaka.jetpack.presentation.onboarding.pages
import com.benaka.jetpack.ui.theme.JetpackTheme

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier, page: Page) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = page.title,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Dimen.Dimen24dp))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimen.Dimen30dp),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(Dimen.Dimen6dp))
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimen.Dimen30dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun OnBoardingPage() {
    JetpackTheme {
        OnBoardingPage(page = pages[0])

    }
}
package com.benaka.jetpack.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.benaka.jetpack.presentation.Dimen
import com.benaka.jetpack.presentation.common.BlankButton
import com.benaka.jetpack.presentation.common.GhostButton
import com.benaka.jetpack.presentation.common.PageIndicator
import com.benaka.jetpack.presentation.onboarding.components.OnBoardingPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val rememberPagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (rememberPagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = rememberPagerState) { index ->
            OnBoardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimen.Dimen30dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.weight(Dimen.Dimen52f),
                pageSize = pages.size,
                selectedPage = rememberPagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val coroutineScope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    BlankButton(name = buttonState.value[0], onClick = {
                        coroutineScope.launch {
                            rememberPagerState.animateScrollToPage(page = rememberPagerState.currentPage - 1)
                        }
                    })
                }

                GhostButton(name = buttonState.value[1], onClick = {
                    coroutineScope.launch {
                        if (rememberPagerState.currentPage == 3) {
                            //TODO TO Home screen
                        } else {
                            rememberPagerState.animateScrollToPage(page = rememberPagerState.currentPage + 1)
                        }
                    }
                })
            }
        }


    }
}
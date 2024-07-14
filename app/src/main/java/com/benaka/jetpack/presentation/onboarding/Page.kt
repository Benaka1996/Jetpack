package com.benaka.jetpack.presentation.onboarding

import androidx.annotation.DrawableRes
import com.benaka.jetpack.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Ghost of Tsushima: Samurai Saga",
        description = "Experience the legendary tale of Jin Sakai as he battles the Mongol forces to save Tsushima in this action-packed mobile adventure.",
        image = R.drawable.page_1
    ),
    Page(
        title = "Ghost of Tsushima: Rise of the Ghost",
        description = "Join Jin Sakai on his quest to reclaim his homeland from invaders in this immersive and visually stunning mobile game.",
        image = R.drawable.page_2
    ),
    Page(
        title = "Ghost of Tsushima: Tsushima's Hero",
        description = "Fight as the legendary samurai Jin Sakai to defend Tsushima from the Mongol invasion in this thrilling mobile adaptation.",
        image = R.drawable.page_3
    )
)

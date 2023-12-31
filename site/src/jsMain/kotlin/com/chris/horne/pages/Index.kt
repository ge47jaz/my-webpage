package com.chris.horne.pages

import androidx.compose.runtime.*
import com.chris.horne.components.BackToTopButton
import com.chris.horne.components.OverflowMenu
import com.chris.horne.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    var menuOpen by remember { mutableStateOf(false) } // by default, menu is closed
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(), // each section has fixed width
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection(onMenuClicked = { menuOpen = true }) // trigger lambda
            AboutSection()
            ServiceSection()
            PortfolioSection()
            ContactSection()
            FooterSection()
        }
        BackToTopButton()
        if (menuOpen) {
            OverflowMenu(onMenuClosed = { menuOpen = false })
        }
    }
}

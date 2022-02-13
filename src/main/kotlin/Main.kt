// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import `Data Structure`.DownloadQueue
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.Card
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import components.App
import components.Settings.Settings
import components.TopBar.TopBar
import java.io.File

val windowBorderShape = RoundedCornerShape(4.dp)
val windowBorderStroke = BorderStroke(1.dp, Color.Black.copy(alpha = 0.2f))
val windowModifier = Modifier.fillMaxHeight()

fun main() = application {

    val filesSettingsLocation: File = File("C:\\Users\\rd28\\Documents\\" +
            "Coding\\Exe\\youtube-dl_UI\\app\\resources\\settings.txt")

    val filesPath = remember { mutableStateOf(filesSettingsLocation.readText()) }


    val isSettingsOpen = remember { mutableStateOf(false) }
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val windowState: WindowState = rememberWindowState(isMinimized = false,  width = 800.dp, height = 579.dp)
    val queueList = remember { mutableStateListOf<DownloadQueue>() }
    val logoPainter = painterResource(resourcePath = "TopBar/download.png")


    Window(
        onCloseRequest = ::exitApplication,
        title = "youtube-dl Desktop-ui",
        undecorated = true,
        transparent = true,
        resizable = false,
        state = windowState,
        icon = logoPainter,

        ) {
        Card(shape = windowBorderShape, border = windowBorderStroke,
            backgroundColor = Color.Black.copy(alpha = 1f),


        ) {
            Column(modifier = Modifier.background(
                brush = Brush
                    .radialGradient(
                        listOf(
                            Color(0xFF121212),
                            Color(0xFF2c1111),

                            Color(0xFF121212),
                        )
                    ))
            ) {

                WindowDraggableArea(Modifier) {
                    TopBar().TopBar(windowState)
                }

                    App().AppComponent(textState,queueList,isSettingsOpen,filesPath.value)
                if (isSettingsOpen.value) {
                    Settings().SettingsWindow(isSettingsOpen,filesPath.value)
                }



            }

        }
    }
}

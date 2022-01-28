package components.TopBar

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import kotlin.system.exitProcess

class TopBar {






    @Composable
    @Preview
    fun TopBar(windowState: WindowState) {



            Row(Modifier.height(40.dp).background(Color(0xff151515))) {
                Column(Modifier.weight(1f)) {
                    Row {
                        Image(
                            painterResource(resourcePath = "TopBar/download.png" ),
                            contentDescription = "logo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(20.dp).offset(10.dp, 10.dp)
                        )

                        Text(text = "Youtube-dl GUI", color = Color.White, modifier = Modifier.offset(18.dp, 12.dp))
                    }

                }
                Column(Modifier) {

                    Row {
                        Minimize().minimizeButton(windowState)
                        Maximize().maximizeButton(windowState)
                        Exit().exitButton(windowState)

                    }
                }


            }



    }

    private fun exitApplication() {
        exitProcess(0)
    }
}

package components.TopBar

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import kotlin.system.exitProcess

class Minimize {






    @Composable
    @Preview
    fun minimizeButton(windowState: WindowState) {

        Card (modifier = Modifier.size(25.dp),
            shape = RoundedCornerShape(0.dp,0.dp,0.dp,5.dp),
            backgroundColor = Color(0xff041C32)

            ) {

            Image(
                painterResource(resourcePath = "TopBar/minimize.png" ),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(5.dp).clickable {
               windowState.isMinimized = true
                }
            )


        }
    }
}
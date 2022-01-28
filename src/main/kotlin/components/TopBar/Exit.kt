package components.TopBar

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
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

class Exit {




    @Composable
    @Preview
    fun exitButton(windowState: WindowState) {

        Card (modifier = Modifier.size(25.dp)
            .clickable {
                exitProcess(0)
            }
            , backgroundColor = Color(0xffc93131),
        shape = RoundedCornerShape(0.dp,0.dp,0.dp,0.dp)
            ) {

            Image(
                painterResource(resourcePath = "TopBar/exit2.png" ),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(5.dp)
            )


        }
    }
}
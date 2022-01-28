package components.VideoLink

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class Title {







    @Composable
    @Preview
    fun TitleTextInput(){

        Column(Modifier.padding(end = 280.dp, top = 80.dp)) {
         Text(
             text = "Enter a video or playlist link",
             style = MaterialTheme.typography.h6,
             color = Color.White
         )

        }
    }
}
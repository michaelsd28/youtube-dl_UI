package components.DownloadQueue

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import java.awt.Desktop
import java.io.File

class OpenFolder {


    @Composable
    fun folderIcon() {


        Box(Modifier.offset(x = 260.dp, y = -(10).dp).clickable {
//            user dir in windows
            Desktop.getDesktop().open(File("C:\\Users\\" + System.getProperty("user.name") + "\\Downloads"))

        }
        ) {
            Image(
                painterResource(resourcePath = "Download/folderIcon.png"),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(30.dp),
            )
        }


    }


}
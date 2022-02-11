package components.VideoLink

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class SettingsButton {


    @Composable
    @Preview
    fun settingsButton(isSettingsOpen: MutableState<Boolean>) {


            Box  (  Modifier.offset(x = 80.dp).padding(10.dp) ) {

                Image(
                    painterResource(resourcePath = "Download/settingsIcon.png"),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(40.dp).clickable {
                        isSettingsOpen.value = !isSettingsOpen.value
                    }

                )
            }
    }

}
package components.VideoLink

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class Settings {




    @Composable
    @Preview
    fun settingsButton() {

       Column{


           Row(Modifier.offset(x = 80.dp).clickable {



           }.padding(10.dp)){

               Image(
                   painterResource(resourcePath = "Download/settingsIcon.png" ),
                   contentDescription = "logo",
                   contentScale = ContentScale.Crop,
                   modifier = Modifier.size(30.dp),
                   )
           }




       }


    }

}
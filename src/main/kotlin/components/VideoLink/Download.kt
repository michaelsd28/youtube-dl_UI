package components.VideoLink

import `Data Structure`.DownloadQueue
import `Data Structure`.Queue
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.gson.Gson

class Download {




    ///id
    //name
    //url
    ///status
    ///remaining
//    val downloadTest:DownloadQueue = DownloadQueue(
//        "1",
//        "test",
//        "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
//        "0",
//        "0"
//    )




    @Composable
    @Preview
    fun DownloadButton(){



        Column(Modifier.padding(16.dp)) {
            OutlinedButton(
                {




                },
                modifier= Modifier.size(50.dp),  //avoid the oval shape

                border= BorderStroke(2.dp, Color.Black),
                contentPadding = PaddingValues(0.dp),  //avoid the little icon
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff602626))

            ) {
                Image(
                    painterResource(resourcePath = "Download/downloadButton.png" ),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(30.dp),

                )
            }

        }


    }
}
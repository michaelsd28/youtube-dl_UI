package components.VideoLink

import `Data Structure`.DownloadQueue
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class Download {




    ///id
    //name
    //url
    ///status
    ///remaining





    @Composable
    @Preview
    fun DownloadButton(queueList: MutableList<DownloadQueue>, urlState: MutableState<TextFieldValue>) {


        val initTitle = remember { mutableStateOf("hi there") }
        val floatState =      remember { mutableStateOf(0f) }


        val currentDownload:DownloadQueue = DownloadQueue(
            "1",
            initTitle,
            "url",
            floatState,
            "0"
        )
        val currentDownloadState:MutableState<DownloadQueue> = remember { mutableStateOf(currentDownload) }





        Column(Modifier.padding(16.dp)) {
            OutlinedButton(
                {



                    queueList.forEach {
                        println("${it.url} this is the url")
                    }


                    currentDownload.url = urlState.value.text



                    queueList.add(currentDownloadState.value)


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
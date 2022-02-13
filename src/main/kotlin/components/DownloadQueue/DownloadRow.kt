package components.DownloadQueue

import Util.TerminalCommands
import `Data Structure`.DownloadQueue
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DownloadRow {


    @Composable
    @Preview
    fun downloadRow(
        urlState: String,
        filesPath: String,
    ) {





        val videoStateInit = remember {           mutableStateOf(
            DownloadQueue(
                "01",
                mutableStateOf("\uD83D\uDCDD"),
                "url",
                mutableStateOf(0f),
                mutableStateOf("⌛"),
                mutableStateOf("\uD83D\uDE80"),
            )
        )}





        TerminalCommands().downloadVideo(urlState, videoStateInit,filesPath)
//        TerminalCommands().downloadSimulation(videoStateInit)


        Card(
            modifier = Modifier
                .padding(start = 16.dp, bottom = 8.dp, end = 16.dp, top = 8.dp)
                .fillMaxWidth().size(38.dp), backgroundColor = Color(0xFF222222)
        ) {
            Box(modifier = Modifier.size(100.dp, 30.dp).padding(8.dp)) {

                Row(verticalAlignment = Alignment.Top) {

                    Text(
                        text = videoStateInit.value.name.value, color = Color(0xFFFFFFFF), modifier = Modifier.weight(5f)
                    )
                    videoStateInit.value.speed.let {
                        Text(
                            text = it.value, color = Color(0xFFFFFFFF) , fontSize = 13.sp, modifier = Modifier.weight(1f)
                        )
                    }
                    Box(modifier = Modifier.weight(1f).padding(start = 28.dp)) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            progress = videoStateInit.value.status!!.value.toFloat(),
                            color = Color(0xFFF05454)
                        )
                    }


                    videoStateInit.let {
                        it.value.remainingTime.let { it1 ->
                            Text(
                                text = it1.value,
                                color = Color(0xFFFFFFFF),
                                modifier = Modifier.weight(1f).padding(start = 8.dp)
                            )
                        }
                    }
                }

            }
        }


    }
}

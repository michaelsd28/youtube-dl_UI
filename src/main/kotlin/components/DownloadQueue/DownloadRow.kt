package components.DownloadQueue

import Util.TerminalCommands
import `Data Structure`.DownloadQueue
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class DownloadRow {





    @Composable
    @Preview
    fun downloadRow(

    ) {

        val initDownloadQueue = DownloadQueue(
            "001",
            remember { mutableStateOf("Download") },
            "no url",
            "0",
            "0",

            )

        val cardRowModifier =
            Modifier
                .padding(start = 16.dp, bottom = 8.dp, end = 16.dp, top = 8.dp)
                .fillMaxWidth()
        val cardBackground: Color = Color(0xFF222222)
        val boxModifier = Modifier.size(100.dp, 30.dp).padding(8.dp)




        val videoState  = remember { mutableStateOf(initDownloadQueue) }
        TerminalCommands().downloadSimulation(videoState)

//        val progressState = remember { mutableStateOf(0) }
//        val isDownloadingState = remember { mutableStateOf(false) }


        Card(modifier = cardRowModifier.size(38.dp), backgroundColor = cardBackground) {
            Box(modifier = boxModifier) {

                Row( verticalAlignment = Alignment.Top) {

                    Text(
                        text = videoState.value.name.value, color = Color(0xFFFFFFFF), modifier = Modifier.weight(5f)
                    )
                    Text(
                        text = "150.00 k/s", color = Color(0xFFFFFFFF), modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.weight(1f).padding(start = 28.dp)) {
                        CircularProgressIndicator(modifier = Modifier.size(20.dp))
                    }


                    videoState.let {
                        it.value.remainingTime?.let { it1 ->
                            Text(
                                text = it1,
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
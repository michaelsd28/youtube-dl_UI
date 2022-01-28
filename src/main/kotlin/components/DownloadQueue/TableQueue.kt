package DownloadQueue

import `Data Structure`.DownloadQueue
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.DownloadQueue.DownloadRow
import components.DownloadQueue.TitleRow

class TableQueue {




//    val downloadTest: `Data Structure`.DownloadQueue = `Data Structure`.DownloadQueue(
//        "1",
//        "test",
//        "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
//        "0",
//        "0"
//    )



    val tableCardModifier: Modifier = Modifier.size(590.dp, 300.dp)
    val verticalScrollModifier:Modifier = Modifier.background(Color(0xffAAA492), shape = RoundedCornerShape(5.dp))
        .background(Color(0xff602626))
        .fillMaxHeight()
        .border(1.dp, Color.Black.copy(alpha = 0f))
        .padding(0.dp)


    @Composable
    @Preview
    fun downloadQueueBody() {


        val stateVertical = rememberScrollState(0)
        remember { mutableStateListOf<DownloadQueue>() }

        Card(
            modifier = tableCardModifier,
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xff602626)
        ) {


            Column{
                TitleRow().allTitles()
                Column (Modifier.verticalScroll(stateVertical)) {

                    DownloadRow().downloadRow()
                    DownloadRow().downloadRow()
                    DownloadRow().downloadRow()
                    DownloadRow().downloadRow()
                    DownloadRow().downloadRow()
                    DownloadRow().downloadRow()
                    DownloadRow().downloadRow()
                    DownloadRow().downloadRow()

                }


            }
            Box(Modifier.padding(top = 45.dp, bottom = 15.dp, end = 2.dp)) {
                VerticalScrollbar(
                    modifier =verticalScrollModifier
                        .align(Alignment.TopEnd)
                    ,
                    adapter = rememberScrollbarAdapter(stateVertical)
                )
            }
        }
    }
}

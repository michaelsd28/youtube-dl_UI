package DownloadQueue

import `Data Structure`.DownloadQueue
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.DownloadQueue.DownloadRow
import components.DownloadQueue.OpenFolder
import components.DownloadQueue.TitleRow

class TableQueue {


    @Composable
    @Preview
    fun downloadQueueBody(queueList: MutableList<DownloadQueue>, filesPath: String) {


        val stateVertical = rememberScrollState(0)


        Card(
            modifier = Modifier.size(590.dp, 300.dp).offset( y = -(20).dp),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xff602626)
        ) {


            Column {
                TitleRow().allTitles()
                Column(Modifier.verticalScroll(stateVertical)) {

                    queueList.forEach {
                        DownloadRow().downloadRow(it.url, filesPath)

                    }
                }
            }
            Box(Modifier.padding(top = 45.dp, bottom = 15.dp, end = 2.dp)) {
                VerticalScrollbar(
                    modifier = Modifier.background(Color(0xffAAA492), shape = RoundedCornerShape(5.dp))
                        .background(Color(0xff602626))
                        .fillMaxHeight()
                        .border(1.dp, Color.Black.copy(alpha = 0f))
                        .padding(0.dp)
                        .align(Alignment.TopEnd),
                    adapter = rememberScrollbarAdapter(stateVertical)
                )
            }
        }
        OpenFolder().folderIcon()
    }
}

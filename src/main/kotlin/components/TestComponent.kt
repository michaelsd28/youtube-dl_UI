package components

import Util.TerminalCommands
import `Data Structure`.DownloadQueue
import `Data Structure`.Queue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import components.DownloadQueue.DownloadRow


class TestComponent {

    val cardRowModifier = Modifier
        .padding(start = 16.dp, bottom = 8.dp, end = 16.dp, top = 8.dp)
        .fillMaxWidth()
    val cardBackground: Color = Color(0xFF222222)
    val boxModifier = Modifier.size(100.dp, 30.dp).padding(8.dp)

    @Composable
    fun testRow() {
        val textP = remember { mutableStateOf("hi there") }
//        TerminalCommands().downloadSimulation(textP)


        Column {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),

                shape = RoundedCornerShape(5.dp),
                backgroundColor = Color.LightGray
            ) {

                Text(text = textP.value)
            }
        }
    }


    @Composable
    fun TestComponent() {

        val textQ: MutableState<String> = mutableStateOf("test Text")

        val downloadTest1: DownloadQueue = DownloadQueue(
            "001",
            textQ,
            "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
            remember { mutableStateOf(0f) },
            "100",

            )


        val textState = remember { mutableStateOf("Hello World") }
        val arrayList = remember { mutableStateListOf<DownloadQueue>() }
        val queueList = remember { mutableStateOf(Queue()) }

        Column(Modifier.fillMaxSize().background(Color.Black)) {

            Text(text = textState.value, color = Color.White)



            Button(onClick = {


                arrayList.add(downloadTest1)
                queueList.value.enqueue(downloadTest1)
                TerminalCommands().getVideoTitle("https://www.youtube.com/watch?v=0Vsj5OPjsUA")



            }) {
                Text(text = "Click me", color = Color.White)
            }




            arrayList.forEach {

//                DownloadRow().downloadRow()

            }




        }


    }

}


fun main() = application {


    val windowState = rememberWindowState(isMinimized = false)

    Window(
        onCloseRequest = ::exitApplication,
        title = "youtube-dl Desktop-ui",
        undecorated = false,
        transparent = false,
        resizable = true,
        state = windowState,


        ) {


        TestComponent().TestComponent()


    }


}












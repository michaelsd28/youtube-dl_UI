package components

import Util.TerminalCommands
import `Data Structure`.DownloadQueue
import `Data Structure`.Queue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


class TestComponent {



    @Composable
    fun testRow(videoURL: String) {

        val textP = remember { mutableStateOf("hi there") }

        TerminalCommands().downloadSimulation(videoURL, textP)


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
            "url",
            remember { mutableStateOf(0f) },
            "100",
        )

        var videoURL: String = ""

        val textFieldState: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue("")) }


        val textState = remember { mutableStateOf("Hello World") }
        val arrayList = remember { mutableStateListOf<DownloadQueue>() }
        val queueList = remember { mutableStateOf(Queue()) }

        Column(Modifier.fillMaxSize().background(Color.Black)) {

            Text(text = textState.value, color = Color.White)

            OutlinedTextField(
                value = textFieldState.value,
                onValueChange = {
                    textFieldState.value = it
                    videoURL = it.text

                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.Gray,
                )

            )



            Button(onClick = {


                arrayList.add(

                    DownloadQueue(
                        "001",
                        textQ,
                        textFieldState.value.text,
                        mutableStateOf(0f) ,
                        "100",
                    )
                )


            }) {
                Text(text = "Click me", color = Color.White)
            }




            arrayList.forEach {
                testRow(it.url)
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

/*
https://utreon.com/v/TBffN4aqTGE

 */
        TestComponent().TestComponent()


    }


}












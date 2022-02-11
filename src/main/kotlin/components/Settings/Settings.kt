package components.Settings

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import kotlin.system.exitProcess


class Settings {


    @Composable
    fun WindowTitle(){

        Box(Modifier.padding(10.dp)){

            Text(
                text = "Settings",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        }




    @Composable
    fun ExitIcon(isSettingsOpen: MutableState<Boolean>) {


        Card (
            shape = RoundedCornerShape(30.dp),
            backgroundColor = Color(0xfff44336),
            modifier = Modifier.padding(5.dp)
        ) {

            Image(
                painterResource(resourcePath = "TopBar/exitSettings.png"),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(30.dp).clickable {isSettingsOpen.value = !isSettingsOpen.value }.padding(5.dp)
            )
        }

    }



@Composable
fun cardBody(isSettingsOpen: MutableState<Boolean>) {


    Card (backgroundColor = Color.LightGray, modifier = Modifier.size(500.dp, 300.dp)) {

        val  textFieldSettings = remember { mutableStateOf(TextFieldValue()) }




        WindowTitle()
        Row {
            Row(Modifier.weight(1f).padding(top = 80.dp, start = 20.dp)){

                OutlinedTextField(
                    value = textFieldSettings.value,
                    onValueChange = {  },
                    placeholder = { Text("Enter your link here", fontSize = 13.sp) },
                    textStyle = TextStyle(fontSize = 13.sp),
                    modifier = Modifier.width(400.dp).height(60.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.LightGray,


                        )
                )
                Box(Modifier.offset(x = 5.dp, y = 5.dp)){
                    IconButton({}){
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Search",
                            modifier = Modifier.size(30.dp)


                        )

                    }
                }


            }


            ExitIcon(isSettingsOpen)



        }




    }


}


    @Composable
    @Preview
    fun SettingsWindow(isSettingsOpen: MutableState<Boolean>) {

        val windowState = remember { WindowState( isMinimized = false, size = DpSize(503.dp, 303.dp)) }

        Window(

            state = windowState,
            resizable = false,
            onCloseRequest = {
                exitProcess(    0)
            },
            undecorated = true,

            transparent = true,



        ) {



            WindowDraggableArea {

                cardBody(isSettingsOpen)



            }

        }



    }
}
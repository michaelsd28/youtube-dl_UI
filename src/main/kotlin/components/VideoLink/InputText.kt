package components.VideoLink

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.awt.Cursor
import java.awt.Cursor.HAND_CURSOR
import java.awt.Cursor.WAIT_CURSOR
import java.awt.Frame
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import javax.swing.JOptionPane

class InputText {


    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    @Preview
    fun InputLink(textState: MutableState<TextFieldValue>) {




        Column(Modifier.padding(top = 20.dp, bottom = 40.dp)) {
            OutlinedTextField(
                /* outline border*/

                value = textState.value,
                onValueChange = { textState.value = it },
                placeholder = { Text("Enter your link here", fontSize = 13.sp) },
                textStyle = TextStyle(fontSize = 13.sp),


                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                    .width(500.dp)
                    .height(45.dp),

                shape = RoundedCornerShape(5.dp),
                //     TextFieldColors = TextFieldDefaults.outlinedTextFieldColors()
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    cursorColor = Color.Black
                ),
                trailingIcon = {

                    Card(

                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier,

                        ) {
                        Icon(

                            imageVector = Icons.Default.Add,


                            modifier = Modifier.clickable {

//                                paste text

                                try {
                                    val textClipBoard = Toolkit.getDefaultToolkit().getSystemClipboard()
                                        .getData(DataFlavor.stringFlavor)
                                    textState.value = TextFieldValue(textClipBoard.toString())
                                } catch (e: Exception) {
                                    val frame: Frame = Frame()
                                    JOptionPane.showMessageDialog(frame, "You need to copy a valid link");
                                }


                            }

                                .pointerHoverIcon(
                                    overrideDescendants = true,
                                    icon = PointerIcon(cursor = Cursor(HAND_CURSOR))


                                ).border(
                                    shape = RoundedCornerShape(20.dp),
                                    border = BorderStroke(color = Color.Black.copy(alpha = 0f), width = 1.dp)
                                ),
                            contentDescription = "Paste",


                            )
                    }

                }


            )

        }
    }

}




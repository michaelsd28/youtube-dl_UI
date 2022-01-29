package components.VideoLink

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class InputText {



    @Composable
    @Preview
    fun InputLink(textState: MutableState<TextFieldValue>) {


        Column(Modifier.padding(16.dp)) {
            OutlinedTextField(
                /* outline border*/



                value = textState.value,
                onValueChange = { textState.value = it },
                placeholder = { Text("Enter your link here") },
                textStyle = MaterialTheme.typography.body2,


                modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(5.dp)).width(500.dp),
                shape = RoundedCornerShape(5.dp),
           //     TextFieldColors = TextFieldDefaults.outlinedTextFieldColors()
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black, cursorColor = Color.Black)

            )

        }
    }

}




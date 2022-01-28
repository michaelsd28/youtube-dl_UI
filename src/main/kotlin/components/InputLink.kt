package components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue


class InputLink {


    @Composable
    fun SimpleOutlinedTextFieldSample() {
        val text = remember { mutableStateOf("") }

        Column {

//            OutlinedTextField(
//                text.value,
//                value = text,
//                onValueChange = { },
//                label = { Text("Label") }
//            )
        }

    }

}
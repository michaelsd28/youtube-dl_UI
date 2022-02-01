package components


import DownloadQueue.TableQueue
import `Data Structure`.DownloadQueue
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import components.VideoLink.Download
import components.VideoLink.InputText
import components.VideoLink.Settings
import components.VideoLink.Title


class App {

    @Composable
    @Preview
    fun AppComponent(
        urlState: MutableState<TextFieldValue>,
        queueList: MutableList<DownloadQueue>
    ) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row {
                    Title().TitleTextInput()
                    Settings().settingsButton()
                }

                Row {
                    InputText().InputLink(urlState)
                    Download().DownloadButton(queueList,urlState)
                }

                TableQueue().downloadQueueBody( queueList)


            }
        }
    }


}
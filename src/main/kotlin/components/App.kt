package components



import DownloadQueue.TableQueue
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.VideoLink.Download
import components.VideoLink.InputText
import components.VideoLink.Settings
import components.VideoLink.Title


class App {

@Composable
@Preview
    fun AppComponent() {

    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        )  {
            Row {
                Title().TitleTextInput()
                Settings().settingsButton()
            }

            Row {
                InputText().InputLink()
                Download().DownloadButton()
            }

                TableQueue().downloadQueueBody()




        }
    }
}


}
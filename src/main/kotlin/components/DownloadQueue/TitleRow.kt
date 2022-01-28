package components.DownloadQueue

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class TitleRow {


    @Composable
    @Preview
    fun allTitles() {

        Row(Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)) {



            Text("Video", modifier = Modifier.weight(5f))
            Text("Speed", modifier = Modifier.weight(1f))
            Text("Status", modifier = Modifier.weight(1f))
            Text("Estimated", modifier = Modifier.weight(1f))

        }

    }
}
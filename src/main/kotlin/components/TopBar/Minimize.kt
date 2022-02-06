package components.TopBar

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

class Minimize {


    @Composable
    @Preview
    fun minimizeButton(windowState: WindowState) {

        Card(
            modifier = Modifier.size(25.dp),
            shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 5.dp),
            backgroundColor = Color(0xff041C32)

        ) {

            Image(
                painterResource(resourcePath = "TopBar/minimize.png"),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(5.dp).clickable {
                    windowState.isMinimized = true
                }
            )
        }
    }
}

fun main (){



    val string = """
   this the output
[archive.org] ThePrincessBrideTrailer: Downloading webpage   this the output
[archive.org] ThePrincessBrideTrailer: Downloading JSON metadata   this the output
[download] Destination: THE PRINCESS BRIDE trailer.-ThePrincessBrideTrailer.mp4   this the output
   this the output
[download]   0.0% of 20.43MiB at 507.60KiB/s ETA 00:41   this the output
[download]   0.0% of 20.43MiB at  1.29MiB/s ETA 00:15   this the output
[download]   0.0% of 20.43MiB at  2.69MiB/s ETA 00:07   this the output
[download]   0.1% of 20.43MiB at  5.22MiB/s ETA 00:03   this the output
[download]   0.1% of 20.43MiB at  9.45MiB/s ETA 00:02   this the output
[download]   0.3% of 20.43MiB at 328.98KiB/s ETA 01:03   this the output
[download]   0.6% of 20.43MiB at 329.36KiB/s ETA 01:03   this the output
[download]   1.2% of 20.43MiB at 295.25KiB/s ETA 01:09   this the output
[download]   2.4% of 20.43MiB at 231.91KiB/s ETA 01:27   this the output
[download]   3.4% of 20.43MiB at 229.07KiB/s ETA 01:28   this the output
[download]   4.4% of 20.43MiB at 238.83KiB/s ETA 01:23   this the output
[download]   5.7% of 20.43MiB at 248.74KiB/s ETA 01:19   this the output
[download]   7.1% of 20.43MiB at 237.89KiB/s ETA 01:21   this the output
[download]   8.1% of 20.43MiB at 225.36KiB/s ETA 01:25   this the output
[download]   8.9% of 20.43MiB at 207.41KiB/s ETA 01:31   this the output
[download]   9.4% of 20.43MiB at 201.71KiB/s ETA 01:33   this the output
[download]  10.1% of 20.43MiB at 200.44KiB/s ETA 01:33   this the output
[download]  10.9% of 20.43MiB at 203.08KiB/s ETA 01:31   this the output
[download]  12.1% of 20.43MiB at 210.04KiB/s ETA 01:27   this the output
[download]  13.6% of 20.43MiB at 218.67KiB/s ETA 01:22   this the output

Process finished with exit code 0

    """.trimIndent()


//  get KiB/s from 99 to 999 with regex
    val regex = Regex("""(\d+\.\d+)MiB/s""")


    val speed = regex.findAll(string).map { it.value }.toList()



    println(speed)


}
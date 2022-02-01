package `Data Structure`

import Util.TerminalCommands
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import java.io.BufferedReader
import java.io.InputStreamReader


data class DownloadQueue(
    var id: String? = null,
    var name: MutableState<String>,
    var url: String,
    var status: MutableState<Float>?= null,
    var remainingTime: String? = null,
    var speed: String? = null,
)

data class Queue(val value: DownloadQueue? = null, var next: Queue? = null) {

    fun enqueue(value: DownloadQueue) {
        if (next == null) {
            next = Queue(value)
        } else {
            next?.enqueue(value)
        }
    }

    fun deQueue(): Queue? {
        return if (next == null) {
            null
        } else {
            next
        }
    }



    fun returnQueue(): Queue? {
        return if (next == null) {
            null
        } else {
            next
        }
    }


}


fun main (){



    val rt = Runtime.getRuntime()
    val commands = arrayOf("wsl ", "-d", "Alpine", "bash", "-c", "youtube-dl https://www.youtube.com/watch?v=Vj4Y1c-DSM0")
    val proc = rt.exec(commands)

    val stdInput = BufferedReader(InputStreamReader(proc.inputStream))
    val stdError = BufferedReader(InputStreamReader(proc.errorStream))

    var str = ""

    while (stdInput.readLine().also { str = it } != null) {
        println("$str this is the output")
    }

    while (stdError.readLine().also { str = it } != null) {
        println("$str this is the error")
    }







}



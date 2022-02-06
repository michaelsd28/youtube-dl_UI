package Util

import `Data Structure`.DownloadQueue
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import java.io.BufferedReader
import java.io.InputStreamReader

class TerminalCommands {

    val retrieveTerminalOutput = RetrieveTerminalOutput()


    fun printColor(text: String, color: String) {
        println("\u001B[${color}m${text}\u001B[0m")
    }

    fun downloadSimulation(videoURL: String, state: MutableState<DownloadQueue>) {


        println("$videoURL this the video url")

        val t1 = Thread {


            val rt = Runtime.getRuntime()

            ///cmd timeout


            val commands = arrayOf("wsl", "-d", "Ubuntu", "bash", "-c", "youtube-dl $videoURL")
            val proc = rt.exec(commands)

            val stdInput = BufferedReader(InputStreamReader(proc.inputStream))
            val stdError = BufferedReader(InputStreamReader(proc.errorStream))
            var str: String = " hi"
            try {
                while (stdInput.readLine().also { println(it);state.value.name.value = it } != null) {


                    println(str)
                    println("$str ${retrieveTerminalOutput.getDownloadPercentageInFloat(str)} this the percentage 2")
                }
                while (stdError.readLine().also { str = it } != null) {
                    print(str)

                }

            } catch (e: Exception) {
                println("error in line: ${e.printStackTrace()}")
            }


        }
        t1.start()


    }

    fun downloadVideo(videoURL: String, videoState: MutableState<DownloadQueue>) {


        println("$videoURL this the video url and video state is: ")
        val t1 = Thread {

            try {

                val rt = Runtime.getRuntime()
                var isNamed = false
                var isRemaining = false
                var isSpeed = false

                val commands = arrayOf("wsl", "-d", "Ubuntu", "bash", "-c", "youtube-dl $videoURL")
                val proc = rt.exec(commands)


                val stdInput = BufferedReader(InputStreamReader(proc.inputStream))
                val stdError = BufferedReader(InputStreamReader(proc.errorStream))
                var str: String = ""


                while (stdInput.readLine()
                        .also { printColor("$str   this the output", "33");str = it } != null
//                    printColor("$str   this the output","33")
                ) {
                    printColor("${retrieveTerminalOutput.getDownloadSpeed(str)} this the speed", "35")

                    if (!isNamed && retrieveTerminalOutput.getVideoTitle(str) != "Unknown") {
                        videoState.value.name.value = retrieveTerminalOutput.getVideoTitle(str)
                        isNamed = true
                    }

                    if (str.isNotEmpty()) {



                        videoState.value.status!!.value = retrieveTerminalOutput.getDownloadPercentageInFloat(str)
                    }

                    if(!isRemaining && retrieveTerminalOutput.getDownloadRemainingTime(str) != ""){
                        videoState.value.remainingTime =
                            mutableStateOf(retrieveTerminalOutput.getDownloadRemainingTime(str))
                        isRemaining = true
                    }

                    if( retrieveTerminalOutput.getDownloadSpeed(str) != ""){
                        videoState.value.speed.value = retrieveTerminalOutput.getDownloadSpeed(str)
                    }

                    if(retrieveTerminalOutput.getDownloadRemainingTime(str) != ""){
                        videoState.value.remainingTime.value = retrieveTerminalOutput.getDownloadRemainingTime(str)
                    }




                }

                stdError.readLine().also { println("$it this is the error"); str = it }

            } catch (e: Exception) {

                println("error in line: ${e.printStackTrace()}")
            }


        }
        t1.start()


    }


    fun downloadAudio(url: String) {
        println("Downloading audio from $url")
    }

    fun getVideoInfo(url: String) {
        println("Getting video info from $url")
    }

    fun getVideoTitle(url: String) {

        val t2 = Thread {


            val rt = Runtime.getRuntime()
            val commands = arrayOf("wsl ", "-d", "Ubuntu-20.04", "bash", "-c", "youtube-dl $url --get-filename")

            val proc = rt.exec(commands)

            val stdInput = BufferedReader(InputStreamReader(proc.inputStream))
            val stdError = BufferedReader(InputStreamReader(proc.errorStream))


// Read the output from the command
            var title: String? = null
            while (stdInput.readLine().also { title = it } != null) {

                println("$title this is the title")


//                println(title?.substring(0, title!!.length - 16))
            }


            // Read any errors from the attempted command
            while (stdError.readLine().also { title = it } != null) {
                print(title)
            }

        }
        t2.start()

    }

    fun getPlaylistInfo(url: String) {
        println("Getting playlist info from $url")
    }


}
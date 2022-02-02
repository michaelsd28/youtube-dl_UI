package Util

import `Data Structure`.DownloadQueue
import androidx.compose.runtime.MutableState
import java.io.BufferedReader
import java.io.InputStreamReader

class TerminalCommands {

    val retrieveTerminalOutput = RetrieveTerminalOutput()

    fun downloadSimulation(state: MutableState<DownloadQueue>) {

        val t1 = Thread {

            val rt = Runtime.getRuntime()
            ///cmd timeout

            val commands = arrayOf("cmd", "/c", "python", "-u", "CountdownTest.py")
            val proc = rt.exec(commands)

            val stdInput = BufferedReader(InputStreamReader(proc.inputStream))
            val stdError = BufferedReader(InputStreamReader(proc.errorStream))
            var str: String = " hi"
            try {

                while (stdInput.readLine().also { state.value.name.value = it;str = it } != null) {
                    println(str)
                    println("$str ${retrieveTerminalOutput.getDownloadPercentageInFloat(str)} this the percentage 2")




                }

                while (stdError.readLine().also { state.value.name.value = it;str = it } != null) {
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
                val commands = arrayOf("wsl ", "-d", "Alpine", "bash", "-c", "youtube-dl $videoURL")
                val proc = rt.exec(commands)


                val stdInput = BufferedReader(InputStreamReader(proc.inputStream))
                val stdError = BufferedReader(InputStreamReader(proc.errorStream))
                var str: String = " hi my friend"


                while (stdInput.readLine() != null) {

                    if (stdInput.readLine() != null) {
                        str = stdInput.readLine().also { str = it }
                        println("$str  this the output")
                    }





                    if (retrieveTerminalOutput.getVideoTitle(str).toString() != "") {
                        videoState.value.name.value = retrieveTerminalOutput.getVideoTitle(str).toString()
                    }

                    if (retrieveTerminalOutput.getDownloadPercentageInFloat(str) != null) {
                        videoState.value.status!!.value = retrieveTerminalOutput.getDownloadPercentageInFloat(str)!!
                    }

                    videoState.value.remainingTime = retrieveTerminalOutput.getDownloadRemainingTime(str)
                    videoState.value.speed = retrieveTerminalOutput.getDownloadSpeed(str)


                }

                while (stdError.readLine() != null) {
                    if (stdInput.readLine() != null) {
                        str = stdInput.readLine().also { str = it }

                    }
                    print("$str this is the error")
                }

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

                println(title?.substring(0, title!!.length - 16))
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
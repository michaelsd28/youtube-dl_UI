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

                while (stdInput.readLine().also { str = it } != null) {


                    state.value.name.value =str
                    state.value.remainingTime = retrieveTerminalOutput.getDownloadRemainingTime(str)
                    state.value.speed = retrieveTerminalOutput.getDownloadSpeed(str)
                    state.value.status = retrieveTerminalOutput.getDownloadPercentageInFloat(str)

                    println(retrieveTerminalOutput.getDownloadRemainingTime(str))

                    println(str)
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

    fun downloadVideo(url: String, state: MutableState<String>) {
        val rt = Runtime.getRuntime()
        val commands = arrayOf("wsl ", "-d", "Ubuntu-20.04", "bash", "-c", "youtube-dl $url")
        val proc = rt.exec(commands)

        val stdInput = BufferedReader(InputStreamReader(proc.inputStream))
        val stdError = BufferedReader(InputStreamReader(proc.errorStream))

// Read the output from the command

// Read the output from the command
        var s: String? = null
        while (stdInput.readLine().also { s = it } != null) {
            state.value = s.toString()
            println(s)
        }

        // Read any errors from the attempted command

// Read any errors from the attempted command
        while (stdError.readLine().also { s = it } != null) {
            print(s)
        }
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

// Read the output from the command
        var title: String? = null
        while (stdInput.readLine().also { title = it } != null) {
            println(title?.substring(0, title!!.length - 16))
        }

        // Read any errors from the attempted command

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
package Util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class RetrieveTerminalOutput {


    ///working
    fun getVideoSize(data: String): String {

        return try {
            val videoSizeRegex = Regex("[0-9]{1,2}\\.[0-9]{1,2}MiB\\s")
            val videoSize = videoSizeRegex.find(data)!!.value
            videoSize
        } catch (e: Exception) {

            val videoSizeRegex = Regex("[0-9]{1,2}\\.[0-9]{1,2}KiB\\s")
            val videoSizeRegexGiB = Regex("[0-9]{1,2}\\.[0-9]{1,2}GiB\\s")

            if (videoSizeRegexGiB.find(data) != null) {
                val videoSize = videoSizeRegexGiB.find(data)!!.value
                videoSize
            } else if (videoSizeRegex.find(data) != null) {
                val videoSize = videoSizeRegex.find(data)!!.value
                videoSize
            } else {
                "0.0KiB"
            }
        }

    }


    /// working
    fun getDownloadSpeed(data: String): String {
        val regexKiB = Regex("""(\d+\.\d+)KiB/s""")
        val regexMiB = Regex("""(\d+\.\d+)MiB/s""")

        val valueKiB = regexKiB.find(data)
        val valueMiB = regexMiB.find(data)

        return valueKiB?.value ?: (valueMiB?.value ?: "0.0KiB/s")


    }


    ///working
    fun getDownloadPercentage(data: String): String {
        val percentageRegex = Regex("..[0-9]{1,3}%")
        val percentage = percentageRegex.find(data)
        return percentage?.groups?.get(0)?.value ?: "0"
    }

    ///working
    fun getDownloadPercentageInFloat(data: String): Float {


        val percentageRegex = Regex(".([0-9].{1,3}%)")
        val percentage = percentageRegex.find(data)
        val value = percentage?.groups?.get(0)?.value?.replace("%", "")


        return if (value != null) {
            value.toFloat() / 100
        } else {
            0f
        }


    }


    //working
    fun getDownloadRemainingTime(data: String): String {

        return if (data.contains("has already been downloaded")) {
            "✔️"
        } else {
            val regex = Regex("ETA ([0-9]{2}:[0-9]{2})")
            val matchResult = regex.find(data)
            if (matchResult != null) {
                matchResult.groupValues[1]
            } else {
                "✔️"
            }

        }


    }


    fun getVideoTitle(data: String): String {

        return if (data.contains("Destination: ")) {
            val regex = Regex("""Destination: (.*)""")
            val match = regex.find(data)
            val title = match?.groupValues?.get(1)?.substringBefore("-")
            title ?: "Unknown"
        } else {

            val regex = Regex("""\[download\] (.*)""")
            val match = regex.find(data)
            val title = match?.groupValues?.get(1)?.substringBefore("-")

            title ?: "Unknown"

        }


    }

}






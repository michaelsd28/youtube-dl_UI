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

        return try {
            val regexKiB = Regex("[0-9]{1,3}\\.[0-9]{1,3}KiB/s")
            val valuesKiB = regexKiB.find(data)
            valuesKiB!!.groupValues[0]
        } catch (e: Exception) {
            val regexMiB = Regex("[0-9]{1,3}\\.[0-9]{1,3}MiB/s")
            val valuesMiB = regexMiB.find(data)
            if (valuesMiB != null) {
                valuesMiB.groupValues[0]
            } else {
                "0.0KiB/s"
            }
        }


    }


    ///working
    fun getDownloadPercentage(data: String): String {
        val percentageRegex = Regex("..[0-9]{1,3}%")
        val percentage = percentageRegex.find(data)
        return percentage?.groups?.get(0)?.value ?: "0"
    }

    ///working
    fun getDownloadPercentageInFloat(data: String): Float? {



        val percentageRegex = Regex(".([0-9].{1,3}%)")
        val percentage = percentageRegex.find(data)
        val value =  percentage?.groups?.get(0)?.value?.replace("%","")




        return if (value != null) {
            value.toFloat() / 100
        } else {
            null
        }


    }


    //working
    fun getDownloadRemainingTime(data: String): String {
        val regex = Regex("ETA ([0-9]{2}:[0-9]{2})")
        val matchResult = regex.find(data)

        return "${matchResult?.groupValues?.get(1)}s"

    }


    fun getVideoTitle(data: String): String? {

        var firstValue: String? = ""


        val getTitleRegex = Regex("Destination: (.*)...................")
        val getTitle = getTitleRegex.find(data)

        if (getTitle?.groupValues?.get(1) != null) {
            firstValue = getTitle.groupValues[1]
        }

        return firstValue
    }

}






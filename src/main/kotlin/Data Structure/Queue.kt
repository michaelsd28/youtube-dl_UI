package `Data Structure`

import androidx.compose.runtime.MutableState


data class DownloadQueue(
    val id: String? = null,
    var name: MutableState<String>,
    val url: String? = null,
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

    fun print() {
        println(value)
        if (next != null) {
            next!!.print()
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


fun main() {

//    val queue:DownloadQueue = DownloadQueue("1","test","https://www.google.com","pending","0")

//    val myQueue = Queue(queue)
//    myQueue.enqueue(queue)
//    myQueue.enqueue(queue)

//    kotlin convert class to json

//    import Gson

//    val json  = Gson().toJson(myQueue)


//  println(json)
}
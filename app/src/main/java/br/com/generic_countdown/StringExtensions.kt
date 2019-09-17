package br.com.generic_countdown


fun Long.toHourString(): String {
    var millisecondsValue = this

    var hours = 0L
    var minutes = 0L
    var seconds = 0L

    val secondsToMilliseconds = 1000
    val minutesToMilliseconds = 60*secondsToMilliseconds
    val hoursToMilliseconds = 60*minutesToMilliseconds

    if(millisecondsValue> hoursToMilliseconds) {
        hours = millisecondsValue/(hoursToMilliseconds)
    }

    millisecondsValue -= hours*hoursToMilliseconds

    if(millisecondsValue > minutesToMilliseconds) {
        minutes = millisecondsValue / minutesToMilliseconds
    }

    millisecondsValue -= minutes*minutesToMilliseconds

    if(millisecondsValue > secondsToMilliseconds) {
        seconds = millisecondsValue / secondsToMilliseconds
    }

    val hoursString = if(hours <= 0) "00" else if(hours < 10) "0$hours" else "$hours"
    val minutesString = if(minutes <= 0) "00" else if(minutes < 10) "0$minutes" else "$minutes"
    val secondsString = if(seconds <= 0) "00" else if(seconds < 10) "0$seconds" else "$seconds"

    return "$hoursString:$minutesString:$secondsString"
}
package ru.netology

fun main() {
    println(agoToText(17999, "Vasya"))
}


fun agoToText(sec: Int, userName: String): String {
    val secInMinutes = sec / 60
    val secInHours = secInMinutes / 60
    val howManyInHour = 60 * 60
    val howManyInDay = 24 * 60 * 60
    val secToText = when (sec) {
        in (0 until 60) -> "только что"
        in (60 until howManyInHour) -> "$secInMinutes ${minutesEnding(sec)} назад"
        in (howManyInHour until howManyInDay) -> "$secInHours ${hoursEnding(sec)} назад"
        in (howManyInDay until 2 * howManyInDay) -> "сегодня"
        in (2 * howManyInDay until 3 * howManyInDay) -> "вчера"
        else -> "давно"
    }
    return "$userName был(а) в сети $secToText"
}


fun minutesEnding(sec: Int): String {
    val lastNumber = (sec / 60) % 10
    val firstNumber = ((sec / 60) % 100) / 10
    return when {
        firstNumber == 1 -> "минут"
        lastNumber == 1 -> "минуту"
        lastNumber == 2 || lastNumber == 3 || lastNumber == 4 -> "минуты"
        else -> "минут"
    }
}

fun hoursEnding(sec: Int): String {
    val lastNumber = (sec / (60 * 60)) % 10
    val firstNumber = ((sec / (60 * 60)) % 100) / 10
    return when {
        firstNumber == 1 -> "часов"
        lastNumber == 1 -> "час"
        lastNumber == 2 || lastNumber == 3 || lastNumber == 4 -> "часа"
        else -> "часов"
    }
}
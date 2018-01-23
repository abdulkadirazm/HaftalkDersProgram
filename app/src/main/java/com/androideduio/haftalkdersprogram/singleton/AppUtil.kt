package com.androideduio.haftalkdersprogram.singleton

import com.androideduio.haftalkdersprogram.enums.Days
import com.androideduio.haftalkdersprogram.models.LessonModel


/****************************|
 * Created by Gökhan ÖZTÜRK  |
 * 20.01.2018                |
 * CodeProject.G@gmail.com   |
 ****************************/

/**
 * Singleton yapisini kullanmanin en hizli yolu "object" ifadesini kullanmak.
 * Yanlis kullanimin memmory leak'e goturecegini unutmayin.
 */
object AppUtil {

    fun getLessonList(): ArrayList<LessonModel> {

        val lessonList = ArrayList<LessonModel>()

        var lessonModel = LessonModel("ATA 151", "Atatürk İlkeleri Ve İnkılap Tarihi I")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("ATA 152", "Atatürk İlkeleri ve İnkılap Tarihi II")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 105", "Introduction To Computer Engineering")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 133", "Algorithms and Programming I")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 134", "Algorithms and Programming II")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 221", "Computer Organization")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 223", "Digital System Design")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 235", "Data Structures")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 251", "Fundamentals of Electronics")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 252", "Fundamentals of Signals and Systems")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 302", "Operating Systems")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 321", "Logic Circuits Design")
        lessonList.add(lessonModel)

        lessonModel = LessonModel("CEN 322", "Programmable Digital Systems")
        lessonList.add(lessonModel)

        return lessonList
    }

    fun getNextDay(day: String): String {

        return when (day) {

            Days.Pazartesi.toString() -> {

                Days.Salı.toString()
            }

            Days.Salı.toString() -> {

                Days.Çarşamba.toString()
            }

            Days.Çarşamba.toString() -> {

                Days.Perşembe.toString()
            }

            Days.Perşembe.toString() -> {

                Days.Cuma.toString()
            }

            Days.Cuma.toString() -> {

                Days.Pazartesi.toString()
            }

            else -> {
                ""
            }
        }
    }
}
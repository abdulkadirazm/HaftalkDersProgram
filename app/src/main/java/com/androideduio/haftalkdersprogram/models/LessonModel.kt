package com.androideduio.haftalkdersprogram.models


/****************************|
 * Created by Gökhan ÖZTÜRK  |
 * 20.01.2018                |
 * CodeProject.G@gmail.com   |
 ****************************/

/**
 * Basit bir data class'i yazildi. Bu class'tan olusturulan nesnelerde toString() methodu cagirilirsa,
 * sadece lessonName'i donmesi saglandı. toString() methodu override edilmese class'in tamamini String'e cevirip donecekti.
 */
data class LessonModel(val lessonCode: String, val lessonName: String) {

    override fun toString(): String {
        return lessonName
    }
}
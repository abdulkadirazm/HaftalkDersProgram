package com.androideduio.haftalkdersprogram.enums


/****************************|
 * Created by Gökhan ÖZTÜRK  |
 * 20.01.2018                |
 * CodeProject.G@gmail.com   |
 ****************************/

/**
 * Cesitli enum'lar yazildi.
 * Enum ile bu enum kullanildiginda alinmak istenen deger birbirinden farkli olursa toString methodu ovveride edilebilir.
 */
enum class ViewModelEnum {

    UserName {
        override fun toString(): String {
            return "UserName"
        }
    },

    ResultViewModel {
        override fun toString(): String {
            return "ResultViewModel"
        }
    }
}
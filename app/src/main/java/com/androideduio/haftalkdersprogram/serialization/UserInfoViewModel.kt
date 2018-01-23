package com.androideduio.haftalkdersprogram.serialization

import java.io.Serializable


/****************************|
 * Created by Gökhan ÖZTÜRK  |
 * 20.01.2018                |
 * CodeProject.G@gmail.com   |
 ****************************/

/**
 * data class'i olusturulur.
 * Serializable'dan implement edilir.
 * primary constructor yardimi ile ya da disaridan degiskenler alinir.
 */
data class UserInfoViewModel(val userName: String) : Serializable
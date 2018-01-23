package com.androideduio.haftalkdersprogram.interfaces


/****************************|
 * Created by Gökhan ÖZTÜRK  |
 * 20.01.2018                |
 * CodeProject.G@gmail.com   |
 ****************************/

/**
 * Fragment'lardan Activity'lere veri tasimak icin interface olusturuldu.
 * onFragmentInteraction() methodu icinde tasinacak methodlar yazildi.
 */
interface OnFragmentInteractionListener {

    fun onFragmentInteraction(day: String, lessonList: ArrayList<String>)
}
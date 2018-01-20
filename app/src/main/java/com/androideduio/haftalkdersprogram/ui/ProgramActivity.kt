package com.androideduio.haftalkdersprogram.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androideduio.haftalkdersprogram.R
import com.androideduio.haftalkdersprogram.enums.ViewModelEnum
import com.androideduio.haftalkdersprogram.interfaces.OnFragmentInteractionListener
import com.androideduio.haftalkdersprogram.serialization.UserInfoViewModel

class ProgramActivity : AppCompatActivity(), OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program)

        val bundle = intent.extras
        val userName: UserInfoViewModel = bundle.getSerializable(ViewModelEnum.UserName.toString()) as UserInfoViewModel

        val dayFragment = DayFragment.newInstance(userName.userName)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_program_frmFragment, dayFragment)
    }

    override fun onFragmentInteraction(day: String, lessonList: ArrayList<String>) {

    }
}

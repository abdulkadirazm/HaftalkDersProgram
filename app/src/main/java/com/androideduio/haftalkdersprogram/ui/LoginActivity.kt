package com.androideduio.haftalkdersprogram.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.androideduio.haftalkdersprogram.R
import com.androideduio.haftalkdersprogram.enums.ViewModelEnum
import com.androideduio.haftalkdersprogram.serialization.UserInfoViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        activity_login_btnLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        val userInfo = UserInfoViewModel(activity_login_edtUserName.text.toString())

        val intent = Intent(this, ProgramActivity::class.java)

        intent.putExtra(ViewModelEnum.UserName.toString(), userInfo)

        startActivity(intent)
    }
}

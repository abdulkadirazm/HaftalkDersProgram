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

    override fun onClick(view: View?) {

        // intent'de gonderilecek ViewModel nesnesini olustur.
        val userInfo = UserInfoViewModel(activity_login_edtUserName.text.toString())

        // intent olustur. context'i ver ve gidecegi activity'i belirt.
        val intent = Intent(this, ProgramActivity::class.java)

        // intent ile tasinacak bir veri varsa key, value seklinde bunlari ver.
        intent.putExtra(ViewModelEnum.UserName.toString(), userInfo)

        // intent'i gonder.
        startActivity(intent)
    }
}

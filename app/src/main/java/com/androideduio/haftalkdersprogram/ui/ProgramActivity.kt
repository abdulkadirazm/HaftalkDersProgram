package com.androideduio.haftalkdersprogram.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.androideduio.haftalkdersprogram.R
import com.androideduio.haftalkdersprogram.enums.Days
import com.androideduio.haftalkdersprogram.enums.ViewModelEnum
import com.androideduio.haftalkdersprogram.interfaces.OnFragmentInteractionListener
import com.androideduio.haftalkdersprogram.parcelable.ResultViewModel
import com.androideduio.haftalkdersprogram.serialization.UserInfoViewModel
import com.androideduio.haftalkdersprogram.singleton.AppUtil

class ProgramActivity : AppCompatActivity(), OnFragmentInteractionListener {

    var day = Days.Pazartesi.toString()
    private var userInfoViewModel: UserInfoViewModel? = null

    private var lessonsByDays = LinkedHashMap<String, ArrayList<String>>()
    private var dayFragment: Fragment? = null
    private var fragmentManager: FragmentManager? = null
    private var fragmentTransaction: FragmentTransaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program)

        // activity'i ayaga kaldiran intent icerisinden bundle bilgisini cek.
        val bundle = intent.extras
        // bu bundle bilgisinden gelen serializable edilmis nesneyi cek ve ilgili class'a cast et.
        userInfoViewModel = bundle.getSerializable(ViewModelEnum.UserName.toString()) as UserInfoViewModel


        // TODO 1 fragment olustur
        dayFragment = DayFragment.newInstance(userInfoViewModel!!.userName)

        // TODO 2 yaratilan fragment support v4 ise supportFragmnetManager'i al. Degilse fragentManager'i al.
        fragmentManager = supportFragmentManager
        // TODO 3 fragmentManager alindiktan sonra transaction baslat.
        fragmentTransaction = fragmentManager!!.beginTransaction()

        // TODO 4 transaction.add methodu yardimi ile activity layout'u uzerindeki bir frameLayout'a fragment'i ekle.
        fragmentTransaction!!.add(R.id.activity_program_frmFragment, dayFragment)

        // TODO 5 islemin bittigini belirtmek icin commit()'i cagir.
        fragmentTransaction!!.commit()
    }

    override fun onFragmentInteraction(day: String, lessonList: ArrayList<String>) {

        Toast.makeText(this, "Interface tıklandı.", Toast.LENGTH_SHORT).show()

        lessonsByDays[day] = lessonList

        this.day = AppUtil.getNextDay(day)

        if (!day.equals(Days.Cuma.toString(), ignoreCase = true)) {

            //fragment ekleme islemi gibi devam edilir; ancak replace() methodu ile ilgili framelayout uzerindeki
            //fragment yeni fragment ile yer degistirir.
            dayFragment = DayFragment.newInstance(userInfoViewModel!!.userName)
            fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction!!.replace(R.id.activity_program_frmFragment, dayFragment)
            fragmentTransaction!!.commit()
        } else {

            val resultViewModel = ResultViewModel()

//            val resultFragmentListView = ResultFragmentListView.newInstance(resultViewModel)
            val resultFragmentRecyclerView = ResultFragmentRecyclerView.newInstance(resultViewModel)

            resultViewModel.lessonsByDays = lessonsByDays

            fragmentTransaction = fragmentManager!!.beginTransaction()

//            fragmentTransaction!!.replace(R.id.activity_program_frmFragment, resultFragmentListView)
            fragmentTransaction!!.replace(R.id.activity_program_frmFragment, resultFragmentRecyclerView)
            fragmentTransaction!!.commit()
        }
    }
}

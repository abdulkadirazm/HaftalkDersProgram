package com.androideduio.haftalkdersprogram.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.androideduio.haftalkdersprogram.R
import com.androideduio.haftalkdersprogram.enums.Days
import com.androideduio.haftalkdersprogram.enums.ViewModelEnum
import com.androideduio.haftalkdersprogram.interfaces.OnFragmentInteractionListener
import com.androideduio.haftalkdersprogram.singleton.AppUtil
import java.util.*


class DayFragment : Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    //interfaces
    private var mListener: OnFragmentInteractionListener? = null

    //ui components
    private lateinit var masterView: View

    private val txtDayName: TextView by lazy { masterView.findViewById<TextView>(R.id.fragment_day_txtDayName) }
    private val txtUserName: TextView by lazy { masterView.findViewById<TextView>(R.id.fragment_day_txtUserName) }

    private val incLesson1: LinearLayout by lazy { masterView.findViewById<LinearLayout>(R.id.fragment_day_incLesson1) }
    private val txtLesson1: TextView by lazy { incLesson1.findViewById<TextView>(R.id.common_view_lesson_choose_txtLesson) }
    private val spnLesson1: Spinner by lazy { incLesson1.findViewById<Spinner>(R.id.common_view_lesson_choose_spnLesson) }

    private val incLesson2: LinearLayout by lazy { masterView.findViewById<LinearLayout>(R.id.fragment_day_incLesson2) }
    private val txtLesson2: TextView by lazy { incLesson2.findViewById<TextView>(R.id.common_view_lesson_choose_txtLesson) }
    private val spnLesson2: Spinner by lazy { incLesson2.findViewById<Spinner>(R.id.common_view_lesson_choose_spnLesson) }

    private val incLesson3: LinearLayout by lazy { masterView.findViewById<LinearLayout>(R.id.fragment_day_incLesson3) }
    private val txtLesson3: TextView by lazy { incLesson3.findViewById<TextView>(R.id.common_view_lesson_choose_txtLesson) }
    private val spnLesson3: Spinner by lazy { incLesson3.findViewById<Spinner>(R.id.common_view_lesson_choose_spnLesson) }

    private val incLesson4: LinearLayout by lazy { masterView.findViewById<LinearLayout>(R.id.fragment_day_incLesson4) }
    private val txtLesson4: TextView by lazy { incLesson4.findViewById<TextView>(R.id.common_view_lesson_choose_txtLesson) }
    private val spnLesson4: Spinner by lazy { incLesson4.findViewById<Spinner>(R.id.common_view_lesson_choose_spnLesson) }

    private val btnContinue: Button by lazy { masterView.findViewById<Button>(R.id.fragment_day_btnContinue) }

    //variable
    private lateinit var userName: String
    private var flagFirstTime = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {

            userName = arguments!!.getString(ViewModelEnum.UserName.toString())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        masterView = inflater.inflate(R.layout.fragment_day, container, false)

        initEvent()

        return masterView
    }

    private fun initEvent() {

        // activity uzerindeki public degiskenlere erismek icin activity bilgisi uzerine eklendigimiz activity mi diye kontrol et.
        // Eger oyle ise cast islemi yap ve publis degiskenlere ya da methodlara eris.
        if (activity is ProgramActivity) {
            txtDayName.text = (activity as ProgramActivity).day

            if ((activity as ProgramActivity).day.equals(Days.Cuma.toString(), ignoreCase = true)) {
                btnContinue.text = "Sonuç"
            }
        }

        txtUserName.text = userName
        txtLesson1.text = "Ders1"
        txtLesson2.text = "Ders2"
        txtLesson3.text = "Ders3"
        txtLesson4.text = "Ders4"

        btnContinue.setOnClickListener(this)

        // TODO 1 spinner icin adapter yarat.
        /**
         * context olarak activity'i ver.
         * id degeri olarak ekran acildiginda gorulecek olan text'in layoutunu ver.
         * Default bir layout Android Framework'unde bulundugu icin android.R'den aliniyor.
         * Bu spinner icerisinde gosterilecek listeyi ver.
         */
        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, AppUtil.getLessonList())

        // TODO 2 setDropDownViewResource() ile acilir penceredeki item'larin nasil gorunecegini belirt.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // TODO 3 adapter'i spinner'lara ata.
        spnLesson1.adapter = adapter
        spnLesson2.adapter = adapter
        spnLesson3.adapter = adapter
        spnLesson4.adapter = adapter

        spnLesson1.setSelection(2)

        spnLesson1.onItemSelectedListener = this
    }

    //devam butonu onClick listener'i
    override fun onClick(view: View?) {

        val day: String = txtDayName.text.toString()
        val lessonList = ArrayList<String>()

        lessonList.add(spnLesson1.selectedItem.toString())
        lessonList.add(spnLesson2.selectedItem.toString())
        lessonList.add(spnLesson3.selectedItem.toString())
        lessonList.add(spnLesson4.selectedItem.toString())

        if (mListener != null) {
            mListener!!.onFragmentInteraction(day, lessonList)
        }
    }

    //spinner acilir; ancak herhangi bir secim yapilmazsa calisir.
    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(activity, "Spinner tıklandı", Toast.LENGTH_SHORT).show()
    }

    //spinner'da bir sey secilirse ya da setSelection() methodu cagrilirsa calisir.
    //flagFirstTime, burada calisacak logic'in setSelection() cagirimi sirasinda ilk sefer icin sadece calismamasini saglamak icin.
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        if (flagFirstTime) {
            Toast.makeText(activity, "Spinner tıklandı", Toast.LENGTH_SHORT).show()
        } else {
            flagFirstTime = true
        }
    }

    //OnFragmentInteractionListener listener'inin fragment'in eklendigi activity'de olup olmadigini kontrol ediyor.
    //Eger yoksa RuntimeException firlatarak gelistirici uyariliyor. Varsa, listener class icindeki listener nesnesine baglaniyor.
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " OnFragmentInteractionListener'ı eklemeyi unuttun keko")
        }
    }

    //OnFragmentInteractionListener listener'i sifirlaniyor.
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    // yeni nesne yaratmak icin Singleton formati kullaniliyor.
    companion object {

        fun newInstance(userName: String): DayFragment {

            //fragment'in nesnesi yaratiliyor.
            val fragment = DayFragment()

            //bundle yaratiliyor ve method'a parametre olarak verilen bilgiler bundle'a ataniyor.
            val bundle = Bundle()
            bundle.putString(ViewModelEnum.UserName.toString(), userName)

            //bundle fragment'e arguments yardimi ile veriliyor.
            fragment.arguments = bundle

            return fragment
        }
    }
}

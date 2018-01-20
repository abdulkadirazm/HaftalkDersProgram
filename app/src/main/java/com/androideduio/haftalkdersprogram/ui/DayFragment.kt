package com.androideduio.haftalkdersprogram.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import com.androideduio.haftalkdersprogram.R
import com.androideduio.haftalkdersprogram.enums.ViewModelEnum
import com.androideduio.haftalkdersprogram.interfaces.OnFragmentInteractionListener

class DayFragment : Fragment(), View.OnClickListener {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            //    mParam1 = arguments!!.getString(ARG_PARAM1)
            //   mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        masterView = inflater.inflate(R.layout.fragment_day, container, false)

        initEvent()

        return masterView
    }

    private fun initEvent() {

        btnContinue.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        val day = txtDayName.text.toString()
        val lessonList = ArrayList<String>()

        lessonList.add(spnLesson1.selectedItem.toString())
        lessonList.add(spnLesson2.selectedItem.toString())
        lessonList.add(spnLesson3.selectedItem.toString())
        lessonList.add(spnLesson4.selectedItem.toString())

        if (mListener != null) {
            mListener!!.onFragmentInteraction(day, lessonList)
        }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    companion object {

        fun newInstance(userName: String): DayFragment {

            val fragment = DayFragment()

            val args = Bundle()
            args.putString(ViewModelEnum.UserName.toString(), userName)

            fragment.arguments = args

            return fragment
        }
    }
}

package com.androideduio.haftalkdersprogram.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.androideduio.haftalkdersprogram.R
import com.androideduio.haftalkdersprogram.adapter.LessonListAdapter
import com.androideduio.haftalkdersprogram.enums.ViewModelEnum
import com.androideduio.haftalkdersprogram.parcelable.ResultViewModel

class ResultFragmentListView : Fragment(), AdapterView.OnItemClickListener {

    //viewmodel
    private var resultViewModel = ResultViewModel()

    //component
    //ui components
    private lateinit var masterView: View

    private val listView: ListView by lazy { masterView.findViewById<ListView>(R.id.fragment_result_listView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            resultViewModel = arguments!!.getParcelable(ViewModelEnum.ResultViewModel.toString())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        masterView = inflater.inflate(R.layout.fragment_result, container, false)

        // adapter'dan item'larin listesi verilerek nesne yaratilir.
        val lessonListAdapter = LessonListAdapter(resultViewModel.lessonsByDays)
        // bu adapter listeye verilir.
        listView.adapter = lessonListAdapter

        // listedeki item'lara onItemClickListener tanimlanir.
        listView.onItemClickListener = this

        return masterView
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(activity, "Item'a tıklandı.", Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(resultViewModel: ResultViewModel): ResultFragmentListView {

            val fragment = ResultFragmentListView()

            val args = Bundle()

            args.putParcelable(ViewModelEnum.ResultViewModel.toString(), resultViewModel)

            fragment.arguments = args

            return fragment
        }
    }
}

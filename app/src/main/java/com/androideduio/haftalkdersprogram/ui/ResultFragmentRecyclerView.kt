package com.androideduio.haftalkdersprogram.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.androideduio.haftalkdersprogram.R
import com.androideduio.haftalkdersprogram.adapter.LessonListAdapterRV
import com.androideduio.haftalkdersprogram.enums.ViewModelEnum
import com.androideduio.haftalkdersprogram.parcelable.ResultViewModel


class ResultFragmentRecyclerView : Fragment(), (Map.Entry<String, ArrayList<String>>) -> Unit {

    //viewmodel
    private var resultViewModel = ResultViewModel()

    //component
    //ui components
    private lateinit var masterView: View

    private val recyclerView: RecyclerView by lazy { masterView.findViewById<RecyclerView>(R.id.fragment_result_recyclerView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            resultViewModel = arguments!!.getParcelable(ViewModelEnum.ResultViewModel.toString())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        masterView = inflater.inflate(R.layout.fragment_result_listview, container, false)

        // recyclerView'in nasil gorunecegini belirtmek icin layoutManager tanimlanir.
        // Linear ya da Grid gibi secenekleri vardir.
        val layoutManager = LinearLayoutManager(activity)

        // layoutManager set edilir.
        recyclerView.layoutManager = layoutManager

        // adapter'dan item'larin listesi verilerek nesne yaratilir.
        val lessonListAdapter = LessonListAdapterRV(resultViewModel.lessonsByDays, this)
        // bu adapter listeye verilir.
        recyclerView.adapter = lessonListAdapter

        return masterView
    }

    //onClickListener recyclerView'da tiklanan item'i verir.
    override fun invoke(p1: Map.Entry<String, ArrayList<String>>) {

        Toast.makeText(activity, "Item'a tıklandı.", Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(resultViewModel: ResultViewModel): ResultFragmentRecyclerView {

            val fragment = ResultFragmentRecyclerView()

            val args = Bundle()

            args.putParcelable(ViewModelEnum.ResultViewModel.toString(), resultViewModel)

            fragment.arguments = args

            return fragment
        }
    }
}

package com.androideduio.haftalkdersprogram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.androideduio.haftalkdersprogram.R
import kotlin.collections.Map.Entry

/******************************
 * Created by Gökhan ÖZTÜRK   |
 * 21.01.2018                 |
 * GokhanOzturk@AndroidEdu.IO |
 *****************************/

// TODO 1 Disaridan liste alinir. Array, ArrayList, Map ya da Set.
// TODO 2 BaseAdapter'dan extends edilir.
// TODO 3 getItem() override edilir.
// TODO 4 getItemId() override edilir.
// TODO 5 getCount() override edilir.
// TODO 6 getView() override edilir.


// TODO 1
class LessonListAdapter(lessonList: LinkedHashMap<String, ArrayList<String>>)

// TODO 2
    : BaseAdapter() {

    //bu kisim sadece hashmap kullaniliyor diye var. Disaridan ArrayList verilirse,
    // tempList olan her yeri disaridan gelen liste ile degistirebilirsiniz.
    private var tempList = ArrayList<Any>()

    //disardan alinan liste Set olarak ArrayList'e ataniyor. Hashmap icin yapiliyor bu islem.
    init {
        tempList.addAll(lessonList.entries)
    }

    // TODO 3
    /**
     * Override edilmesi gereken ilk method.
     * @param position'na denk gelen itemi geri donus degeri olarak vermemiz gerekiyor.
     */
    override fun getItem(position: Int): Entry<String, ArrayList<String>> = tempList[position] as Entry<String, ArrayList<String>>

    // TODO 4
    /**
     * @param position'na denek gelen item'daki ID degerini geri donus degeri olarak vermeniz gerekiyor.
     * Eger ID bilgisine ihtiyacınız yoksa 0 olarak gecebilirsiniz.
     */
    override fun getItemId(position: Int): Long = 0

    // TODO 5
    /**
     * Disardan aldiginiz listenin boyutunu donmeniz lazim.
     * getItemCount()'un geri donus degeri ne kadarsa listeniz o kadar item icerir.
     * Eger liste boyutunuz 10 olmasina ragmen siz 3 item sadece gostermek istiyorsaniz
     * 3 degerin static olarak geri donus degeri olarak vermelisiniz.
     */
    override fun getCount(): Int = tempList.size

    // TODO 6
    /**
     * @param position degeri @method getItem()'a verilerek listenin ilgili item'i donmesi saglanir.
     * @param convertView degeri eger bos ise, listedeki itemlarin gosterilecegi layout inflate edilir.
     * ve daha sonrasinda bu layout bir sonraki item'larda da kullanilmak uzere geri dondurulur.
     * Item layout'u icerisindeki component'ler kotlin nesnelerine baglanir ve deger atamalari yapilir.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //?: ifadesi null kontrolu yapar. convertview null ise inflate et, degilse convertview'a esitle.
        val itemView = convertView
                ?: LayoutInflater.from(parent.context).inflate(R.layout.adapter_lessonlist_item, parent, false)

//        var itemView: View? = null
//        if (convertView == null) {
//            itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_lessonlist_item, parent, false)
//        } else {
//            itemView = convertView
//        }

        //val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_lessonlist_item, parent, false)

        val txtDay = itemView!!.findViewById<TextView>(R.id.adapter_lessonlist_item_txtDay)
        val txtLesson1 = itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtLesson1)
        val txtLesson2 = itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtLesson2)
        val txtLesson3 = itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtLesson3)
        val txtLesson4 = itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtLesson4)

        //getItem() methoduna ilgili position'i ver ve ilgili item'in bilgilerini al.
        val item: Entry<String, ArrayList<String>> = getItem(position)

        txtDay.text = item.key
        txtLesson1.text = item.value[0]
        txtLesson2.text = item.value[1]
        txtLesson3.text = item.value[2]
        txtLesson4.text = item.value[3]

        return itemView
    }
}
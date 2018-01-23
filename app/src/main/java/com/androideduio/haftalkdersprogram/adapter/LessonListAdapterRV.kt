package com.androideduio.haftalkdersprogram.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.androideduio.haftalkdersprogram.R


/******************************
 * Created by Gökhan ÖZTÜRK   |
 * 23.01.2018                 |
 * GokhanOzturk@AndroidEdu.IO |
 *****************************/

// TODO 1 Once bir ViewHolder class'i yarat.
// TODO 2 Disaridan liste alinir. Array, ArrayList, Map ya da Set.
// TODO 3 Disaridan onItemClickListener alinir.
// TODO 4 RecyclerView.Adapter<YaratilanViewHolderIsmi>()'den extends et.
// TODO 5 getItem() methodunu yaz.
// TODO 6 onCreateViewHolder() override et.
// TODO 7 getItemCount() override et.
// TODO 8 onBindViewHolder() override et.


// TODO 2-3
class LessonListAdapterRV(lessonList: LinkedHashMap<String, ArrayList<String>>,
                          private val onClickListener: (Map.Entry<String, ArrayList<String>>) -> Unit)

// TODO 4
    : RecyclerView.Adapter<LessonListViewHolder>() {

    //bu kisim sadece hashmap kullaniliyor diye var. Disaridan ArrayList verilirse,
    // tempList olan her yeri disaridan gelen liste ile degistirebilirsiniz.
    private var tempList = ArrayList<Any>()

    //disardan alinan liste Set olarak ArrayList'e ataniyor. Hashmap icin yapiliyor bu islem.
    init {
        tempList.addAll(lessonList.entries)
    }

    // TODO 5
    /**
     * Bu method listview'lardaki override edilen bir method degildir. Kendi yazdigimiz bir method.
     * Disardan alinan listenin, verilen @param position'daki degerini geri doner.
     */
    private fun getItem(position: Int): Map.Entry<String, ArrayList<String>> = tempList[position] as Map.Entry<String, ArrayList<String>>

    // TODO 6
    /**
     * listedeki itemlarin gosterilecegi layout inflate edilir. Ve ilgili ViewHolder'dan olusturulan listeye verilir.
     * Yukarida RecyclerView.Adapter<> arayuzu icerisindeki ViewHolder ne ise onCreateViewHolder() methodu o ViewHolder
     * class'ina ait nesneyi geri donmelidir.
     */
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LessonListViewHolder {

        val convertView = LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_lessonlist_item, parent, false)
        return LessonListViewHolder(convertView)
    }

    // TODO 7
    /**
     * Disardan aldiginiz listenin boyutunu donmeniz lazim.
     * getItemCount()'un geri donus degeri ne kadarsa listeniz o kadar item icerir.
     * Eger liste boyutunuz 10 olmasina ragmen siz 3 item sadece gostermek istiyorsaniz
     * 3 degerin static olarak geri donus degeri olarak vermelisiniz.
     */
    override fun getItemCount(): Int = tempList.size

    // TODO 8
    /**
     * @param holder RecyclerView'a baglanilan ViewHolder'i geri doner.
     * Bu ViewHolder yardimi ile ViewHolder icerisinde yer alan component'lara ulasabiliriz.
     * @param position degeri @method getItem()'a verilerek listenin ilgili item'i donmesi saglanir.
     */
    override fun onBindViewHolder(holder: LessonListViewHolder, position: Int) {

        val item: Map.Entry<String, ArrayList<String>> = getItem(position)

        holder.txtDay.text = item.key
        holder.txtLesson1.text = item.value[0]
        holder.txtLesson2.text = item.value[1]
        holder.txtLesson3.text = item.value[2]
        holder.txtLesson4.text = item.value[3]

        //itemView'ina onClickListener tanimi yapilir.
        holder.itemView.setOnClickListener { onClickListener(item) }
    }
}
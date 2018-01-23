package com.androideduio.haftalkdersprogram.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.androideduio.haftalkdersprogram.R

/******************************
 * Created by Gökhan ÖZTÜRK   |
 * 23.01.2018                 |
 * GokhanOzturk@AndroidEdu.IO |
 *****************************/

// TODO 1 itemView : View donen constructor yaz.
// TODO 2 RecyclerView.ViewHolder()'dan extends et ve @param itemView'i parametre olarak ver
// TODO 3 Item layout'u icerisindeki component'ler kotlin nesnelerine baglanir. by lazy kullanmakta yarar var.

// TODO 1-2
class LessonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // TODO 3
    val txtDay: TextView by lazy { itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtDay) }
    val txtLesson1: TextView by lazy { itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtLesson1) }
    val txtLesson2: TextView by lazy { itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtLesson2) }
    val txtLesson3: TextView by lazy { itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtLesson3) }
    val txtLesson4: TextView by lazy { itemView.findViewById<TextView>(R.id.adapter_lessonlist_item_txtLesson4) }
}
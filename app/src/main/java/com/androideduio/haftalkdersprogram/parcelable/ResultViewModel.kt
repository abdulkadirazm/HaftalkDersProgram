package com.androideduio.haftalkdersprogram.parcelable

import android.os.Parcel
import android.os.Parcelable


/******************************
 * Created by Gökhan ÖZTÜRK   |
 * 20.01.2018                 |
 * GokhanOzturk@AndroidEdu.IO |
 *****************************/

// TODO 1 Tasinacak degiskenleri primary constructor'da al ya da bunlar icin degisken yarat.
// TODO 2 Parcelable'dan implements et.
// TODO 3 parcel:Parcel alan constructor'i yaz.
// TODO 4 writeToParcel() methodunu yaz.
// TODO 5 describeContents methodunu yaz.
// TODO 6 CREATOR companion object'ini yarat. Burada dikkat etmen gereken Parcelable.Creator<ParcelableSample>

// degisken disaridan aliniyor. ParcelableSample class'ındaki gibi primary constructor'dan degil.
class ResultViewModel()

// TODO 2
    : Parcelable {

    // TODO 1
    var lessonsByDays = LinkedHashMap<String, ArrayList<String>>()

    // TODO 3
    /**
     * this() ifadesi icinde beklenen primary constructor degiskenlerini parcel'den okuyarak doldur.
     * primary constructor bos ise this() ifadesi bos kalir.
     * Ancak sonrasinda {} parantezler acilir ve disaridan alinmis degisken burada parcel'den okunur.
     */
    constructor(parcel: Parcel) : this() {

        parcel.readInt()

        //hashmap'lere ozel olarak parcel'den okumayi ayri bir method'ta yaptik.
        lessonsByDays = getLessonsByDaysKeyList(parcel)
    }

    // TODO 4
    /**
     * primary constructor'dan alinan degiskenleri veya disaridan alinan degiskenler parcel'e yazilir.
     */
    override fun writeToParcel(parcel: Parcel, flags: Int) {

        // getLessonsByDaysKeyList() methodu icinde kullanilacak.
        parcel.writeInt(lessonsByDays.size)

        // hashmap'e ozel bir durum. Tum itemlar donulerek key ve value olarak parcel'e yazilir.
        for ((key, value) in lessonsByDays) {

            parcel.writeString(key)
            parcel.writeList(value)
        }

        parcel.writeMap(lessonsByDays)
    }

    // TODO 5
    /**
     * Eger Parcelable'dan implement edilmis class'imiz icerisinde child class'lar varsa
    // bu child class'larin her birinin farkli bir tanim donmesini burada saglayabiliriz.
    // Boylece Parcel'in hangi object'i yarattigini bilebiliriz.
    // Aksi halde 0 donunuz.
     */
    override fun describeContents(): Int = 0

    // TODO 6
    /**
     * CREATOR companion object'i yaratilirken dikkat edilmesi gereken seyler;
     * Parcelable.Creator<ParcelableSample> ifadesindeki <> arayuz class ismi olmalidir.
     * createFromParcel() methodu icerisinde donen @param parcel ifadesi TO-DO 3'deki parcel bekleyen constructor'a verilir.
     * newArray() methodu bos array listesi doner.
     */
    companion object CREATOR : Parcelable.Creator<ResultViewModel> {
        override fun createFromParcel(parcel: Parcel): ResultViewModel {
            return ResultViewModel(parcel)
        }

        override fun newArray(size: Int): Array<ResultViewModel?> {
            return arrayOfNulls(size)
        }
    }

    /**
     * Burasi hashmap'e ozel bir durum.
     * Parcel'den okuma yapabilmek icin, tum listeyi for dongusu ile donmeniz ve
     * tum item'lari tek tek parcel'e kayderek gecici bir listeye atmaniz gerekiyor.
     * val size = parcel.readInt() bilgisi TO-DO 4 writeToParcel() icerisinde veriliyor.
     */
    private fun getLessonsByDaysKeyList(parcel: Parcel): LinkedHashMap<String, ArrayList<String>> {

        val tempHashMap = LinkedHashMap<String, ArrayList<String>>()

        val size = parcel.readInt()

        for (item in 0..size) {

            tempHashMap[parcel.readString()] = parcel.readArrayList(String.javaClass.classLoader) as ArrayList<String>
        }

        return tempHashMap
    }
}
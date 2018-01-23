package com.androideduio.haftalkdersprogram.parcelable

import android.os.Parcel
import android.os.Parcelable


/******************************
 * Created by Gökhan ÖZTÜRK   |
 * 21.01.2018                 |
 * GokhanOzturk@AndroidEdu.IO |
 *****************************/

// TODO 1 Tasinacak degiskenleri primary constructor'da al ya da bunlar icin degisken yarat.
// TODO 2 Parcelable'dan implements et.
// TODO 3 parcel:Parcel alan constructor'i yaz.
// TODO 4 writeToParcel() methodunu yaz.
// TODO 5 describeContents methodunu yaz.
// TODO 6 CREATOR companion object'ini yarat. Burada dikkat etmen gereken Parcelable.Creator<ParcelableSample>


// TODO 1
data class ParcelableSample(val userName: String)

// TODO 2
    : Parcelable {

    // TODO 3
    /**
     * this() ifadesi icinde beklenen primary constructor degiskenlerini parcel'den okuyarak doldur.
     * primary constructor bos ise this() ifadesi bos kalir.
     * Ancak sonrasinda {} parantezler acilir ve disaridan alinmis degisken burada parcel'den okunur.
     */
    constructor(parcel: Parcel) : this(parcel.readString())

    // TODO 4
    /**
     * primary constructor'dan alinan degiskenleri veya disaridan alinan degiskenler parcel'e yazilir.
     */
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
    }

    // TODO 5
    /**
     * Eger Parcelable'dan implement edilmis class'imiz icerisinde child class'lar varsa
    // bu child class'larin her birinin farkli bir tanim donmesini burada saglayabiliriz.
    // Boylece Parcel'in hangi object'i yarattigini bilebiliriz.
    // Aksi halde 0 donunuz.
     */
    override fun describeContents(): Int {
        return 0
    }

    // TODO 6
    /**
     * CREATOR companion object'i yaratilirken dikkat edilmesi gereken seyler;
     * Parcelable.Creator<ParcelableSample> ifadesindeki <> arayuz class ismi olmalidir.
     * createFromParcel() methodu icerisinde donen @param parcel ifadesi TO-DO 3'deki parcel bekleyen constructor'a verilir.
     * newArray() methodu bos array listesi doner.
     */
    companion object CREATOR : Parcelable.Creator<ParcelableSample> {
        override fun createFromParcel(parcel: Parcel): ParcelableSample {
            return ParcelableSample(parcel)
        }

        override fun newArray(size: Int): Array<ParcelableSample?> {
            return arrayOfNulls(size)
        }
    }
}
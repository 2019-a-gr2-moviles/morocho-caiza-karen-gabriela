package com.example.mssenger

import android.os.Parcel
import android.os.Parcelable

class Mensajeria(var autor: String, var hora: String, var id_usuario: Int ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(autor)
        parcel.writeString(hora)
        parcel.writeInt(id_usuario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mensajeria> {
        override fun createFromParcel(parcel: Parcel): Mensajeria {
            return Mensajeria(parcel)
        }

        override fun newArray(size: Int): Array<Mensajeria?> {
            return arrayOfNulls(size)
        }
    }


}
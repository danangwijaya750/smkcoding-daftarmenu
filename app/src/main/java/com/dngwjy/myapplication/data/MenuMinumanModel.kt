package com.dngwjy.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by wijaya on 29/09/19
 */
@Entity
data class MenuMinumanModel(
    @PrimaryKey(autoGenerate = true)
    var idMenu:Int?=null,
    var namaMenu:String,
    var hargaMenu:String,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var gambarMenu:ByteArray?
)

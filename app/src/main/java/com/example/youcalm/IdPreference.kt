package com.example.youcalm

import android.content.Context

class IdPreference (context: Context){
    val PREFERERENCE_ID = "IdCount"
    val preference = context.getSharedPreferences("Id",Context.MODE_PRIVATE)

    fun getId() : Int{
        return preference.getInt(PREFERERENCE_ID, 0)
    }
    fun setId(countId:Int){
        val editor =preference.edit()
        editor.putInt(PREFERERENCE_ID, countId)
        editor.apply()
    }
}
package com.example.youcalm.ui.logs

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.*

class AttackModel {
    @RequiresApi(Build.VERSION_CODES.O)
    var date: String = ""
    var symptoms: String = ""
    var situation: String = ""
    var negativeThoughts: String = ""
    var id: Int = 0

    constructor(
        id: Int,
        date: String,
        symptoms: String,
        situation: String,
        negativeThoughts: String
    ) {
        this.date = date
        this.symptoms = symptoms
        this.situation = situation
        this.negativeThoughts = negativeThoughts
        this.id = id
    }

}
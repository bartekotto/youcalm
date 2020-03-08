package com.example.youcalm.ui.logs

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DB_NAME = "YOU_CALM_DB"
const val TABLE_NAME = "ATTACKS_LOGS"
const val COL_SYM = "symptoms"
const val COL_NEG = "negative_thoughts"
const val COL_DATE = "date"
const val COL_SIT = "situation"
const val COL_ID = "id"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_DATE + " VARCHAR(256), " +
                COL_NEG + " VARCHAR(256), " +
                COL_SYM + " VARCHAR(256), " +
                COL_SIT + " VARCHAR(256));"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertAttack(attackModel: AttackModel) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_DATE, attackModel.date)
        cv.put(COL_NEG, attackModel.negativeThoughts)
        cv.put(COL_SIT, attackModel.situation)
        cv.put(COL_SYM, attackModel.symptoms)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == (-1).toLong()) {
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Attack Logged!", Toast.LENGTH_SHORT).show()
        }
    }

    fun getAllData(): Cursor {
        val db = this.writableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun clearData() {
        val db = this.writableDatabase
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}
package com.example.youcalm.ui.logs

import android.app.AlertDialog
import android.database.Cursor
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.youcalm.IdPreference
import com.example.youcalm.R
import kotlinx.android.synthetic.main.fragment_logs.*
import java.time.LocalDateTime


class LogsFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewLogsBtn.setOnClickListener {
            loadLogs()
        }
        clearLogsBtn.setOnClickListener {
            clearLogs()
        }
        insert_btn.setOnClickListener {
            if (editNeg.text.isNotEmpty()
                && editSit.text.isNotEmpty()
                && editSym.text.isNotEmpty()
            ) {
                val db = DatabaseHandler(context!!.applicationContext)
                val insertDate: LocalDateTime =
                    LocalDateTime.of(editDate.year, editDate.month, editDate.dayOfMonth, 0, 0)
                val idPreference = IdPreference(context!!.applicationContext)
                val insertId: Int = idPreference.getId()
                var attackModel = AttackModel(
                    insertId,
                    insertDate.toString(),
                    editSym.text.toString(),
                    editSit.text.toString(),
                    editNeg.text.toString()
                )
                db.insertAttack(attackModel)
            } else {
                Toast.makeText(context, "Fill all the fields!", Toast.LENGTH_SHORT).show()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun loadLogs() {
        val db = DatabaseHandler(context!!.applicationContext)
        val res: Cursor = db.getAllData()
        if (res.count == 0) {
            Toast.makeText(context, "No logs!", Toast.LENGTH_SHORT).show()
        } else {
            val logsBuffer = StringBuffer()
            while (res.moveToNext()) {
                logsBuffer.append("id: " + res.getString(0) + "\n")
                logsBuffer.append("date: " + res.getString(1) + "\n")
                logsBuffer.append("situation: " + res.getString(4) + "\n")
                logsBuffer.append("symptoms: " + res.getString(3) + "\n")
                logsBuffer.append("negative thoughts: " + res.getString(2) + "\n\n")
            }
            displayLogs("Logs", logsBuffer.toString())

        }
    }

    private fun displayLogs(name: String, content: String) {
        val builder = AlertDialog.Builder(activity)
        builder.setCancelable(true)
        builder.setTitle(name)
        builder.setMessage(content)
        builder.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_logs, container, false)

    companion object {
        fun newInstance(): LogsFragment = LogsFragment()
    }

    private fun clearLogs() {
        val db = DatabaseHandler(context!!.applicationContext)
        db.clearData()
    }
}

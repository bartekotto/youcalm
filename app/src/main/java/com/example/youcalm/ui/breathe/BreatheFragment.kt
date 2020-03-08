package com.example.youcalm.ui.breathe

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.youcalm.R
import kotlinx.android.synthetic.main.fragment_breathe.*
import java.util.*


class BreatheFragment : Fragment(), AdapterView.OnItemSelectedListener {
    var exit: Boolean = false
    var rotationPass: Int = 5
    var breatheInSeconds: Int = 5
    var breatheOutSeconds: Int = 5
    private lateinit var alarmIntent: PendingIntent


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notifyBreath()
        breatheIn.setOnClickListener(clickListener)
        ArrayAdapter.createFromResource(
            context!!.applicationContext,
            R.array.numbers_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            breatheInSecondsSpinner.adapter = adapter
            breatheInSecondsSpinner.onItemSelectedListener = this
            breatheOutSecondsSpinner.adapter = adapter
            breatheOutSecondsSpinner.onItemSelectedListener = this
            rotationsSpinner.adapter = adapter
            rotationsSpinner.onItemSelectedListener = this
        }
        super.onViewCreated(view, savedInstanceState)
    }

    val clickListener = View.OnClickListener {
        if (breatheInSeconds < breatheOutSeconds) {
            Toast.makeText(
                context,
                "Breath in should be bigger than breath out!",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            breatheText.text = "breath in"
            breatheIn.setOnClickListener(null)
            runAnimation(
                breatheIn,
                breatheOut,
                breatheInSeconds,
                breatheOutSeconds,
                0,
                rotationPass * 2
            )
        }
    }

    fun runAnimation(
        progressBar: ProgressBar,
        nextProgressBar: ProgressBar,
        secondsIn: Int,
        secondsOut: Int,
        doneRotations: Int,
        rotations: Int
    ) {
        if (!exit) {
            when {
                doneRotations % 2 == 1 -> {
                    breatheText.text = "breath out"
                }
                else -> {
                    breatheText.text = "breath in"
                }
            }
            Handler().postDelayed(
                {
                    progressBar.progress = progressBar.progress + 1
                    when {
                        progressBar.progress < 1000 -> {
                            when {
                                doneRotations % 2 == 0 -> {
                                    progressBar.setProgress(
                                        progressBar.progress + (50 / breatheInSeconds),
                                        true
                                    )
                                }
                                else -> {
                                    progressBar.setProgress(
                                        progressBar.progress + (50 / breatheOutSeconds),
                                        true
                                    )
                                }
                            }
                            runAnimation(
                                progressBar,
                                nextProgressBar,
                                secondsIn,
                                secondsOut,
                                doneRotations,
                                rotations
                            )
                        }
                        doneRotations == rotations -> {
                            breatheText.setText("Start")
                            progressBar.progress = 0
                            nextProgressBar.progress = 0
                            progressBar.setOnClickListener(clickListener)
                        }
                        else -> {
                            progressBar.progress = 0
                            progressBar.isVisible = false
                            nextProgressBar.isVisible = true
                            runAnimation(
                                nextProgressBar,
                                progressBar,
                                secondsIn,
                                secondsOut,
                                doneRotations + 1,
                                rotations
                            )
                        }
                    }
                },
                50
            )
        }
    }

    private fun notifyBreath() {
        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 10)
        }
        alarmIntent = Intent(activity, NotificationReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(activity, 100, intent, 0)
        }
        val alarmMgr10 = activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmMgr10.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )
        val alarmMgr16 = activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmMgr16.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis + 14400000,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )
        val alarmMgr20 = activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmMgr20.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis + 28800000,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )
    }

    override fun onDestroyView() {
        exit = true
        super.onDestroyView()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_breathe, container, false)


    companion object {
        fun newInstance(): BreatheFragment = BreatheFragment()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            when {
                parent.id == 2131296427 -> {
                    rotationPass = parent.getItemAtPosition(position).toString().toInt()
                }
                parent.id == 2131296302 -> {
                    breatheOutSeconds = parent.getItemAtPosition(position).toString().toInt()
                }
                parent.id == 2131296304 -> {
                    breatheInSeconds = parent.getItemAtPosition(position).toString().toInt()
                }
            }
        }
    }

}

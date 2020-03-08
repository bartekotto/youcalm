package com.example.youcalm.ui.scheme

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.youcalm.R
import kotlinx.android.synthetic.main.activity_fingerprint_auth.*
import kotlinx.android.synthetic.main.fragment_scheme.*


class SchemeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_scheme, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        causeText.setOnClickListener(clickListener)
        anxierty.setOnClickListener(clickListener)
        textView4.setOnClickListener(clickListener)
        textView6.setOnClickListener(clickListener)
        textView8.setOnClickListener(clickListener)
        textView9.setOnClickListener(clickListener)
    }

    val clickListener = View.OnClickListener { view ->

        when (((view as TextView).text as String)) {
            "External/Internal trigger" -> {
                imageView9.visibility = ImageView.VISIBLE
                triggerDesc2.visibility = TextView.VISIBLE
                imageView9.setOnClickListener {
                    imageView9.visibility = ImageView.INVISIBLE
                    triggerDesc2.visibility = TextView.INVISIBLE
                }
            }
            "Perceived threat" -> {
                imageView9.visibility = ImageView.VISIBLE
                triggerDesc2.visibility = TextView.VISIBLE
                imageView9.setOnClickListener {
                    imageView9.visibility = ImageView.INVISIBLE
                    triggerDesc2.visibility = TextView.INVISIBLE

                }
            }
            "Anxiety" -> {
                imageView9.visibility = ImageView.VISIBLE
                triggerDesc2.visibility = TextView.VISIBLE
                imageView9.setOnClickListener {
                    imageView9.visibility = ImageView.INVISIBLE
                    triggerDesc2.visibility = TextView.INVISIBLE

                }
            }
            "Misinterpretation" -> {
                imageView9.visibility = ImageView.VISIBLE
                triggerDesc2.visibility = TextView.VISIBLE
                imageView9.setOnClickListener {
                    imageView9.visibility = ImageView.INVISIBLE
                    triggerDesc2.visibility = TextView.INVISIBLE

                }
            }
            "Avoidance &\n safety behaviors" -> {
                imageView9.visibility = ImageView.VISIBLE
                triggerDesc2.visibility = TextView.VISIBLE
                imageView9.setOnClickListener {
                    imageView9.visibility = ImageView.INVISIBLE
                    triggerDesc2.visibility = TextView.INVISIBLE

                }
            }
            "Physical/Cognitive\nSymptoms" -> {
                imageView9.visibility = ImageView.VISIBLE
                triggerDesc2.visibility = TextView.VISIBLE
                imageView9.setOnClickListener {
                    imageView9.visibility = ImageView.INVISIBLE
                    triggerDesc2.visibility = TextView.INVISIBLE

                }
            }
        }
    }


    companion object {
        fun newInstance(): SchemeFragment = SchemeFragment()
    }
}

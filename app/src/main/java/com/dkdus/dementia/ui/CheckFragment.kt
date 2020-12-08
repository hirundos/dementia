package com.dkdus.dementia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dkdus.dementia.R
import kotlinx.android.synthetic.main.fragment_check.*
import kotlinx.android.synthetic.main.fragment_check.view.*


class CheckFragment : Fragment() {
    var total = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_check, container, false)
        root.masterbutton.setOnClickListener{
            masterbutton.setEnabled(false)
            if (check1.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check2.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check3.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check4.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check5.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check6.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check7.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check8.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check9.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check10.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check11.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check12.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check13.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check14.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check15.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check16.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check17.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check18.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check19.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            if (check20.isChecked()) {
                total++
                root.masterbutton.setEnabled(true)
            }
            tv1.setText("결과 : " + total.toString() + "개")
            total = 0
        }
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}
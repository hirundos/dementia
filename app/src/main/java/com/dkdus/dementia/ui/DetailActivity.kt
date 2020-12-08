package com.dkdus.dementia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dkdus.dementia.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        if(intent!=null){
            var name = intent.getStringExtra("cntername")
            intent.getStringExtra("lat")
            intent.getStringExtra("lot")
            var addr = intent.getStringExtra("lnmadr")//주소
            var programShow = intent.getStringExtra("imbcltyIntrcn")//주요치매관리프로그램소개
            var phoneNum = intent.getStringExtra("call")
            var docN = intent.getStringExtra("doc")
            var nurN = intent.getStringExtra("nur")

            tv_name.text = name
            tv_addrV.text = addr
            tv_programValue.text = programShow
            tv_callV.text = phoneNum
            tv_docN.text = docN
            tv_nurseN.text = nurN
        }

    }
}
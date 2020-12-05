package com.dkdus.dementia.ui.game

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dkdus.dementia.R
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_game, container, false)
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.gugu_btn) {
            var intent : Intent = Intent(context, GuguActivity::class.java)
            startActivity(intent)
        }else if(p0?.id == R.id.rcp_btn){
            var intent : Intent = Intent(context, RcpActivity::class.java)
            startActivity(intent)
        }
    }
}
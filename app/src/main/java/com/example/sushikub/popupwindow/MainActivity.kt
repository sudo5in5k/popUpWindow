package com.example.sushikub.popupwindow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var popUp: PopUp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        popup_container.setOnClickListener {
            popUp = PopUp(this)
            showPopUp(popUp)
        }
    }

    private fun showPopUp(popUp: PopUp) {
        if (popUp.isShowing) {
            popUp.dismiss()
            popUp.show(contact_button)
        } else {
            popUp.show(contact_button)
        }
    }
}

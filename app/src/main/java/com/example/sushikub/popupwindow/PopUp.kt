package com.example.sushikub.popupwindow

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.PopupWindow
import android.widget.Toast
import kotlinx.android.synthetic.main.popup_layout.view.*

@SuppressLint("InflateParams")
class PopUp(private val context: Context) : PopupWindow() {

    private val layoutInflater = LayoutInflater.from(context)
    init {
        contentView = layoutInflater.inflate(R.layout.popup_layout, null)
        width = 500
        height = 500
        isOutsideTouchable = true
        isFocusable = true
        setBackgroundDrawable(context.getDrawable(R.drawable.popup_background))

        // Button
        contentView.close_button.setOnClickListener {
            dismiss()
        }

        setOnDismissListener {
            Toast.makeText(context, "Popup closed", Toast.LENGTH_SHORT).show()
        }
    }


    fun show() {
        showAtLocation(contentView, Gravity.CENTER, 0, 0)
    }
}
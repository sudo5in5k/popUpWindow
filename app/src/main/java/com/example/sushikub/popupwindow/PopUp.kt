package com.example.sushikub.popupwindow

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.Toast
import kotlinx.android.synthetic.main.popup_layout.view.*

@SuppressLint("InflateParams")
class PopUp(private val context: Context) : PopupWindow() {

    private val layoutInflater = LayoutInflater.from(context)

    init {
        contentView = layoutInflater.inflate(R.layout.popup_layout, null)
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        width = WindowManager.LayoutParams.WRAP_CONTENT
        height = WindowManager.LayoutParams.WRAP_CONTENT
        isOutsideTouchable = true
        isFocusable = true

        // Button
        contentView.popup.setOnClickListener {
            dismiss()
        }

        setOnDismissListener {
            Toast.makeText(context, "Popup closed", Toast.LENGTH_SHORT).show()
        }
    }


    fun show(anchorView: View) {
        showAsDropDown(anchorView, anchorView.measuredWidth / 4,
                -anchorView.measuredHeight - calcNavHeight(), Gravity.NO_GRAVITY)
    }

    private fun calcNavHeight(): Int {
        val resource = context.resources
        val resourceId = resource.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            resource.getDimensionPixelOffset(resourceId)
        } else {
            0
        }
    }
}
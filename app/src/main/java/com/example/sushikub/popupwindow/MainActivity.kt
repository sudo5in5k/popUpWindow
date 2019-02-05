package com.example.sushikub.popupwindow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var popUp: PopUp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPopUpUsingRx(PopUp(this))

        popup_container.setOnClickListener {
            showPopUpUsingButton(PopUp(this))
        }
    }

    private fun showPopUpUsingButton(popUp: PopUp) {
        if (popUp.isShowing) {
            popUp.dismiss()
            popUp.show(contact_button)
        } else {
            popUp.show(contact_button)
        }
    }

    private fun showPopUpUsingRx(popUp: PopUp) {
        Completable.complete()
                .delay(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { popUp.show(contact_button) }
                .subscribe()
    }
}

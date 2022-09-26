package com.conamobile.clickanim

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View

fun View.click(
    clickDownDuration: Long = 200,
    clickUpDuration: Long = 1000,
    scale: Float = -0.2f,
    onTouch: Boolean = false,
    clickListener: (View) -> Unit
) {
    setOnTouchListener(
        object : View.OnTouchListener {
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(v: View, motionEvent: MotionEvent): Boolean {
                val action = motionEvent.action
                if (action == MotionEvent.ACTION_DOWN) {
                    v.animate().scaleXBy(scale).setDuration(clickDownDuration).start()
                    v.animate().scaleYBy(scale).setDuration(clickDownDuration).start()
                    if (onTouch) clickListener(this@click)
                    return true
                } else if (action == MotionEvent.ACTION_UP) {
                    if (!onTouch) clickListener(this@click)
                    v.animate().cancel()
                    v.animate().scaleX(1f).setDuration(clickUpDuration).start()
                    v.animate().scaleY(1f).setDuration(clickUpDuration).start()
                    return true
                }
                return false
            }
        })
}
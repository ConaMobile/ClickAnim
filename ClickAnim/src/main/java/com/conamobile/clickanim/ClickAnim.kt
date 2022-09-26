package com.conamobile.clickanim

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View

object ClickAnim {
    fun View.click(scale: Float = -0.2f, onTouch: Boolean = false, clickListener: (View) -> Unit) {
        setOnTouchListener(
            object : View.OnTouchListener {
                @SuppressLint("ClickableViewAccessibility")
                override fun onTouch(v: View, motionEvent: MotionEvent): Boolean {
                    val action = motionEvent.action
                    if (action == MotionEvent.ACTION_DOWN) {
                        v.animate().scaleXBy(scale).setDuration(200).start()
                        v.animate().scaleYBy(scale).setDuration(200).start()
                        if (onTouch) clickListener(this@click)
                        return true
                    } else if (action == MotionEvent.ACTION_UP) {
                        if (!onTouch) clickListener(this@click)
                        v.animate().cancel()
                        v.animate().scaleX(1f).setDuration(1000).start()
                        v.animate().scaleY(1f).setDuration(1000).start()
                        return true
                    }
                    return false
                }
            })
    }
}
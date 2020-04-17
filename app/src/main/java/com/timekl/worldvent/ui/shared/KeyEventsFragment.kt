package com.timekl.worldvent.ui.shared

import android.view.KeyEvent

interface KeyEventsFragment {

    fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean

}
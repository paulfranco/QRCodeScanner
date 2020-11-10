package co.paulfran.qrcodescanner.ui.base.presenter

import android.os.Bundle

interface BasePresenter {

    fun onViewCreated(arguments: Bundle?)

    fun onViewDestroyed()
}
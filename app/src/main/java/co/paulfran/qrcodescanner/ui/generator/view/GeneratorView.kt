package co.paulfran.qrcodescanner.ui.generator.view

import android.graphics.Bitmap
import androidx.navigation.NavController
import co.paulfran.qrcodescanner.ui.base.view.BaseView

interface GeneratorView: BaseView {

    val navController: NavController

    fun setupDefaultText()

    fun setupQrImage(bitmap: Bitmap?)

    fun setupEmptyQrImage()

    fun navigateToDetails(id: Long)
}
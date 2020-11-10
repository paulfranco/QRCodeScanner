package co.paulfran.qrcodescanner.ui.generator.presenter

import android.graphics.Bitmap
import co.paulfran.qrcodescanner.ui.base.presenter.BasePresenter

interface GeneratorPresenter: BasePresenter {

    var generatedBitmap: Bitmap?

    fun onTextChanged(text: String)

    fun onSaveButtonClicked()
}
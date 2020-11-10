package co.paulfran.qrcodescanner.ui.scanner.presenter

import co.paulfran.qrcodescanner.ui.base.presenter.BasePresenter
import com.journeyapps.barcodescanner.BarcodeResult

interface ScannerPresenter: BasePresenter {

    var lastScanTime: Long

    var flashState: Boolean

    fun onScanResult(barcodeResult: BarcodeResult)

    fun onResumeScan()

    fun onPauseScan()

    fun onFlashButtonClicked()
}
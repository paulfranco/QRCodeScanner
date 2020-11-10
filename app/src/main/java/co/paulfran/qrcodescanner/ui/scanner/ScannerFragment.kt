package co.paulfran.qrcodescanner.ui.scanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.paulfran.qrcodescanner.R
import co.paulfran.qrcodescanner.ui.base.BaseFragment
import co.paulfran.qrcodescanner.ui.scanner.presenter.ScannerPresenter
import co.paulfran.qrcodescanner.ui.scanner.view.ScannerView
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_scanner.*

@AndroidEntryPoint
class ScannerFragment: BaseFragment<ScannerPresenter, ScannerView>(R.layout.fragment_scanner) {

    override fun setupViews() {
        super.setupViews()
        flashButton.setOnClickListener {
            presenter.onFlashButtonClicked()
        }
        codeScannerView.decodeContinuous(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult) {
                presenter.onScanResult(result)
            }
            override fun possibleResultPoints(resultPoints: List<ResultPoint>) {
            }
        })
    }

    override fun onResume() {
        super.onResume()
        presenter.onResumeScan()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPauseScan()
    }
}
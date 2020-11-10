package co.paulfran.qrcodescanner.ui.history.presenter

import android.os.Bundle
import co.paulfran.qrcodescanner.R
import co.paulfran.qrcodescanner.data.db.entity.QrModel
import co.paulfran.qrcodescanner.data.repository.QrModelRepository
import co.paulfran.qrcodescanner.ui.history.view.HistoryView
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HistoryPresenterImpl(
    private val view: HistoryView,
    private val repository: QrModelRepository
): HistoryPresenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Job() + Dispatchers.IO

    override fun onViewCreated(arguments: Bundle?) {
        launch {
            val qrModels = repository.getAllQrModels()
            withContext(Dispatchers.Main) { view.fillHistoryList(qrModels) }
        }
    }

    override fun onViewDestroyed() {
        coroutineContext.cancelChildren()
    }

    override fun onHistoryItemClicked(id: Long) {
        view.navigateToDetails(id)
    }

    override fun onItemFavButtonClicked(pos: Int, model: QrModel) {
        launch {
            val favorite = repository.switchFavorite(model)
            withContext(Dispatchers.Main) { view.changeItemFavoriteIcon(pos, favorite) }
        }
    }
}
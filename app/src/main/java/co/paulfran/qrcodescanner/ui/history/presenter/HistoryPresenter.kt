package co.paulfran.qrcodescanner.ui.history.presenter

import co.paulfran.qrcodescanner.data.db.entity.QrModel
import co.paulfran.qrcodescanner.ui.base.presenter.BasePresenter

interface HistoryPresenter: BasePresenter {

    fun onHistoryItemClicked(id: Long)

    fun onItemFavButtonClicked(pos: Int, model: QrModel)
}
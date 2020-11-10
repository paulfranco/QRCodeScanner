package co.paulfran.qrcodescanner.ui.details.presenter

import android.os.Bundle
import co.paulfran.qrcodescanner.data.db.entity.QrModel
import co.paulfran.qrcodescanner.ui.base.presenter.BasePresenter

interface DetailsPresenter: BasePresenter {

    var qrModel: QrModel

    fun onEditTitleClicked()

    fun onDeleteButtonClicked()

    fun onFavoriteButtonClicked()

    fun onShareButtonClicked()

    fun onCopyButtonClicked()

    fun onTitleChangedResult(result: Bundle)
}
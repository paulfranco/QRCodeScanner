package co.paulfran.qrcodescanner.ui.history.view

import androidx.navigation.NavController
import co.paulfran.qrcodescanner.data.db.entity.QrModel
import co.paulfran.qrcodescanner.ui.base.view.BaseView

interface HistoryView: BaseView {

    val navController: NavController

    fun fillHistoryList(items: List<QrModel>)

    fun changeItemFavoriteIcon(pos: Int, favorite: Boolean)

    fun navigateToDetails(id: Long)
}
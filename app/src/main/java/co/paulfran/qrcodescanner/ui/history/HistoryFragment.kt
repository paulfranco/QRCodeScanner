package co.paulfran.qrcodescanner.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.paulfran.qrcodescanner.R
import co.paulfran.qrcodescanner.ui.base.BaseFragment
import co.paulfran.qrcodescanner.ui.history.adapter.HistoryAdapter
import co.paulfran.qrcodescanner.ui.history.presenter.HistoryPresenter
import co.paulfran.qrcodescanner.ui.history.view.HistoryView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_history.*

@AndroidEntryPoint
class HistoryFragment : BaseFragment<HistoryPresenter, HistoryView>(R.layout.fragment_history) {

    override fun setupViews() {
        super.setupViews()
        historyRecycler.layoutManager = LinearLayoutManager(requireContext())
        historyRecycler.adapter = HistoryAdapter(
            itemClickListener = { presenter.onHistoryItemClicked(it) },
            favButtonClickListener = { pos, model ->  presenter.onItemFavButtonClicked(pos, model) }
        )
    }
}
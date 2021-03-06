package co.paulfran.qrcodescanner.ui.details


import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.setFragmentResultListener
import co.paulfran.qrcodescanner.R
import co.paulfran.qrcodescanner.ui.base.BaseFragment
import co.paulfran.qrcodescanner.ui.details.presenter.DetailsPresenter
import co.paulfran.qrcodescanner.ui.details.view.DetailsView
import co.paulfran.qrcodescanner.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details.*

@AndroidEntryPoint
class DetailsFragment: BaseFragment<DetailsPresenter, DetailsView>(R.layout.fragment_details),
    Toolbar.OnMenuItemClickListener, View.OnClickListener {

    override fun setupViews() {
        super.setupViews()

        favoriteButton.setOnClickListener(this)
        deleteButton.setOnClickListener(this)
        shareButton.setOnClickListener(this)
        copyButton.setOnClickListener(this)

        toolbar.setOnMenuItemClickListener(this)

        setFragmentResultListener(Constants.TITLE_REQUEST_KEY) { _, bundle ->
            presenter.onTitleChangedResult(bundle)
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.edit -> presenter.onEditTitleClicked().also { return true }
            else -> return false
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.favoriteButton -> presenter.onFavoriteButtonClicked()
            R.id.deleteButton -> presenter.onDeleteButtonClicked()
            R.id.shareButton -> presenter.onShareButtonClicked()
            R.id.copyButton -> presenter.onCopyButtonClicked()
        }
    }
}
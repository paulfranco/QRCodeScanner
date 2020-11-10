package co.paulfran.qrcodescanner.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.annotation.LayoutRes
import co.paulfran.qrcodescanner.ui.base.presenter.BasePresenter
import co.paulfran.qrcodescanner.ui.base.view.BaseView
import javax.inject.Inject


abstract class BaseFragment<P : BasePresenter, V : BaseView>(@LayoutRes layout: Int) : Fragment(layout) {

    @Inject
    lateinit var presenter : P
    @Inject
    lateinit var baseView : V

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseView.rootView = view
        setupViews()
        presenter.onViewCreated(arguments)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onViewDestroyed()
    }

    open fun setupViews() {
        // ...
    }
}
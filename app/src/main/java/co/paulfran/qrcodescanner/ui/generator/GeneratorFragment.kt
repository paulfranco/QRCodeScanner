package co.paulfran.qrcodescanner.ui.generator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.paulfran.qrcodescanner.R
import co.paulfran.qrcodescanner.ext.customAfterTextChanged
import co.paulfran.qrcodescanner.ui.base.BaseFragment
import co.paulfran.qrcodescanner.ui.generator.presenter.GeneratorPresenter
import co.paulfran.qrcodescanner.ui.generator.view.GeneratorView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dialog_edit.*
import kotlinx.android.synthetic.main.dialog_edit.textInputEditText
import kotlinx.android.synthetic.main.fragment_generator.*

@AndroidEntryPoint
class GeneratorFragment: BaseFragment<GeneratorPresenter, GeneratorView>(R.layout.fragment_generator) {

    override fun setupViews() {
        super.setupViews()
        textInputEditText.customAfterTextChanged {
            presenter.onTextChanged(it)
        }
        buttonSave.setOnClickListener {
            presenter.onSaveButtonClicked()
        }
    }
}
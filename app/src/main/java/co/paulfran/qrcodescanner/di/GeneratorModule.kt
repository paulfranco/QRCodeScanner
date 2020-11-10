package co.paulfran.qrcodescanner.di

import android.app.Activity
import androidx.navigation.NavController
import co.paulfran.qrcodescanner.data.repository.QrModelRepository
import co.paulfran.qrcodescanner.ui.generator.presenter.GeneratorPresenter
import co.paulfran.qrcodescanner.ui.generator.presenter.GeneratorPresenterImpl
import co.paulfran.qrcodescanner.ui.generator.view.GeneratorView
import co.paulfran.qrcodescanner.ui.generator.view.GeneratorViewImpl
import co.paulfran.qrcodescanner.util.EncodeUtil
import com.google.zxing.MultiFormatReader
import com.journeyapps.barcodescanner.BarcodeEncoder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object GeneratorModule {

    @Provides
    @FragmentScoped
    fun provideView(activity: Activity, navController: NavController): GeneratorView =
        GeneratorViewImpl(activity, navController)

    @Provides
    @FragmentScoped
    fun providePresenter(
        view: GeneratorView,
        repository: QrModelRepository
    ): GeneratorPresenter {
        val util = EncodeUtil(MultiFormatReader(), BarcodeEncoder())
        return GeneratorPresenterImpl(view, util, repository)
    }
}
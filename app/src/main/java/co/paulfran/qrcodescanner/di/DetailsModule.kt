package co.paulfran.qrcodescanner.di

import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import androidx.navigation.NavController
import co.paulfran.qrcodescanner.data.repository.QrModelRepository
import co.paulfran.qrcodescanner.ui.details.presenter.DetailsPresenter
import co.paulfran.qrcodescanner.ui.details.presenter.DetailsPresenterImpl
import co.paulfran.qrcodescanner.ui.details.view.DetailsView
import co.paulfran.qrcodescanner.ui.details.view.DetailsViewImpl
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
object DetailsModule {

    @Provides
    @FragmentScoped
    fun provideView(activity: Activity, navController: NavController): DetailsView =
        DetailsViewImpl(activity, navController)

    @Provides
    @FragmentScoped
    fun providePresenter(
        context: Context,
        view: DetailsView,
        repository: QrModelRepository
    ): DetailsPresenter {
        val clipboard =  context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val encodeUtil = EncodeUtil(MultiFormatReader(), BarcodeEncoder())
        return DetailsPresenterImpl(view, clipboard, repository, encodeUtil)
    }
}
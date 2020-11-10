package co.paulfran.qrcodescanner.di

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.navigation.NavController
import co.paulfran.qrcodescanner.data.repository.QrModelRepository
import co.paulfran.qrcodescanner.ui.scanner.presenter.ScannerPresenter
import co.paulfran.qrcodescanner.ui.scanner.presenter.ScannerPresenterImpl
import co.paulfran.qrcodescanner.ui.scanner.view.ScannerView
import co.paulfran.qrcodescanner.ui.scanner.view.ScannerViewImpl
import co.paulfran.qrcodescanner.util.FileManager
import co.paulfran.qrcodescanner.util.PermissionChecker
import co.paulfran.qrcodescanner.util.SoundVibrationUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object ScannerModule {

    @Provides
    @FragmentScoped
    fun provideView(activity: Activity, navController: NavController): ScannerView =
        ScannerViewImpl(activity, navController)

    @Provides
    @FragmentScoped
    fun providePresenter(
        context: Context,
        scannerView: ScannerView,
        preferences: SharedPreferences,
        repository: QrModelRepository
    ): ScannerPresenter {
        val fileManager = FileManager(context)
        val soundVibrationUtil = SoundVibrationUtil(context)
        val permissionChecker = PermissionChecker(context)
        return ScannerPresenterImpl(scannerView, fileManager, soundVibrationUtil, preferences, repository, permissionChecker)
    }
}
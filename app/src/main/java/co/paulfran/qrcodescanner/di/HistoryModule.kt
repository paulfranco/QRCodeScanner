package co.paulfran.qrcodescanner.di

import android.app.Activity
import androidx.navigation.NavController
import co.paulfran.qrcodescanner.data.repository.QrModelRepository
import co.paulfran.qrcodescanner.ui.history.presenter.HistoryPresenter
import co.paulfran.qrcodescanner.ui.history.presenter.HistoryPresenterImpl
import co.paulfran.qrcodescanner.ui.history.view.HistoryView
import co.paulfran.qrcodescanner.ui.history.view.HistoryViewImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object HistoryModule {

    @Provides
    @FragmentScoped
    fun provideView(activity: Activity, navController: NavController): HistoryView =
        HistoryViewImpl(activity, navController)

    @Provides
    @FragmentScoped
    fun providePresenter(view: HistoryView, repository: QrModelRepository): HistoryPresenter =
        HistoryPresenterImpl(view, repository)
}
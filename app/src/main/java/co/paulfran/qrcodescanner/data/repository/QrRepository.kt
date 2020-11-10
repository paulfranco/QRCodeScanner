package co.paulfran.qrcodescanner.data.repository

import co.paulfran.qrcodescanner.data.db.QrDao
import co.paulfran.qrcodescanner.data.db.entity.QrModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QrModelRepository @Inject constructor(private val dao: QrDao) {

    suspend fun getAllQrModels(): List<QrModel> = dao.getAllQrModels()

    suspend fun getQrModelWithId(id: Long): QrModel = dao.getQrModelWithId(id)

    suspend fun insertQrModel(model: QrModel): Long = dao.insert(model)

    suspend fun deleteQrModel(model: QrModel) = dao.delete(model)

    suspend fun updateQrModel(model: QrModel) = dao.update(model)

    suspend fun switchFavorite(model: QrModel): Boolean {
        val newValue = model.favorite.not().also { model.favorite = it }
        dao.update(model)
        return newValue
    }
}
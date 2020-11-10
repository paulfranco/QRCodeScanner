package co.paulfran.qrcodescanner.data.db

import androidx.room.*
import co.paulfran.qrcodescanner.data.db.entity.QrModel
import co.paulfran.qrcodescanner.util.Constants


@Dao
interface QrDao {

    @Query("SELECT * FROM ${Constants.TABLE_NAME} WHERE id LIKE :id LIMIT 1")
    suspend fun getQrModelWithId(id: Long): QrModel

    @Query("SELECT * FROM ${Constants.TABLE_NAME}")
    suspend fun getAllQrModels(): List<QrModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: QrModel): Long

    @Update
    suspend fun update(model: QrModel)

    @Delete
    suspend fun delete(model: QrModel)
}
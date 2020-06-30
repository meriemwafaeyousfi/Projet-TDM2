package com.example.geomob
import androidx.room.*

@Dao
interface Pays_DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePays(pays : Pays_Entity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveHis(his : Histo_Entity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveRes(his : Ress_Entity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePer(his : Person_Entity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePaysRhisto(pays : Pays_Entity, histos :List<Histo_Entity>)
    @Query("select * from Pays_Entity ")
    fun readPays() : List<Pays_Entity>
    @Transaction
    @Query("SELECT * FROM Pays_Entity where pays_id = :id")
    fun getPaysHisto(id: Int): List<PaysRhisto>
    @Transaction
    @Query("SELECT * FROM Pays_Entity  where pays_id = :id")
    fun getPaysRess(id: Int): List<PaysRress>
    @Transaction
    @Query("SELECT * FROM Pays_Entity  where pays_id = :id")
    fun getPaysPerson(id: Int): List<PaysRperson>
    }

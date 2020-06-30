package com.example.geomob
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters




@Database(entities = [(Pays_Entity::class),(Histo_Entity::class),(Ress_Entity::class),(Person_Entity::class)], version = 1)
@TypeConverters(Converters::class)
abstract class AppDB : RoomDatabase() {
    abstract fun paysDAO() : Pays_DAO

    companion object {
        private var instance: AppDB? = null

        fun getInstance(context: Context): AppDB? {
            if (instance == null) {

                instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDB::class.java, "produit.db")
                    .build()

            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}
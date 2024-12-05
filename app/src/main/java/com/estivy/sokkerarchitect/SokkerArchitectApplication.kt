package com.estivy.sokkerarchitect

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.estivy.sokkerarchitect.storage.database.SokkerArchitectDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SokkerArchitectApplication: Application(){

    init {
        instance = this
    }

    companion object {
        lateinit var database: SokkerArchitectDatabase

        private var instance: SokkerArchitectApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            SokkerArchitectDatabase::class.java,
            "sokker_architect_database"
        ).build()
    }
}
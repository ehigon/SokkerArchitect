package com.estivy.sokkerarchitect

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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
        ).addMigrations(MIGRATION_1_2)
            .build()
    }

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE junior_statuses ADD COLUMN 'age' INTEGER")
            database.execSQL("UPDATE junior_statuses SET age = (SELECT age FROM players WHERE players.id = junior_statuses.playerId)")
            database.execSQL("ALTER TABLE player_statuses ADD COLUMN 'age' INTEGER")
            database.execSQL("UPDATE player_statuses SET age = (SELECT age FROM players WHERE players.id = player_statuses.playerId)")
            database.execSQL("ALTER TABLE player_statuses ADD COLUMN 'injured' INTEGER")
            database.execSQL("ALTER TABLE junior_statuses ADD COLUMN 'trainerSkill' INTEGER DEFAULT(15)")
        }
    }

}
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
        ).addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
            .build()
    }

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE junior_statuses ADD COLUMN 'age' INTEGER")
            db.execSQL("UPDATE junior_statuses SET age = (SELECT age FROM players WHERE players.id = junior_statuses.playerId)")
            db.execSQL("ALTER TABLE player_statuses ADD COLUMN 'age' INTEGER")
            db.execSQL("UPDATE player_statuses SET age = (SELECT age FROM players WHERE players.id = player_statuses.playerId)")
            db.execSQL("ALTER TABLE player_statuses ADD COLUMN 'injured' INTEGER")
            db.execSQL("ALTER TABLE junior_statuses ADD COLUMN 'trainerSkill' INTEGER DEFAULT(15)")
        }
    }

    private val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("CREATE TABLE IF NOT EXISTS `team` (`id` INTEGER, `teamId` INTEGER, `name` TEXT, `countryId` INTEGER, `regionId` INTEGER, `dateCreated` TEXT, `rank` REAL, `national` INTEGER, `colShirtKeep` INTEGER, `colTrausKeep` INTEGER, `colShirt` INTEGER, `colTraus` INTEGER, `colShirt2` INTEGER, `colTraus2` INTEGER, `arenaName` TEXT, `money` INTEGER, `fanclubCount` INTEGER, `fanclubMood` INTEGER, `juniorsMax` INTEGER, `trainingTypeGk` INTEGER, `trainingTypeDef` INTEGER, `trainingTypeMid` INTEGER, `trainingTypeAtt` INTEGER, PRIMARY KEY(`id`), FOREIGN KEY(`countryId`) REFERENCES `countries`(`countryId`) ON UPDATE NO ACTION ON DELETE NO ACTION )")
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_team_countryId` ON `team` (`countryId`)")
        }
    }

    private val MIGRATION_3_4 = object : Migration(3, 4) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE players ADD COLUMN `notes` TEXT")
        }
    }
}
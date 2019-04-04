package com.example.tilegame.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Layout.class, Tile.class}, version = 1)
public abstract class LayoutRoomDatabase extends RoomDatabase {

    public abstract LayoutDao layoutDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile LayoutRoomDatabase INSTANCE;

    static LayoutRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LayoutRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LayoutRoomDatabase.class, "word_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}

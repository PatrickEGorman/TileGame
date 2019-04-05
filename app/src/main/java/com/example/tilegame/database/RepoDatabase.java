package com.example.tilegame.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.tilegame.database.dao.LayoutDao;
import com.example.tilegame.database.dao.TileDao;
import com.example.tilegame.database.entity.Layout;
import com.example.tilegame.database.entity.Tile;

@Database(entities = {Layout.class, Tile.class}, version = 1)
public abstract class RepoDatabase extends RoomDatabase {

    public abstract LayoutDao layoutDao();
    public abstract TileDao tileDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile RepoDatabase INSTANCE;

    public static RepoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RepoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RepoDatabase.class, "repo_database")
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

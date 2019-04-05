package com.example.tilegame.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.tilegame.database.entity.Layout;
import com.example.tilegame.database.entity.Tile;

import java.util.List;

@Dao
public interface LayoutDao {

    @Query("SELECT * from layout_table ORDER BY name ASC")
    LiveData<List<Layout>> getLayouts();

    @Query("SELECT name from layout_table ORDER BY name ASC")
    LiveData<List<String>> getLayoutNames();

    @Transaction
    @Query("SELECT * from layout_table WHERE layout_table.name=:name")
    Layout getLayoutFromName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLayout(Layout layout);

    @Delete
    void deleteLayout(Layout layout);

}

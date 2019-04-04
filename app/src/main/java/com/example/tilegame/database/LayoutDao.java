package com.example.tilegame.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LayoutDao {

    @Query("SELECT * from layout_table ORDER BY name ASC")
    public Layout[] getLayouts();

    @Query("SELECT * from layout_table WHERE layout_table.name = :name")
    public Layout[] getLayoutFromName(String name);

    @Insert
    void insertLayout(Layout layout);

    @Delete
    public void deleteLayout(Layout layout);

}

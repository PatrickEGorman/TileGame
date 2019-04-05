package com.example.tilegame.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.tilegame.database.entity.Tile;

import java.util.List;

@Dao
public interface TileDao {
    @Transaction
    @Query("SELECT * from tile_table WHERE layout=:layoutName")
    LiveData<List<Tile>> getLayoutTiles(String layoutName);

    @Insert
    void insertTile(Tile tile);
}

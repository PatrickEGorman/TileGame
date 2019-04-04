package com.example.tilegame.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "tile_table")
public class Tile {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "x")
    public int x;

    @ColumnInfo(name = "y")
    public int y;

    @NonNull
    @ColumnInfo(name = "layout")
    String layout;

    @NonNull
    @ColumnInfo(name = "type")
    private String type;

    public Tile(int x, int y, @NonNull String type, @NonNull String layout) {

        this.x = x;
        this.y = y;
        this.type = type;
        this.layout = layout;
    }

    @NonNull
    public String getType() {
        return this.type;
    }

}

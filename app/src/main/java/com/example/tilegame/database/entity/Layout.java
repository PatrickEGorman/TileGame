package com.example.tilegame.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.tilegame.tileLayout.TileLayout;


@Entity(tableName = "layout_table")
public class Layout {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    public Layout(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}

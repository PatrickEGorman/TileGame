package com.example.tilegame.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import com.example.tilegame.tileLayout.TileLayout;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "layout_table")
public class Layout {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "type")
    @Relation(parentColumn = "name", entityColumn = "layout")
    private List<Tile> tiles;

    public Layout(@NonNull TileLayout layout, @NonNull String name) {

        this.name = name;
        this.tiles = new ArrayList<Tile>();
        for(int x=0; x<9; x++){
            for(int y=0; y<13; y++){
                Tile tile = new Tile(x, y, layout.getTile(x, y).name);
                tiles.add(tile);
            }
        }
    }
}

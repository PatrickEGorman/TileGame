package com.example.tilegame.database;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import com.example.tilegame.tileLayout.TileLayout;

import java.util.ArrayList;
import java.util.List;

public class LayoutTiles {
    @Embedded
    public Layout layout;

    @Relation(parentColumn = "name", entityColumn = "layout")
    private List<Tile> tiles;

    public LayoutTiles(@NonNull TileLayout javaLayout, @NonNull Layout databaseLayout) {
        this.layout = databaseLayout;
        this.tiles = new ArrayList<Tile>();
        for(int x=0; x<9; x++){
            for(int y=0; y<13; y++){
                Tile tile = new Tile(x, y, javaLayout.getTile(x, y).name, databaseLayout.getName());
                tiles.add(tile);
            }
        }
    }
}

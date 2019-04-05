package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.widget.ImageView;

import com.example.tilegame.tiledata.Grass;

public class AllGrassLayoutGenerator implements  TileLayoutGenerator {
    @Override
    public TileLayout generateLayout(ImageView[][] tileList, AssetManager manager) {
        TileLayout layout = new TileLayout(tileList, manager);
        for(int x=0; x<9; x++){
            for(int y=0; y<13; y++){
                layout.setTile(x, y, Grass.class);
            }
        }
        return layout;
    }
}

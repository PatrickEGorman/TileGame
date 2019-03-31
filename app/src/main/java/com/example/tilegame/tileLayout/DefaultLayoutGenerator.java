package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.widget.ImageView;

import com.example.tilegame.tiledata.Desert;
import com.example.tilegame.tiledata.GenericTile;
import com.example.tilegame.tiledata.Grass;
import com.example.tilegame.tiledata.Rock;
import com.example.tilegame.tiledata.Water;

import java.util.ArrayList;
import java.util.Random;

public class DefaultLayoutGenerator implements TileLayoutGenerator {
    @Override
    public TileLayout generateLayout(ImageView[][] tileList, AssetManager manager) {
        TileLayout presetLayout = new TileLayout(tileList, manager);
        Random rand = new Random();

        ArrayList<Class <? extends GenericTile>> tileTypes
                = new ArrayList<Class <? extends GenericTile>>();
        tileTypes.add(0, Grass.class);
        tileTypes.add(1, Rock.class);
        tileTypes.add(2, Desert.class);
        tileTypes.add(3, Water.class);

        for(int i=0; i < 9; i++) {
            for (int j = 0; j < 13; j++) {
                int n = (i*j)%4;
                if(j==0 | j==12 | i==0 | i==8){
                    n = 3;
                }
                presetLayout.setTile(i, j, tileTypes.get(n));
            }
        }
        return presetLayout;
    }
}

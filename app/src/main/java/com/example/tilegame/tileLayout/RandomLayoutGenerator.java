package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.widget.ImageView;

import com.example.tilegame.tiledata.Desert;
import com.example.tilegame.tiledata.GenericTile;
import com.example.tilegame.tiledata.Grass;
import com.example.tilegame.tiledata.Rock;
import com.example.tilegame.tiledata.Water;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class RandomLayoutGenerator implements TileLayoutGenerator {
    @Override
    public TileLayout generateLayout(ImageView[][] tileList, AssetManager manager) {
        TileLayout randomLayout = new TileLayout(tileList, manager);
        Random rand = new Random();

        ArrayList<Class <? extends GenericTile>> tileTypes
                = new ArrayList<Class <? extends GenericTile>>();
        tileTypes.add(0, Rock.class);
        tileTypes.add(1, Grass.class);
        tileTypes.add(2, Desert.class);
        tileTypes.add(3, Water.class);

        for(int i=0; i < 9; i++) {
            for (int j = 0; j < 13; j++) {
                int n = rand.nextInt(4);
                randomLayout.setTile(i, j, tileTypes.get(n));
            }
        }
        return randomLayout;
    }
}

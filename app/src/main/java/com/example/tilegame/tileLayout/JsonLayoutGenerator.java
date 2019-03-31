package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.widget.ImageView;

public class JsonLayoutGenerator implements TileLayoutGenerator {
    @Override
    public TileLayout generateLayout(ImageView[][] tileList, AssetManager manager) {
        TileLayout JsonLayout = new TileLayout(tileList, manager);
        return JsonLayout;
    }
}

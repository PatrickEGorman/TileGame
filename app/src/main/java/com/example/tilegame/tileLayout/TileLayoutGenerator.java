package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.widget.ImageView;

public interface TileLayoutGenerator {
    TileLayout generateLayout(ImageView[][] tileList, AssetManager manager);
}

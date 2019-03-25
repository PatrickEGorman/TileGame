package com.example.tilegame.tiledata;

import android.service.quicksettings.Tile;

public class Grass extends GenericTile {
    public Grass() {
        super();

        this.path = this.path.concat("grass.png");
    }
}


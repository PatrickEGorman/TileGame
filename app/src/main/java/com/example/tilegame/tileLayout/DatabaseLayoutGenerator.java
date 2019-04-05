package com.example.tilegame.tileLayout;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.tilegame.database.RepoDatabase;
import com.example.tilegame.database.entity.Layout;
import com.example.tilegame.database.entity.Tile;
import com.example.tilegame.tiledata.Desert;
import com.example.tilegame.tiledata.GenericTile;
import com.example.tilegame.tiledata.Grass;
import com.example.tilegame.tiledata.Rock;
import com.example.tilegame.tiledata.Water;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseLayoutGenerator implements TileLayoutGenerator {
    private String name;
    private Context context;
    private List<Tile> tiles;


    public DatabaseLayoutGenerator(String name, Context context, List<Tile> tiles){
        this.name = name;
        this.context = context;
        this.tiles = tiles;
    }

    @Override
    public TileLayout generateLayout(ImageView[][] tileList, AssetManager manager) {
        TileLayout databaseLayout = new TileLayout(tileList, manager);
        Map<String, Class <? extends GenericTile>> tileTypes
                = new HashMap<>();
        tileTypes.put("rock", Rock.class);
        tileTypes.put("grass", Grass.class);
        tileTypes.put("desert", Desert.class);
        tileTypes.put("water", Water.class);

        for(int i=0; i<tiles.size(); i++) {
            Tile tile = tiles.get(i);
            databaseLayout.setTile(tile.x, tile.y, tileTypes.get(tile.getType()));
        }
        return databaseLayout;
    }
}

package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.ContextThemeWrapper;
import android.widget.ImageView;

import com.example.tilegame.tiledata.Desert;
import com.example.tilegame.tiledata.GenericTile;
import com.example.tilegame.tiledata.Grass;
import com.example.tilegame.tiledata.Rock;
import com.example.tilegame.tiledata.Water;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TileLayout {
    public GenericTile[][] boardLayout;
    public ImageView[][] tileList;
    private AssetManager manager;

    public TileLayout(ImageView[][] tileListInput, AssetManager manager){
        boardLayout = new GenericTile[9][13];
        this.manager = manager;
        this.tileList = tileListInput;
    }

    /*
    Returns a specific tile in the layout
    @param int x column number of tile
    @param int y row number of tile
     */
    public GenericTile getTile(int x, int y){
        try{
            return boardLayout[x][y];
        }
        catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    /*
    Sets a specific tile in the layout
    @param int x column number of tile
    @param int y row number of tile
    @param Class <? extends GenericTile> tileType type of tile to be set
     */
    public void setTile(int x, int y, Class <? extends GenericTile> tileType){
        Rect rect = new Rect(0,0,0,0);

        try{
            boardLayout[x][y] = tileType.newInstance();
            ImageView tilePic = tileList[x][y];
            InputStream open;
            open = this.manager.open(this.boardLayout[x][y].path);
            Bitmap bitmap = BitmapFactory.decodeStream(open, rect, null);
            // Assign the bitmap to an ImageView in this layout
            tilePic.setImageBitmap(bitmap);

        }
        catch(IndexOutOfBoundsException | IllegalAccessException | InstantiationException |
                IOException e){
            e.printStackTrace();
        }
    }


    /*
    Takes a JSON string in standard format and makes it into a TileLayout
    @param encodedJSON JSON encoded in standard file format
     */
    public void decodeJSON(String encodedJSON) throws JSONException {
        JSONArray JSONMapArray = new JSONArray(encodedJSON);
        Map<String, Class <? extends GenericTile>> tileTypes
                = new HashMap<>();
        tileTypes.put("rock", Rock.class);
        tileTypes.put("grass", Grass.class);
        tileTypes.put("desert", Desert.class);
        tileTypes.put("water", Water.class);

        for (int i=0; i<117; i++) {
            JSONObject JSONTileObject = JSONMapArray.getJSONObject(i).getJSONObject("tile");
            int x = JSONTileObject.getJSONObject("position").getInt("x");
            int y = JSONTileObject.getJSONObject("position").getInt("y");
            String type = JSONTileObject.getString("type");
            this.setTile(x, y, tileTypes.get(type));
        }
    }

}

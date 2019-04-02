package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.ContextThemeWrapper;
import android.widget.ImageView;

import com.example.tilegame.tiledata.GenericTile;

import java.io.IOException;
import java.io.InputStream;

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

}

package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.widget.ImageView;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class JSONLayoutGenerator implements TileLayoutGenerator {

    public String JSONFIlePath;

    public JSONLayoutGenerator(String JSONFIlePath){
        this.JSONFIlePath = JSONFIlePath;
    }


    @Override
    public TileLayout generateLayout(ImageView[][] tileList, AssetManager manager) {
        TileLayout JSONLayout = new TileLayout(tileList, manager);
        String encodedJSON = "";
        try {
            InputStream stream;
            stream = manager.open(JSONFIlePath);
            java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
            encodedJSON = s.hasNext() ? s.next() : "";

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONLayout.decodeJSON(encodedJSON);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return JSONLayout;
    }

}

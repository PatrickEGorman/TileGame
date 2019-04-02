package com.example.tilegame.tileLayout;

import android.content.res.AssetManager;
import android.widget.ImageView;

import com.example.tilegame.tiledata.GenericTile;
import com.example.tilegame.tiledata.Grass;
import com.example.tilegame.tiledata.Rock;
import com.example.tilegame.tiledata.Water;
import com.example.tilegame.tiledata.Desert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class JsonLayoutGenerator implements TileLayoutGenerator {

    public String jsonFilePath;

    public JsonLayoutGenerator(String jsonFilePath){
        this.jsonFilePath = jsonFilePath;
    }


    @Override
    public TileLayout generateLayout(ImageView[][] tileList, AssetManager manager) {
        TileLayout jsonLayout = new TileLayout(tileList, manager);
        String encodedJson = "";
        try {
            InputStream stream;
            stream = manager.open(jsonFilePath);
            java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
            encodedJson = s.hasNext() ? s.next() : "";

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            jsonLayout.decodeJson(encodedJson);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonLayout;
    }

    public String convert(InputStream inputStream, Charset charset) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}

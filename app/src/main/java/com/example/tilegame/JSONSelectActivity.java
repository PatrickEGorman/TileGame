package com.example.tilegame;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.IOException;

public class JSONSelectActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    public static final String MAP_MODE = "com.example.tilegame.MAP_MODE";
    public static final String FILE_NAME = "com.example.tilegame.FILE_NAME";
    private String current_file_selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_select);
        Spinner JSONSelector = findViewById(R.id.json_selector);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
               android.R.layout.simple_spinner_item, getFileNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        JSONSelector.setAdapter(adapter);
        JSONSelector.setOnItemSelectedListener(this);
    }

    public void generateMapButtonClick(View view){
        generateMapActivity(current_file_selection);

    }

    private void generateMapActivity(String fileName){
        Intent generate = new Intent(this, MapGenerateActivity.class);
        generate.putExtra(MAP_MODE, "json");
        generate.putExtra(FILE_NAME, fileName);
        startActivity(generate);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String current_menu_selection = parent.getItemAtPosition(pos).toString();
        this.current_file_selection = "maps/"+current_menu_selection+".json";
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    private String[] getFileNames(){
        AssetManager manager;
        manager = getAssets();
        String[] files = {""};
        try{
            files =  manager.list("maps/");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        for(int i=0;i<files.length; i++){
            files[i] = files[i].substring(0, files[i].length()-5);
        }
        return files;
    }
}

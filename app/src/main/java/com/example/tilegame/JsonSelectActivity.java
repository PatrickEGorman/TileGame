package com.example.tilegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class JsonSelectActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    public static final String MAP_MODE = "com.example.tilegame.MAP_MODE";
    public static final String FILE_NAME = "com.example.tilegame.FILE_NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_select);

//        Spinner jsonSelector = findViewById(R.id.json_selector);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                R.layout.activity_json_select, R.id.json_textview);
//        adapter.add("hi");
//        adapter.add("test");
//        jsonSelector.setAdapter(adapter);
//        jsonSelector.setOnItemSelectedListener(this);
    }

    public void generateMapButtonClick(View view){
        RadioGroup mapSelection = findViewById(R.id.json_radio_selector);
        int modeID = mapSelection.getCheckedRadioButtonId();
        switch(modeID){
            case R.id.islands:
                generateMapActivity("maps/islands.json");
                break;

            case R.id.mixed_landscape:
                generateMapActivity("maps/mixed_landscape.json");
                break;

            default:
                TextView mainMenuText = findViewById(R.id.errorDisplay);
                mainMenuText.setText("Please Select A Menu Option!");
        }

    }

    private void generateMapActivity(String fileName){
        Intent generate = new Intent(this, MapGenerateActivity.class);
        generate.putExtra(MAP_MODE, "json");
        generate.putExtra(FILE_NAME, fileName);
        startActivity(generate);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        System.out.println(parent.getItemAtPosition(pos));
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}

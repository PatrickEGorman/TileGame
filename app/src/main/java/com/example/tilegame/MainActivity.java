package com.example.tilegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MAP_MODE = "com.example.tilegame.MAP_MODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generateMapButtonClick(View view){
        RadioGroup mapSelection = findViewById(R.id.select_map_type);
        int modeID = mapSelection.getCheckedRadioButtonId();
        switch(modeID){
            case R.id.default_toggle:
                generateMapActivity("default");
                break;

            case R.id.random_toggle:
                generateMapActivity("random");
                break;

            case R.id.json_toggle:
                Intent generate = new Intent(this, JsonSelectActivity.class);
                startActivity(generate);
                break;

            default:
                TextView mainMenuText = findViewById(R.id.mainMenuText);
                mainMenuText.setText("Please Select A Menu Option!");
        }

    }

    private void generateMapActivity(String mode){
        Intent generate = new Intent(this, MapGenerateActivity.class);
        generate.putExtra(MAP_MODE, mode);
        startActivity(generate);
    }
}

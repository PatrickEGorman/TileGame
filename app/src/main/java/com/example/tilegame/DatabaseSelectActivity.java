package com.example.tilegame;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tilegame.database.RepoDatabase;
import com.example.tilegame.database.dao.LayoutDao;
import com.example.tilegame.database.dao.TileDao;
import com.example.tilegame.database.entity.Layout;
import com.example.tilegame.database.entity.Tile;
import com.example.tilegame.tileLayout.TileLayout;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSelectActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    public static final String MAP_MODE = "com.example.tilegame.MAP_MODE";
    public static final String MAP_NAME = "com.example.tilegame.MAP_NAME";
    private String current_selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_select);
        RepoDatabase.getDatabase(this).layoutDao().getLayouts().observe(this, new Observer<List<Layout>>(){
            @Override
            public void onChanged(@Nullable final List<Layout> layouts){
                setSpinnerAdapter(layouts);
            }
        });
    }

    public void generateMapButtonClick(View view){
        generateMapActivity(current_selection);
    }

    private void setSpinnerAdapter(List<Layout> layouts){
        if(layouts != null) {
            List<String> names = new ArrayList<>();
            for (int i = 0; i < layouts.size(); i++) {
                names.add(layouts.get(i).getName());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, names);
            Spinner mapSelector = findViewById(R.id.map_selector);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mapSelector.setAdapter(adapter);
            mapSelector.setOnItemSelectedListener(this);
        }
    }

    private void generateMapActivity(String mapName){
        if(mapName != null) {
            Intent generate = new Intent(this, MapGenerateActivity.class);
            generate.putExtra(MAP_MODE, "user");
            generate.putExtra(MAP_NAME, mapName);
            startActivity(generate);
        }
        else {
            TextView errorText = findViewById(R.id.errorDisplay);
            errorText.setText("No maps available!");
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String current_menu_selection = parent.getItemAtPosition(pos).toString();
        this.current_selection = current_menu_selection;
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void deleteMapActivity(View view) {
        if (this.current_selection != null) {
            RepoDatabase db = RepoDatabase.getDatabase(this);
            LayoutDao layoutDao = db.layoutDao();
            TileDao tileDao = db.tileDao();
            DatabaseAsyncTask asyncTask = new DatabaseAsyncTask(this.current_selection, layoutDao,
                    tileDao);
            asyncTask.execute();
        }
        else {
            TextView errorText = findViewById(R.id.errorDisplay);
            errorText.setText("No maps available!");
        }
    }

    private static class DatabaseAsyncTask extends AsyncTask<Void, Void, Integer> {

        private String name;
        private LayoutDao layoutDao;
        private TileDao tileDao;


        public DatabaseAsyncTask(String name, LayoutDao layoutDao, TileDao tileDao) {
            this.name = name;
            this.layoutDao = layoutDao;
            this.tileDao = tileDao;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            this.tileDao.deleteTiles(this.name);
            Layout layout = layoutDao.getLayoutFromName(this.name);
            layoutDao.deleteLayout(layout);
            return null;
        }
    }
}

package com.example.tilegame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.tilegame.tileLayout.AllGrassLayoutGenerator;
import com.example.tilegame.tileLayout.TileLayout;

public class LevelEditorActivity extends AppCompatActivity {

    private ImageView[][] tileImageViewList;
    private TileLayout tileLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_editor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        makeTileImageViewList();

        AllGrassLayoutGenerator gen = new AllGrassLayoutGenerator();
        tileLayout = gen.generateLayout(tileImageViewList, getAssets());
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
    /*
    Maps tiles into a grid
     */
    private void makeTileImageViewList(){
        this.tileImageViewList = new ImageView[9][13];
        //row 1
        this.tileImageViewList[0][0] = (ImageView) findViewById(R.id.tile11);
        this.tileImageViewList[1][0] = (ImageView) findViewById(R.id.tile12);
        this.tileImageViewList[2][0] = (ImageView) findViewById(R.id.tile13);
        this.tileImageViewList[3][0] = (ImageView) findViewById(R.id.tile14);
        this.tileImageViewList[4][0] = (ImageView) findViewById(R.id.tile15);
        this.tileImageViewList[5][0] = (ImageView) findViewById(R.id.tile16);
        this.tileImageViewList[6][0] = (ImageView) findViewById(R.id.tile17);
        this.tileImageViewList[7][0] = (ImageView) findViewById(R.id.tile18);
        this.tileImageViewList[8][0] = (ImageView) findViewById(R.id.tile19);

        //row 2
        this.tileImageViewList[0][1] = (ImageView) findViewById(R.id.tile21);
        this.tileImageViewList[1][1] = (ImageView) findViewById(R.id.tile22);
        this.tileImageViewList[2][1] = (ImageView) findViewById(R.id.tile23);
        this.tileImageViewList[3][1] = (ImageView) findViewById(R.id.tile24);
        this.tileImageViewList[4][1] = (ImageView) findViewById(R.id.tile25);
        this.tileImageViewList[5][1] = (ImageView) findViewById(R.id.tile26);
        this.tileImageViewList[6][1] = (ImageView) findViewById(R.id.tile27);
        this.tileImageViewList[7][1] = (ImageView) findViewById(R.id.tile28);
        this.tileImageViewList[8][1] = (ImageView) findViewById(R.id.tile29);

        //row 3
        this.tileImageViewList[0][2] = (ImageView) findViewById(R.id.tile31);
        this.tileImageViewList[1][2] = (ImageView) findViewById(R.id.tile32);
        this.tileImageViewList[2][2] = (ImageView) findViewById(R.id.tile33);
        this.tileImageViewList[3][2] = (ImageView) findViewById(R.id.tile34);
        this.tileImageViewList[4][2] = (ImageView) findViewById(R.id.tile35);
        this.tileImageViewList[5][2] = (ImageView) findViewById(R.id.tile36);
        this.tileImageViewList[6][2] = (ImageView) findViewById(R.id.tile37);
        this.tileImageViewList[7][2] = (ImageView) findViewById(R.id.tile38);
        this.tileImageViewList[8][2] = (ImageView) findViewById(R.id.tile39);

        //row 4
        this.tileImageViewList[0][3] = (ImageView) findViewById(R.id.tile41);
        this.tileImageViewList[1][3] = (ImageView) findViewById(R.id.tile42);
        this.tileImageViewList[2][3] = (ImageView) findViewById(R.id.tile43);
        this.tileImageViewList[3][3] = (ImageView) findViewById(R.id.tile44);
        this.tileImageViewList[4][3] = (ImageView) findViewById(R.id.tile45);
        this.tileImageViewList[5][3] = (ImageView) findViewById(R.id.tile46);
        this.tileImageViewList[6][3] = (ImageView) findViewById(R.id.tile47);
        this.tileImageViewList[7][3] = (ImageView) findViewById(R.id.tile48);
        this.tileImageViewList[8][3] = (ImageView) findViewById(R.id.tile49);

        //row 5
        this.tileImageViewList[0][4] = (ImageView) findViewById(R.id.tile51);
        this.tileImageViewList[1][4] = (ImageView) findViewById(R.id.tile52);
        this.tileImageViewList[2][4] = (ImageView) findViewById(R.id.tile53);
        this.tileImageViewList[3][4] = (ImageView) findViewById(R.id.tile54);
        this.tileImageViewList[4][4] = (ImageView) findViewById(R.id.tile55);
        this.tileImageViewList[5][4] = (ImageView) findViewById(R.id.tile56);
        this.tileImageViewList[6][4] = (ImageView) findViewById(R.id.tile57);
        this.tileImageViewList[7][4] = (ImageView) findViewById(R.id.tile58);
        this.tileImageViewList[8][4] = (ImageView) findViewById(R.id.tile59);

        //row 6
        this.tileImageViewList[0][5] = (ImageView) findViewById(R.id.tile61);
        this.tileImageViewList[1][5] = (ImageView) findViewById(R.id.tile62);
        this.tileImageViewList[2][5] = (ImageView) findViewById(R.id.tile63);
        this.tileImageViewList[3][5] = (ImageView) findViewById(R.id.tile64);
        this.tileImageViewList[4][5] = (ImageView) findViewById(R.id.tile65);
        this.tileImageViewList[5][5] = (ImageView) findViewById(R.id.tile66);
        this.tileImageViewList[6][5] = (ImageView) findViewById(R.id.tile67);
        this.tileImageViewList[7][5] = (ImageView) findViewById(R.id.tile68);
        this.tileImageViewList[8][5] = (ImageView) findViewById(R.id.tile69);

        //row 7
        this.tileImageViewList[0][6] = (ImageView) findViewById(R.id.tile71);
        this.tileImageViewList[1][6] = (ImageView) findViewById(R.id.tile72);
        this.tileImageViewList[2][6] = (ImageView) findViewById(R.id.tile73);
        this.tileImageViewList[3][6] = (ImageView) findViewById(R.id.tile74);
        this.tileImageViewList[4][6] = (ImageView) findViewById(R.id.tile75);
        this.tileImageViewList[5][6] = (ImageView) findViewById(R.id.tile76);
        this.tileImageViewList[6][6] = (ImageView) findViewById(R.id.tile77);
        this.tileImageViewList[7][6] = (ImageView) findViewById(R.id.tile78);
        this.tileImageViewList[8][6] = (ImageView) findViewById(R.id.tile79);

        //row 8
        this.tileImageViewList[0][7] = (ImageView) findViewById(R.id.tile81);
        this.tileImageViewList[1][7] = (ImageView) findViewById(R.id.tile82);
        this.tileImageViewList[2][7] = (ImageView) findViewById(R.id.tile83);
        this.tileImageViewList[3][7] = (ImageView) findViewById(R.id.tile84);
        this.tileImageViewList[4][7] = (ImageView) findViewById(R.id.tile85);
        this.tileImageViewList[5][7] = (ImageView) findViewById(R.id.tile86);
        this.tileImageViewList[6][7] = (ImageView) findViewById(R.id.tile87);
        this.tileImageViewList[7][7] = (ImageView) findViewById(R.id.tile88);
        this.tileImageViewList[8][7] = (ImageView) findViewById(R.id.tile89);

        //row 9
        this.tileImageViewList[0][8] = (ImageView) findViewById(R.id.tile91);
        this.tileImageViewList[1][8] = (ImageView) findViewById(R.id.tile92);
        this.tileImageViewList[2][8] = (ImageView) findViewById(R.id.tile93);
        this.tileImageViewList[3][8] = (ImageView) findViewById(R.id.tile94);
        this.tileImageViewList[4][8] = (ImageView) findViewById(R.id.tile95);
        this.tileImageViewList[5][8] = (ImageView) findViewById(R.id.tile96);
        this.tileImageViewList[6][8] = (ImageView) findViewById(R.id.tile97);
        this.tileImageViewList[7][8] = (ImageView) findViewById(R.id.tile98);
        this.tileImageViewList[8][8] = (ImageView) findViewById(R.id.tile99);

        //row 10
        this.tileImageViewList[0][9] = (ImageView) findViewById(R.id.tile101);
        this.tileImageViewList[1][9] = (ImageView) findViewById(R.id.tile102);
        this.tileImageViewList[2][9] = (ImageView) findViewById(R.id.tile103);
        this.tileImageViewList[3][9] = (ImageView) findViewById(R.id.tile104);
        this.tileImageViewList[4][9] = (ImageView) findViewById(R.id.tile105);
        this.tileImageViewList[5][9] = (ImageView) findViewById(R.id.tile106);
        this.tileImageViewList[6][9] = (ImageView) findViewById(R.id.tile107);
        this.tileImageViewList[7][9] = (ImageView) findViewById(R.id.tile108);
        this.tileImageViewList[8][9] = (ImageView) findViewById(R.id.tile109);

        //row 11
        this.tileImageViewList[0][10] = (ImageView) findViewById(R.id.tile111);
        this.tileImageViewList[1][10] = (ImageView) findViewById(R.id.tile112);
        this.tileImageViewList[2][10] = (ImageView) findViewById(R.id.tile113);
        this.tileImageViewList[3][10] = (ImageView) findViewById(R.id.tile114);
        this.tileImageViewList[4][10] = (ImageView) findViewById(R.id.tile115);
        this.tileImageViewList[5][10] = (ImageView) findViewById(R.id.tile116);
        this.tileImageViewList[6][10] = (ImageView) findViewById(R.id.tile117);
        this.tileImageViewList[7][10] = (ImageView) findViewById(R.id.tile118);
        this.tileImageViewList[8][10] = (ImageView) findViewById(R.id.tile119);

        //row 12
        this.tileImageViewList[0][11] = (ImageView) findViewById(R.id.tile121);
        this.tileImageViewList[1][11] = (ImageView) findViewById(R.id.tile122);
        this.tileImageViewList[2][11] = (ImageView) findViewById(R.id.tile123);
        this.tileImageViewList[3][11] = (ImageView) findViewById(R.id.tile124);
        this.tileImageViewList[4][11] = (ImageView) findViewById(R.id.tile125);
        this.tileImageViewList[5][11] = (ImageView) findViewById(R.id.tile126);
        this.tileImageViewList[6][11] = (ImageView) findViewById(R.id.tile127);
        this.tileImageViewList[7][11] = (ImageView) findViewById(R.id.tile128);
        this.tileImageViewList[8][11] = (ImageView) findViewById(R.id.tile129);

        //row 13
        this.tileImageViewList[0][12] = (ImageView) findViewById(R.id.tile131);
        this.tileImageViewList[1][12] = (ImageView) findViewById(R.id.tile132);
        this.tileImageViewList[2][12] = (ImageView) findViewById(R.id.tile133);
        this.tileImageViewList[3][12] = (ImageView) findViewById(R.id.tile134);
        this.tileImageViewList[4][12] = (ImageView) findViewById(R.id.tile135);
        this.tileImageViewList[5][12] = (ImageView) findViewById(R.id.tile136);
        this.tileImageViewList[6][12] = (ImageView) findViewById(R.id.tile137);
        this.tileImageViewList[7][12] = (ImageView) findViewById(R.id.tile138);
        this.tileImageViewList[8][12] = (ImageView) findViewById(R.id.tile139);
    }
}

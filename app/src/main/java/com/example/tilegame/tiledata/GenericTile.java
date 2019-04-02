package com.example.tilegame.tiledata;


public abstract class GenericTile {

    public String path;
    public String name;

    @Override
    public String toString(){
        return this.name ;
    }

}

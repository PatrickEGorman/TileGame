package com.example.tilegame.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

public class LayoutViewModel extends AndroidViewModel {

    private LayoutRepository mRepository;
    private Layout[] layouts;

    public LayoutViewModel(Application application) {
        super(application);
        mRepository = new LayoutRepository(application);
        layouts = mRepository.getAllLayouts();
    }

    Layout[] getAllWords() {
        return layouts;
    }

    void insert(Layout layout) {
        mRepository.insert(layout);
    }
}
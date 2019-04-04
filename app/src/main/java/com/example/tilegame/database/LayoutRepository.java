package com.example.tilegame.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

class LayoutRepository {

    private LayoutDao layoutDao;
    private Layout[] layouts;

    LayoutRepository(Application application) {
        LayoutRoomDatabase db = LayoutRoomDatabase.getDatabase(application);
        layoutDao = db.layoutDao();
        layouts = layoutDao.getLayouts();
    }

    Layout[] getAllLayouts() {
        return layouts;
    }

    void insert(Layout layout) {
        new insertAsyncTask(layoutDao).execute(layout);
    }

    private static class insertAsyncTask extends AsyncTask<Layout, Void, Void> {

        private LayoutDao mAsyncTaskDao;

        insertAsyncTask(LayoutDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Layout... params) {
            mAsyncTaskDao.insertLayout(params[0]);
            return null;
        }
    }
}
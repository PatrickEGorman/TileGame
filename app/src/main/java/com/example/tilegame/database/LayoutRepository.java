package com.example.tilegame.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

class LayoutRepository {

    private LayoutDao layoutDao;
    private Layout[] layouts;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    LayoutRepository(Application application) {
        LayoutRoomDatabase db = LayoutRoomDatabase.getDatabase(application);
        layoutDao = db.layoutDao();
        layouts = layoutDao.getLayouts();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    Layout[] getAllLayouts() {
        return layouts;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
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
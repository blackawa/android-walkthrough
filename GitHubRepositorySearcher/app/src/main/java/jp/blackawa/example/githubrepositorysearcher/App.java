package jp.blackawa.example.githubrepositorysearcher;

import android.app.Application;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

package jp.blackawa.example.githubrepositorysearcher;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.blackawa.example.githubrepositorysearcher.service.GitHubService;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public GitHubService provideGitHubService() {
        return new GitHubService();
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }
}

package mobsoft.hulcsa.com.moblab2017.ui;

import android.content.Context;


import de.greenrobot.event.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public EventBus prvideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }


    @Provides
    @Singleton
    public SelectedPresenter provideSelectedPresener() {
        return new SelectedPresenter();
    }

    @Provides
    @Singleton
    public AboutPresenter provideAboutPresenter() {
        return new AboutPresenter();
    }

}
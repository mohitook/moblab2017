package mobsoft.hulcsa.com.moblab2017;

import android.app.Application;

import mobsoft.hulcsa.com.moblab2017.ui.UIModule;

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
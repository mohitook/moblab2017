package mobsoft.hulcsa.com.moblab2017;

import android.app.Application;
import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.repository.Repository;
import mobsoft.hulcsa.com.moblab2017.ui.UIModule;

public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
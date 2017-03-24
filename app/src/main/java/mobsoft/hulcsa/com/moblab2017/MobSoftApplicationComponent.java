package mobsoft.hulcsa.com.moblab2017;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.hulcsa.com.moblab2017.ui.UIModule;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainActivity;


@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    //void inject(loginActivity a);

}

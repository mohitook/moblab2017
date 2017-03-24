package mobsoft.hulcsa.com.moblab2017;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.hulcsa.com.moblab2017.ui.UIModule;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutActivity;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainActivity;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedActivity;


@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(SelectedActivity selectedActivity);

    void inject(AboutActivity aboutActivity);

}

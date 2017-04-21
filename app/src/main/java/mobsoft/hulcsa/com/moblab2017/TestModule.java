package mobsoft.hulcsa.com.moblab2017;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;
import mobsoft.hulcsa.com.moblab2017.ui.UIModule;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedPresenter;
import mobsoft.hulcsa.com.moblab2017.utils.UiExecutor;


@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }

    @Provides
    public SelectedPresenter provideSelectedPresener() {
        return UIModule.provideSelectedPresener();
    }

    @Provides
    public AboutPresenter provideAboutPresenter() {
        return UIModule.provideAboutPresenter();
    }


    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}
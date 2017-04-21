package mobsoft.hulcsa.com.moblab2017.ui.about;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.moblab2017.interactor.about.AboutInteractor;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.events.GetRecipesEvent;
import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.ui.Presenter;

import static mobsoft.hulcsa.com.moblab2017.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class AboutPresenter extends Presenter<AboutScreen> {

    private static AboutPresenter instance = null;



    @Inject
    AboutInteractor aboutInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public AboutPresenter() {
    }

    public static AboutPresenter getInstance() {
        if (instance == null) {
            instance = new AboutPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(AboutScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void showAbout(About about){screen.showAbout(about);}

    public void getAbout(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                aboutInteractor.getAbout();
            }
        });
    }

    public void onEventMainThread(GetRecipesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                /*for(Todo t : event.getRecipes()){
                    screen.showMessage(t.getName());;
                }*/
                screen.showAbout(event.getAbout());
            }
        }
    }

}

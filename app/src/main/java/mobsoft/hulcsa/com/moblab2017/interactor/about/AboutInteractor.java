package mobsoft.hulcsa.com.moblab2017.interactor.about;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.events.GetRecipesEvent;
import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class AboutInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public AboutInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getAbout(){
        GetAboutEvent event = new GetAboutEvent();
        try {
            About about = repository.getAbout();
            event.setAbout(about);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

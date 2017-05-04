package mobsoft.hulcsa.com.moblab2017.interactor.about;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.network.about.AboutApi;
import mobsoft.hulcsa.com.moblab2017.repository.MemoryRepository;
import mobsoft.hulcsa.com.moblab2017.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class AboutInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    AboutApi aboutApi;

    public AboutInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getAbout(){
        GetAboutEvent event = new GetAboutEvent();
        try {
            //About about = repository.getAbout();
            About about = aboutApi.aboutGet().execute().body();
            event.setAbout(about);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

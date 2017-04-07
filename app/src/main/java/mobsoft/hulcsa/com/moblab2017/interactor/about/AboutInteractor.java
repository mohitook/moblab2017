package mobsoft.hulcsa.com.moblab2017.interactor.about;

import java.util.List;

import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class AboutInteractor {
    @Inject
    Repository repository;

    public void getAbout(){
        About about = repository.getAbout();
    }
}

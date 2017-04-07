package mobsoft.hulcsa.com.moblab2017.interactor;

import dagger.Module;
import dagger.Provides;
import mobsoft.hulcsa.com.moblab2017.interactor.about.AboutInteractor;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.RecipesInteractor;

/**
 * Created by mobsoft on 2017. 04. 07..
 */
@Module
public class InteractorModule {

    @Provides
    public RecipesInteractor provideRecipes(){
        return new RecipesInteractor();
    }

    @Provides
    public AboutInteractor provideAbout(){
        return new AboutInteractor();
    }
}

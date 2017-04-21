package mobsoft.hulcsa.com.moblab2017.interactor.recipe;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.events.GetRecipesEvent;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.events.SetFavouriteEvent;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.network.NetworkModule;
import mobsoft.hulcsa.com.moblab2017.network.recipe.RecipesApi;
import mobsoft.hulcsa.com.moblab2017.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class RecipesInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    RecipesApi recipesApi;

    public RecipesInteractor(){
        MobSoftApplication.injector.inject(this);
    }

    public void getRecipes(){
        GetRecipesEvent event = new GetRecipesEvent();
        try {
            //List<Recipe> recipes = repository.getRecipes();
            List<Recipe> recipes = new ArrayList<>();
            recipes = recipesApi.recipesGet().execute().body();
            Log.d("testt",recipes.toString());
            event.setRecipes(recipes);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }

    }

    public void setFavourite(Recipe recipe){
        SetFavouriteEvent event = new SetFavouriteEvent();
        event.setFavourite(recipe);
        try {
            repository.setFavourite(recipe);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

}

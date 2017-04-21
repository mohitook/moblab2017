package mobsoft.hulcsa.com.moblab2017.ui.selected;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.RecipesInteractor;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.events.GetRecipesEvent;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.ui.Presenter;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainPresenter;

import static mobsoft.hulcsa.com.moblab2017.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class SelectedPresenter extends Presenter<SelectedScreen>{

    private static MainPresenter instance = null;

    public static final String EXTRA_RECIPE_ID = "recipe_id";

    public Recipe selectedRecipe;

    @Inject
    RecipesInteractor recipesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public SelectedPresenter() {
    }

    public static MainPresenter getInstance() {
        if (instance == null) {
            instance = new MainPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(SelectedScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void showCookBookList(Recipe recipe){
        screen.showRecipe(recipe);
    }


    public void setFavourite(){
        //ha valamiyen event történt... képernyő érintés..
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.setFavourite(selectedRecipe);
            }
        });
    }

    //??!!
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
                screen.addFavorit(selectedRecipe);
            }
        }
    }

    public void addFavorite(Recipe recipe){
        screen.addFavorit(recipe);
    }

}

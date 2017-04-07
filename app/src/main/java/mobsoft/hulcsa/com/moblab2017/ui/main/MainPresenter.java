package mobsoft.hulcsa.com.moblab2017.ui.main;

import android.util.Log;

import java.util.List;
import java.util.concurrent.Executor;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.interactor.recipe.RecipesInteractor;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.events.GetRecipesEvent;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.ui.Presenter;

import static mobsoft.hulcsa.com.moblab2017.MobSoftApplication.injector;


public class MainPresenter extends Presenter<MainScreen> {

    private static MainPresenter instance = null;

    @Inject
    RecipesInteractor recipesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MainPresenter() {
    }

    public static MainPresenter getInstance() {
        if (instance == null) {
            instance = new MainPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);

    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void showCookBookList(List<Recipe> recipeList){
        screen.showRecipeList(recipeList);


    }

    public void getRecipes(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.getRecipes();
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
                screen.showRecipeList(event.getRecipes());
            }
        }
    }

}
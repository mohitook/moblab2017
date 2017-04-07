package mobsoft.hulcsa.com.moblab2017.ui.main;

import java.util.List;

import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.interactor.recipe.RecipesInteractor;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.ui.Presenter;


public class MainPresenter extends Presenter<MainScreen> {

    private static MainPresenter instance = null;

    @Inject
    RecipesInteractor recipesInteractor;

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
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showCookBookList(List<Recipe> recipeList){
        screen.showRecipeList(recipeList);
    }

}
package mobsoft.hulcsa.com.moblab2017.interactor.recipe;

import java.util.List;

import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class RecipesInteractor {
    @Inject
    Repository repository;

    public void getRecipes(){
        List<Recipe> recipes = repository.getRecipes();
    }

    public void setFavourite(Recipe recipe){
        repository.setFavourite(recipe);
    }

}

package mobsoft.hulcsa.com.moblab2017.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60*1000;

    public static List<Recipe> recipes;

    public static About about;

    @Override
    public void open(Context context) {


        Recipe recipe1 = new Recipe(1L, "Recipe1", "kamuImage", "directions", Arrays.asList("alma","banán"),false);
        Recipe recipe2 = new Recipe(2L, "Recipe1", "kamuImage", "directions", Arrays.asList("alma","banán"),false);
        recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        about = new About("Colos#Soft","http://www.vectortemplates.com/raster/batman-logo-big.gif","zsozzso(at)gmail.com","DO NOT COPY"); //http://www.vectortemplates.com/raster/batman-logo-big.gif

    }

    @Override
    public void close() {

    }

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public About getAbout() {
        return about;
    }

    @Override
    public void setFavourite(Recipe recipe) {
        for(int i = 0; i<recipes.size(); i++){
            if(recipes.get(i).getId() == recipe.getId()){
                recipes.set(i,recipe);
            }
        }
    }

    @Override
    public boolean isInDb(Recipe recipe) {
        return recipes.contains(recipe);
    }
}

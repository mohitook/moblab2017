package mobsoft.hulcsa.com.moblab2017.interactor.recipe.events;

import java.util.List;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class GetRecipesEvent {

    private int code;
    private List<Recipe> recipes;
    private About about;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetRecipesEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public About getAbout(){
        return about;
    }

    public void setFavourite(Recipe recipe) {
        for(int i = 0; i<this.recipes.size();i++){
            if(this.recipes.get(i).getId() == recipe.getId()){
                this.recipes.set(i, recipe);
            }
        }
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

package mobsoft.hulcsa.com.moblab2017.interactor.recipe.events;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class SetFavouriteEvent {

    private int code;
    private Recipe recipe;
    private About about;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public SetFavouriteEvent() {
    }

    public SetFavouriteEvent(int code, Recipe recipe, Throwable throwable) {
        		this.code = code;
        this.recipe = recipe;
        		this.throwable = throwable;
        	}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Recipe getRecipe() {
        return recipe;
    }


    public void setFavourite(Recipe recipe) {
        this.recipe = recipe;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

package mobsoft.hulcsa.com.moblab2017.ui.main;

import java.util.List;

import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public interface MainScreen {
    void showMessage(String text);

    void showRecipeList(List<Recipe> recipeList);

}
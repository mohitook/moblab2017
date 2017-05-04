package mobsoft.hulcsa.com.moblab2017.ui.selected;

import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public interface SelectedScreen {

    void showRecipe(Recipe recipe);

    void addFavorit(Recipe recipe);

    void showMessage(String error);

    void changeButtonColor();
}

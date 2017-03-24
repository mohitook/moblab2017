package mobsoft.hulcsa.com.moblab2017.ui.selected;

import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.ui.Presenter;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainPresenter;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class SelectedPresenter extends Presenter<SelectedScreen>{

    private static MainPresenter instance = null;

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
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showCookBookList(Recipe recipe){
        screen.showRecipe(recipe);
    }

    public void addFavorite(Recipe recipe){
        screen.addFavorit(recipe);
    }

}

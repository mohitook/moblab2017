package mobsoft.hulcsa.com.moblab2017.ui.about;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.ui.Presenter;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedScreen;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class AboutPresenter extends Presenter<AboutScreen> {

    private static AboutPresenter instance = null;

    public AboutPresenter() {
    }

    public static AboutPresenter getInstance() {
        if (instance == null) {
            instance = new AboutPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(AboutScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showAbout(About about){screen.showAbout(about);}

}

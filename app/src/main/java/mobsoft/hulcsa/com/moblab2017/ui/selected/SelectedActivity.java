package mobsoft.hulcsa.com.moblab2017.ui.selected;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.R;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class SelectedActivity extends AppCompatActivity implements SelectedScreen {

    @Inject
    SelectedPresenter selectedPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //injecting presenter
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        selectedPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        selectedPresenter.attachScreen(this);
    }

    @Override
    public void showRecipe(Recipe recipe) {

    }

    @Override
    public void addFavorit(Recipe recipe) {

    }
}

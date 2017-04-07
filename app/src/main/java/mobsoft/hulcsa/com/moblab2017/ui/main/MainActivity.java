package mobsoft.hulcsa.com.moblab2017.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.R;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

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
        MainPresenter.getInstance().attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.attachScreen(this);
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRecipeList(List<Recipe> recipeList) {

    }
}

package mobsoft.hulcsa.com.moblab2017.ui.selected;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.R;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutActivity;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class SelectedActivity extends AppCompatActivity implements SelectedScreen {

    public static Recipe SELECTED_RECIPE;

    @Inject
    SelectedPresenter selectedPresenter;

    private TextView title;
    ImageView image;
    LinearLayout ingredients;
    TextView directions;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        title = (TextView) findViewById(R.id.selected_title);
        image = (ImageView) findViewById(R.id.selected_image);
        ingredients = (LinearLayout) findViewById(R.id.selected_ingredients);
        directions = (TextView) findViewById(R.id.selected_directions);

        SELECTED_RECIPE=(Recipe)getIntent().getSerializableExtra("SELECTED_RECIPE");

        button = (Button) findViewById(R.id.selected_favourite);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                selectedPresenter.setFavourite();

            }
        });



        //injecting presenter
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        selectedPresenter.attachScreen(this);
        selectedPresenter.getRecipeCamouflage(SELECTED_RECIPE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        selectedPresenter.detachScreen();
    }

    @Override
    public void showRecipe(Recipe recipe) {
        //recipe = SELECTED_RECIPE;
        title.setText(recipe.getTitle());
        Glide.with(this).load(recipe.getTitleImage()).into(image);
        ingredients.removeAllViews();
        for(String item : recipe.getIngredients())
        {
            TextView itemView = new TextView(this);
            itemView.setText(item);
            ingredients.addView(itemView);
        }
        directions.setText(recipe.getDirections());

        if(recipe.getFavorite())
        {
            button.setBackgroundColor(0xffFFD700);
            button.setActivated(false);
        }
        else
        {
            button.setBackgroundColor(0xffFFD7ff);
            button.setActivated(true);
        }

    }

    @Override
    public void addFavorit(Recipe recipe) {
        selectedPresenter.setFavourite();
    }


    @Override
    public void showMessage(String error) {

    }

    @Override
    public void changeButtonColor() {
        button.setBackgroundColor(0xffFFD700);
        button.setActivated(false);
    }
}

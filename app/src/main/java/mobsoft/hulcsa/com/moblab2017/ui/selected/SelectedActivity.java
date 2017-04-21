package mobsoft.hulcsa.com.moblab2017.ui.selected;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.R;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class SelectedActivity extends AppCompatActivity implements SelectedScreen {

    public static final String EXTRA_RECIPE_ID = "recipe_id";

    @Inject
    SelectedPresenter selectedPresenter;

    private TextView title;
    ImageView image;
    LinearLayout ingredients;
    TextView directions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        title = (TextView) findViewById(R.id.selected_title);
        image = (ImageView) findViewById(R.id.selected_image);
        ingredients = (LinearLayout) findViewById(R.id.selected_ingredients);
        directions = (TextView) findViewById(R.id.selected_directions);

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
        title.setText(recipe.getTitle());
        Glide.with(this).load(recipe.getTitleImage()).into(image);
        for(String item : recipe.getIngredients())
        {
            TextView itemView = new TextView(this);
            itemView.setText(item);
            ingredients.addView(itemView);
        }
        directions.setText(recipe.getDirections());
    }

    @Override
    public void addFavorit(Recipe recipe) {
        selectedPresenter.setFavourite();
    }

    @Override
    public void showMessage(String error) {

    }
}

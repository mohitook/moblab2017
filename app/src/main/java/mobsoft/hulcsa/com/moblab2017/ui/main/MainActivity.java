package mobsoft.hulcsa.com.moblab2017.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.R;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutActivity;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;


    ListView list;
    String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    } ;
    Integer[] imageId = {
            R.drawable.windows_phone_8_logo_new,
            R.drawable.windows_phone_8_logo_new,
            R.drawable.windows_phone_8_logo_new,
            R.drawable.windows_phone_8_logo_new,
            R.drawable.windows_phone_8_logo_new,
            R.drawable.windows_phone_8_logo_new,
            R.drawable.windows_phone_8_logo_new

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.main_to_about);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
               startActivity(intent);
            }
        });

        CustomList adapter = new
                CustomList(MainActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.main_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SelectedActivity.class);
                //intent.putExtra(SelectedActivity.EXTRA_RECIPE_ID, recipe.getId());
                startActivity(intent);

            }
        });

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

    private class CustomList extends ArrayAdapter<String> {

        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;
        public CustomList(Activity context,
                          String[] web, Integer[] imageId) {
            super(context, R.layout.list_main, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;

        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.list_main, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.list_title);

            ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);
            txtTitle.setText(web[position]);

            imageView.setImageResource(imageId[position]);
            return rowView;
        }
    }


}

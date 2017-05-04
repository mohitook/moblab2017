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

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    private List<Recipe> recipeList;

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

        //injecting presenter
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mainPresenter.getRecipes();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        // Otherwise defer to system default behavior.
        //super.onBackPressed();
    }


    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRecipeList(final List<Recipe> recipeList) {

        this.recipeList = recipeList;

        CustomList adapter = new
                CustomList(MainActivity.this, recipeList);
        list=(ListView)findViewById(R.id.main_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " +recipeList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SelectedActivity.class);
                intent.putExtra("SELECTED_RECIPE", recipeList.get(position));
                startActivity(intent);
            }
        });



    }

    private class CustomList extends ArrayAdapter<Recipe> {

        private final Activity context;

        private List<Recipe> recipeList;


        public CustomList(Activity context, List<Recipe> recipeList ){
            super(context, R.layout.list_main, recipeList);
            this.context = context;
            this.recipeList = recipeList;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            if(recipeList == null ||recipeList.isEmpty())
            {
                LayoutInflater inflater = context.getLayoutInflater();
                View rowView= inflater.inflate(R.layout.list_main, null, true);
                TextView txtTitle = (TextView) rowView.findViewById(R.id.list_title);

                ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);
                txtTitle.setText(web[position]);

                imageView.setImageResource(imageId[position]);
                return rowView;
            }

            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.list_main, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.list_title);

            ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);
            txtTitle.setText(recipeList.get(position).getTitle());

            //imageView.setImageResource(imageId[position]);
            Glide.with(context).load(recipeList.get(position).getTitleImage()).into(imageView);
            return rowView;
        }
    }


}

package mobsoft.hulcsa.com.moblab2017.repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

import android.content.Context;
import java.util.List;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

public interface Repository {

    void open(Context context);

    void close();

    List<Recipe> getRecipes();

    About getAbout();

    void setFavourite(Recipe recipe);

    boolean isInDb(Recipe recipe);
}

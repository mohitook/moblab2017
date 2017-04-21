package mobsoft.hulcsa.com.moblab2017.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Recipe> getRecipes() {
        return SugarRecord.listAll(Recipe.class);
    }

    @Override
    public About getAbout() {
        return SugarRecord.listAll(About.class).get(0);
    }

    @Override
    public void setFavourite(Recipe recipe) {
        //List<Recipe> recipes = getRecipes();
        SugarRecord.saveInTx(recipe);
    }

    @Override
    public boolean isInDb(Recipe recipe) {
        return SugarRecord.findById(Recipe.class, recipe.getId()) != null;
    }
}

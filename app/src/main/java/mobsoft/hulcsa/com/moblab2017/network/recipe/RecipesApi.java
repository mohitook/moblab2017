package mobsoft.hulcsa.com.moblab2017.network.recipe;



import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RecipesApi {
  
  /**
   * Recipe list
   * Recipes for the application
   * @return Call<List<Recipe>>
   */
  
  @GET("recipes")
  Call<List<Recipe>> recipesGet();
    

  
  /**
   * Recipe list
   * Recipes for the application
   * @param recipe recipe which favourite set
   * @return Call<List<Recipe>>
   */
  
  @POST("recipes/favourite")
  Call<List<Recipe>> recipesFavouritePost(
    @Body Recipe recipe
  );

  
}

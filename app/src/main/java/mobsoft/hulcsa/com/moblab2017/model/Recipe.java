package mobsoft.hulcsa.com.moblab2017.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Recipe   {
  
  @SerializedName("id")
  private Long id = null;
  
  @SerializedName("title")
  private String title = null;
  
  @SerializedName("titleImage")
  private String titleImage = null;
  
  @SerializedName("directions")
  private String directions = null;
  
  @SerializedName("ingredients")
  private List<String> ingredients = new ArrayList<String>();
  
  @SerializedName("favorite")
  private Boolean favorite = null;

  public Recipe(Long id, String title, String titleImage, String directions, List<String> ingredients, Boolean favorite) {
    this.id = id;
    this.title = title;
    this.titleImage = titleImage;
    this.directions = directions;
    this.ingredients = ingredients;
    this.favorite = favorite;
  }


  /**
   * Id of the recipe.
   **/
  @ApiModelProperty(value = "Id of the recipe.")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   * Title of the Recipe.
   **/
  @ApiModelProperty(value = "Title of the Recipe.")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   * Image URL of the Recipe.
   **/
  @ApiModelProperty(value = "Image URL of the Recipe.")
  public String getTitleImage() {
    return titleImage;
  }
  public void setTitleImage(String titleImage) {
    this.titleImage = titleImage;
  }

  
  /**
   * Directions for the recipe.
   **/
  @ApiModelProperty(value = "Directions for the recipe.")
  public String getDirections() {
    return directions;
  }
  public void setDirections(String directions) {
    this.directions = directions;
  }

  
  /**
   * Ingredients of the recipe.
   **/
  @ApiModelProperty(value = "Ingredients of the recipe.")
  public List<String> getIngredients() {
    return ingredients;
  }
  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }

  
  /**
   * Promo code of the Uber user.
   **/
  @ApiModelProperty(value = "Promo code of the Uber user.")
  public Boolean getFavorite() {
    return favorite;
  }
  public void setFavorite(Boolean favorite) {
    this.favorite = favorite;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(id, recipe.id) &&
        Objects.equals(title, recipe.title) &&
        Objects.equals(titleImage, recipe.titleImage) &&
        Objects.equals(directions, recipe.directions) &&
        Objects.equals(ingredients, recipe.ingredients) &&
        Objects.equals(favorite, recipe.favorite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, titleImage, directions, ingredients, favorite);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipe {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    titleImage: ").append(toIndentedString(titleImage)).append("\n");
    sb.append("    directions: ").append(toIndentedString(directions)).append("\n");
    sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
    sb.append("    favorite: ").append(toIndentedString(favorite)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

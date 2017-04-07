package mobsoft.hulcsa.com.moblab2017.model;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

import com.orm.dsl.Table;

@Table
public class Recipe {

    private Long id = null;
    private String title;
    private String titleImage;
    private String directions;
    private List<String> ingredients;
    private boolean favorite;


    public Recipe(Long id, String title, String titleImage, String directions, List<String> ingredients, boolean favorite) {
        this.id = id;
        this.title = title;
        this.titleImage = titleImage;
        this.directions = directions;
        this.ingredients = ingredients;
        this.favorite = favorite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTileImage() {
        return titleImage;
    }

    public void setTileImage(String tileImage) {
        tileImage = tileImage;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        directions = directions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        ingredients = ingredients;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        favorite = favorite;
    }


}

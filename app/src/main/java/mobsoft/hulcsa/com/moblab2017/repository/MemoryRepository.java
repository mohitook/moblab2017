package mobsoft.hulcsa.com.moblab2017.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60*1000;

    public static List<Recipe> recipes;

    public static About about;

    public MemoryRepository() {
        Recipe recipe1 = new Recipe(1L, "Alma & Banán", "http://www.mindmegette.hu/images/113/O/125921_banan_alma-201510171525.jpg", "directions", Arrays.asList("alma","banán"),false);
        recipe1.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");

        Recipe recipe2 = new Recipe(2L, "Pizza", "http://pikanteria.sztarcafe.com/wp-content/uploads/2015/10/bogres-pizza-teszta.jpg", "directions", Arrays.asList("PizzaLap","Zöldség","Sajt","Hús","Ketchup"),false);
        recipe2.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");

        Recipe recipe3 = new Recipe(3L, "Süti", "https://s3-eu-west-1.amazonaws.com/receptmuhely.hu/recept1i/img/variants/535x0/kokuszos-suti-2.jpg", "directions", Arrays.asList("Cukor","Só","S minden mi jó","X Vegyszer"),false);
        recipe3.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");


        Recipe recipe4 = new Recipe(4L, "Spagetti", "https://i.ytimg.com/vi/EdxRA28JD5E/maxresdefault.jpg", "directions", Arrays.asList("Tészta","Milanoi alap","Darált hús","Só","Bors","Sajt"),false);
        recipe4.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");


        Recipe recipe5 = new Recipe(5L, "Töltött pulyka", "http://static.femina.hu/karacsony/gesztenyevel_toltott_karacsonyi_pulyka/pulyka2.jpg", "directions", Arrays.asList("Pulyka","Töltelék"),false);
        recipe5.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");


        Recipe recipe6 = new Recipe(6L, "Koplalás", "https://openclipart.org/image/2400px/svg_to_png/129703/no-food-drink.png", "directions", Arrays.asList("Nem","Eszel","Semmit!!!"),false);
        recipe6.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");

        Recipe recipe7 = new Recipe(7L, "Svéd Asztal", "https://www.cserekert.ro/pictures/Aktualis/svedasztal.jpg", "directions", Arrays.asList("Svéd", "Fa lap", "Szerszámok", "Asztal láb"),false);
        recipe7.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");


        recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);
        recipes.add(recipe5);
        recipes.add(recipe6);
        recipes.add(recipe7);
        about = new About("Colos#Soft","http://logonoid.com/images/batman-logo.png","zsozzso(at)gmail.com","DO NOT COPY"); //http://www.vectortemplates.com/raster/batman-logo-big.gif
    }

    @Override
    public void open(Context context) {


        Recipe recipe1 = new Recipe(1L, "Alma & Banán", "http://www.mindmegette.hu/images/113/O/125921_banan_alma-201510171525.jpg", "directions", Arrays.asList("alma","banán"),false);
        recipe1.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");

        Recipe recipe2 = new Recipe(2L, "Pizza", "http://pikanteria.sztarcafe.com/wp-content/uploads/2015/10/bogres-pizza-teszta.jpg", "directions", Arrays.asList("PizzaLap","Zöldség","Sajt","Hús","Ketchup"),false);
        recipe2.setDirections("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eleifend pellentesque tellus sit amet sodales. Etiam venenatis imperdiet arcu. Suspendisse risus odio, pulvinar ut semper in, pharetra convallis nisl. Vivamus eu arcu dapibus, mattis dolor blandit, pellentesque libero. Nam erat enim, dapibus pellentesque pellentesque in, ullamcorper non ligula. Aenean pharetra ultrices magna ut ultricies. Aliquam dictum condimentum dolor, ut sollicitudin lorem viverra id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Fusce pellentesque sollicitudin tellus id viverra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed semper felis orci, et faucibus nisl malesuada et. Maecenas fringilla est at massa volutpat elementum. Cras sit amet bibendum est. Nam volutpat at odio at porta. Fusce lectus orci, commodo eu pulvinar blandit, iaculis ut risus. Nulla a tellus imperdiet, imperdiet neque eget, consectetur nulla. Donec sapien neque, viverra ac dolor non, viverra venenatis mauris.");

        recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe1);
        recipes.add(recipe2);
        about = new About("Colos#Soft","http://logonoid.com/images/batman-logo.png","zsozzso(at)gmail.com","DO NOT COPY"); //http://www.vectortemplates.com/raster/batman-logo-big.gif

    }

    @Override
    public void close() {

    }

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public About getAbout() {
        return about;
    }

    @Override
    public void setFavourite(Recipe recipe) {
        recipe.setFavorite(true);
        for(int i = 0; i<recipes.size(); i++){
            if(recipes.get(i).getId() == recipe.getId()){
                recipes.set(i,recipe);
            }
        }
    }

    @Override
    public boolean isInDb(Recipe recipe) {
        return recipes.contains(recipe);
    }
}

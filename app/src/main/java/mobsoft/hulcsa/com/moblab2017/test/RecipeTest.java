package mobsoft.hulcsa.com.moblab2017.test;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;


import mobsoft.hulcsa.com.moblab2017.BuildConfig;
import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutScreen;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainScreen;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedScreen;
import mobsoft.hulcsa.com.moblab2017.utils.RobolectricDaggerTestRunner;

import static mobsoft.hulcsa.com.moblab2017.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RecipeTest {

    private MainPresenter mainPresenter;
    private SelectedPresenter selectedPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
        selectedPresenter = new SelectedPresenter();
    }

    @Test
    public void testRecipes() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.getRecipes();

        ArgumentCaptor<List> recipesCaptor = ArgumentCaptor.forClass(List.class);

        verify(mainScreen, times(1)).showRecipeList(recipesCaptor.capture());

        List<Recipe> capturedRecipes = recipesCaptor.getValue();
        assertEquals(1L, capturedRecipes.get(0).getId().longValue());
        assertEquals(2L, capturedRecipes.get(1).getId().longValue());
    }

    @Test
    public void testRecipe() {
        SelectedScreen selectedScreen = mock(SelectedScreen.class);
        selectedPresenter.attachScreen(selectedScreen);
        Recipe recipe1 = new Recipe(1L, "Alma & Banán", "http://www.mindmegette.hu/images/113/O/125921_banan_alma-201510171525.jpg", "directions", Arrays.asList("alma","banán"),false);
        selectedPresenter.getRecipeCamouflage(recipe1);
        selectedPresenter.setFavourite();

        ArgumentCaptor<Recipe> recipesCaptor = ArgumentCaptor.forClass(Recipe.class);

        verify(selectedScreen, times(3)).showRecipe(recipesCaptor.capture());

        Recipe capturedRecipe = recipesCaptor.getValue();
        assertEquals(1L, capturedRecipe.getId().longValue());
    }

    @Test
    public void testRecipeFavourite() {
        SelectedScreen selectedScreen = mock(SelectedScreen.class);
        selectedPresenter.attachScreen(selectedScreen);
        Recipe recipe1 = new Recipe(1L, "Alma & Banán", "http://www.mindmegette.hu/images/113/O/125921_banan_alma-201510171525.jpg", "directions", Arrays.asList("alma","banán"),false);
        selectedPresenter.getRecipeCamouflage(recipe1);
        selectedPresenter.setFavourite();

        ArgumentCaptor<Recipe> recipesCaptor = ArgumentCaptor.forClass(Recipe.class);

        verify(selectedScreen, times(3)).showRecipe(recipesCaptor.capture());

        Recipe capturedRecipe = recipesCaptor.getValue();
        assertEquals(true, capturedRecipe.getFavorite());
    }


    @After
    public void tearDown() {
        //aboutPresenter.detachScreen();
        //mainPresenter.detachScreen();
    }
}

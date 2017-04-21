package mobsoft.hulcsa.com.moblab2017.test;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

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
    private AboutPresenter aboutPresenter;
    private SelectedPresenter selectedPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
        aboutPresenter = new AboutPresenter();
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

   /* @Test
    public void testRecipe() {
        SelectedScreen selectedScreen = mock(SelectedScreen.class);
        selectedPresenter.attachScreen(selectedScreen);
        selectedPresenter.setFavourite();

        ArgumentCaptor<List> recipesCaptor = ArgumentCaptor.forClass(List.class);

        verify(selectedScreen, times(1)).showRecipeList(recipesCaptor.capture());

        List<Recipe> capturedRecipes = recipesCaptor.getValue();
        assertEquals(1L, capturedRecipes.get(0).getId().longValue());
        assertEquals(2L, capturedRecipes.get(1).getId().longValue());
    }*/

    @Test
    public void testAbout() {
        AboutScreen aboutScreen = mock(AboutScreen.class);
        aboutPresenter.attachScreen(aboutScreen);
        aboutPresenter.getAbout();

        ArgumentCaptor<About> recipesCaptor = ArgumentCaptor.forClass(About.class);

        verify(aboutScreen, times(1)).showAbout(recipesCaptor.capture());

        About capturedRecipes = recipesCaptor.getValue();
        assertEquals("Colos#Soft", capturedRecipes.getTitle());
    }

    @After
    public void tearDown() {
        //aboutPresenter.detachScreen();
        //mainPresenter.detachScreen();
    }
}

package mobsoft.hulcsa.com.moblab2017;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.hulcsa.com.moblab2017.interactor.InteractorModule;
import mobsoft.hulcsa.com.moblab2017.interactor.about.AboutInteractor;
import mobsoft.hulcsa.com.moblab2017.interactor.recipe.RecipesInteractor;
import mobsoft.hulcsa.com.moblab2017.mock.MockNetworkModule;
import mobsoft.hulcsa.com.moblab2017.network.NetworkModule;
import mobsoft.hulcsa.com.moblab2017.repository.RepositoryModule;
import mobsoft.hulcsa.com.moblab2017.ui.UIModule;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutActivity;
import mobsoft.hulcsa.com.moblab2017.ui.about.AboutPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainActivity;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainPresenter;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedActivity;
import mobsoft.hulcsa.com.moblab2017.ui.selected.SelectedPresenter;


@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, MockNetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(SelectedActivity selectedActivity);

    void inject(AboutActivity aboutActivity);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainPresenter mainPresenter);

    void inject(AboutPresenter mainPresenter);

    void inject(SelectedPresenter mainPresenter);

    void inject(RecipesInteractor recipesInteractor);

    void inject(AboutInteractor aboutInteractor);

}

package mobsoft.hulcsa.com.moblab2017;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.hulcsa.com.moblab2017.interactor.InteractorModule;
import mobsoft.hulcsa.com.moblab2017.mock.MockNetworkModule;
import mobsoft.hulcsa.com.moblab2017.repository.TestRepositoryModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}

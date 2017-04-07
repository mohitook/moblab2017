package mobsoft.hulcsa.com.moblab2017.repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository(){
        return new SugarOrmRepository();
    }
}

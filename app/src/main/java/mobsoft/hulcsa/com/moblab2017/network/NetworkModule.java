package mobsoft.hulcsa.com.moblab2017.network;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.hulcsa.com.moblab2017.network.about.AboutApi;
import mobsoft.hulcsa.com.moblab2017.network.recipe.RecipesApi;
import mobsoft.hulcsa.com.moblab2017.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public RecipesApi provideATodoApi(Retrofit retrofit) {
        return retrofit.create(RecipesApi.class);
    }

    @Provides
    @Singleton
    public AboutApi provideAboutApi(Retrofit retrofit) {
        return retrofit.create(AboutApi.class);
    }


}

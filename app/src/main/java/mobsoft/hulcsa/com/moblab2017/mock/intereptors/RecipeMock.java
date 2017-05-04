package mobsoft.hulcsa.com.moblab2017.mock.intereptors;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import mobsoft.hulcsa.com.moblab2017.model.Recipe;
import mobsoft.hulcsa.com.moblab2017.network.NetworkConfig;
import mobsoft.hulcsa.com.moblab2017.repository.MemoryRepository;
import mobsoft.hulcsa.com.moblab2017.utils.GsonHelper;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

import static mobsoft.hulcsa.com.moblab2017.mock.intereptors.MockHelper.makeResponse;


public class RecipeMock {
    public static MemoryRepository memoryRepository = new MemoryRepository();
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipes/favourite") && request.method().equals("POST")) {


            String asd = bodyToString( request.body());
            Recipe recipe = GsonHelper.getGson().fromJson(asd,Recipe.class);
            memoryRepository.setFavourite(recipe);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getRecipes());
            responseCode = 200;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipes") && request.method().equals("GET")) {

            Log.d("test2",memoryRepository.getRecipes().toString());
            responseString = GsonHelper.getGson().toJson(memoryRepository.getRecipes());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}

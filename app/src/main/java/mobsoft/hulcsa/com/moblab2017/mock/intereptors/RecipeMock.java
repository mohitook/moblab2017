package mobsoft.hulcsa.com.moblab2017.mock.intereptors;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

import android.net.Uri;
import android.util.Log;

import mobsoft.hulcsa.com.moblab2017.network.NetworkConfig;
import mobsoft.hulcsa.com.moblab2017.repository.MemoryRepository;
import mobsoft.hulcsa.com.moblab2017.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static mobsoft.hulcsa.com.moblab2017.mock.intereptors.MockHelper.makeResponse;


public class RecipeMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipes/favourite") && request.method().equals("POST")) {
            responseString = "this is now your favourite:" + request.body().toString();
            responseCode = 200;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipes") && request.method().equals("GET")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            Log.d("test2",memoryRepository.getRecipes().toString());
            responseString = GsonHelper.getGson().toJson(memoryRepository.getRecipes());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}

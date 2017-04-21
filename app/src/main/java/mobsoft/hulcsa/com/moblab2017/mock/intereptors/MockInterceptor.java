package mobsoft.hulcsa.com.moblab2017.mock.intereptors;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import mobsoft.hulcsa.com.moblab2017.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static mobsoft.hulcsa.com.moblab2017.mock.intereptors.MockHelper.makeResponse;


public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();


        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "recipes")) {
            return RecipeMock.process(request);
        }
        else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "recipes/favourite")) {
            return RecipeMock.process(request);
        }
        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "about")) {
            return AboutMock.process(request);
        }





        return makeResponse(request, headers, 404, "Unknown");

    }

}

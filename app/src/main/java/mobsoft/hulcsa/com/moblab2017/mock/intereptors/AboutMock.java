package mobsoft.hulcsa.com.moblab2017.mock.intereptors;

import android.net.Uri;

import mobsoft.hulcsa.com.moblab2017.network.NetworkConfig;
import mobsoft.hulcsa.com.moblab2017.repository.MemoryRepository;
import mobsoft.hulcsa.com.moblab2017.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static mobsoft.hulcsa.com.moblab2017.mock.intereptors.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 04. 21..
 */


public class AboutMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "about") && request.method().equals("Get")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getAbout());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}

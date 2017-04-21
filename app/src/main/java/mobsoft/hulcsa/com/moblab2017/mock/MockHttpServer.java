package mobsoft.hulcsa.com.moblab2017.mock;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

import mobsoft.hulcsa.com.moblab2017.mock.intereptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}

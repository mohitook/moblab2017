package mobsoft.hulcsa.com.moblab2017.network.about;

import mobsoft.hulcsa.com.moblab2017.model.About;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AboutApi {
  
  /**
   * About informations
   * About information for the mobile application
   * @return Call<About>
   */
  
  @GET("about")
  Call<About> aboutGet();
    

  
}

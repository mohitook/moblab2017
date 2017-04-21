package mobsoft.hulcsa.com.moblab2017.ui.about;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.R;
import mobsoft.hulcsa.com.moblab2017.model.About;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class AboutActivity extends AppCompatActivity implements AboutScreen{

    @Inject
    AboutPresenter aboutPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //injecting presenter
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        aboutPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        aboutPresenter.attachScreen(this);
    }


    @Override
    public void showAbout(About about) {

    }
    
    @Override
    public void showMessage(String error){
        
    }
    
}

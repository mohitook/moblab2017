package mobsoft.hulcsa.com.moblab2017.ui.about;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.io.InputStream;
import java.net.URL;

import javax.inject.Inject;

import mobsoft.hulcsa.com.moblab2017.MobSoftApplication;
import mobsoft.hulcsa.com.moblab2017.R;
import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class AboutActivity extends AppCompatActivity implements AboutScreen{

    @Inject
    AboutPresenter aboutPresenter;

    private Tracker mTracker;

    private TextView title;
    private ImageView image;
    private TextView contact;
    private TextView copyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        title = (TextView) findViewById(R.id.about_title);
        contact = (TextView) findViewById(R.id.about_contact);
        copyright = (TextView) findViewById(R.id.about_copyright);
        image = (ImageView) findViewById(R.id.about_logo);
        //injecting presenter

        // Obtain the shared Tracker instance.
               MobSoftApplication application = (MobSoftApplication) getApplication();
               mTracker = application.getDefaultTracker();
        mTracker.setScreenName("Image~" + "ALMA");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        MobSoftApplication.injector.inject(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        aboutPresenter.attachScreen(this);
        aboutPresenter.getAbout();
        mTracker.setScreenName("Image~MainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStop() {
        super.onStop();
        aboutPresenter.detachScreen();
    }


    @Override
    public void showAbout(About about) {
        title.setText(about.getTitle());
        contact.setText(about.getContact());
        copyright.setText(about.getCopyright());
        Glide.with(this).load(about.getImage()).into(image);
    }
    
    @Override
    public void showMessage(String error){
        
    }

    @Override
    public void onBackPressed() {

        // Otherwise defer to system default behavior.
        super.onBackPressed();
    }


      public void forceCrash(View view) {
                throw new RuntimeException("This is a crash");
            }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
    
}

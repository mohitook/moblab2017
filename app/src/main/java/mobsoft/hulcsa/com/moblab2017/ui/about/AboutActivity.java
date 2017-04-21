package mobsoft.hulcsa.com.moblab2017.ui.about;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.URL;

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
        MobSoftApplication.injector.inject(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        aboutPresenter.attachScreen(this);
        aboutPresenter.getAbout();
    }

    @Override
    protected void onStop() {
        super.onStop();
        aboutPresenter.attachScreen(this);
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

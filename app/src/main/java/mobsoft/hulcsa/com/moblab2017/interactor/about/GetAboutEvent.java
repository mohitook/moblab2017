package mobsoft.hulcsa.com.moblab2017.interactor.about;

import java.util.List;

import mobsoft.hulcsa.com.moblab2017.model.About;
import mobsoft.hulcsa.com.moblab2017.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class GetAboutEvent {

    private int code;
    private About about;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">


    public GetAboutEvent() {
    }

    public GetAboutEvent(int code, About about, Throwable throwable) {
        this.code = code;
        this.about = about;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public void setAbout(About about) {
        this.about = about;
    }

    public About getAbout(){
        return about;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

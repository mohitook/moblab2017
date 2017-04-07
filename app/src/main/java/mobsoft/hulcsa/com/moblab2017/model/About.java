package mobsoft.hulcsa.com.moblab2017.model;

/**
 * Created by mobsoft on 2017. 03. 24..
 */
import com.orm.dsl.Table;

@Table
public class About {


    public String title;
    public String image;
    public String contact;
    public String copyright;

    public About(String title, String image, String contact, String copyright) {
        this.title = title;
        this.image = image;
        this.contact = contact;
        this.copyright = copyright;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }


}

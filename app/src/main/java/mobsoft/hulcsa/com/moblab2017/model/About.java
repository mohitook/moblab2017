package mobsoft.hulcsa.com.moblab2017.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class About   {
  
  @SerializedName("title")
  private String title = null;
  
  @SerializedName("image")
  private String image = null;
  
  @SerializedName("contact")
  private String contact = null;
  
  @SerializedName("copyright")
  private String copyright = null;

  public About(String title, String image, String contact, String copyright) {
    this.title = title;
    this.image = image;
    this.contact = contact;
    this.copyright = copyright;
  }

  /**
   * Title of the About.
   **/
  @ApiModelProperty(value = "Title of the About.")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   * Logo of the company.
   **/
  @ApiModelProperty(value = "Logo of the company.")
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  
  /**
   * Company contact.
   **/
  @ApiModelProperty(value = "Company contact.")
  public String getContact() {
    return contact;
  }
  public void setContact(String contact) {
    this.contact = contact;
  }

  
  /**
   * Copyright.
   **/
  @ApiModelProperty(value = "Copyright.")
  public String getCopyright() {
    return copyright;
  }
  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    About about = (About) o;
    return Objects.equals(title, about.title) &&
        Objects.equals(image, about.image) &&
        Objects.equals(contact, about.contact) &&
        Objects.equals(copyright, about.copyright);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, image, contact, copyright);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class About {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

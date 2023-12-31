/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author TInh
 */
public class GooglePojo {
  @SerializedName("id")
  private String id;

  @SerializedName("email")
  private String email;

  @SerializedName("verified_email")
  private boolean verifiedEmail;

  @SerializedName("name")
  private String name;

  @SerializedName("given_name")
  private String givenName;

  @SerializedName("family_name")
  private String familyName;

  @SerializedName("link")
  private String link;

  @SerializedName("picture")
  private String picture;


    public GooglePojo() {
    }

    public GooglePojo(String id, String email, boolean verifiedEmail, String name, String givenName, String familyName, String link, String picture) {
        this.id = id;
        this.email = email;
        this.verifiedEmail = verifiedEmail;
        this.name = name;
        this.givenName = givenName;
        this.familyName = familyName;
        this.link = link;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(boolean verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

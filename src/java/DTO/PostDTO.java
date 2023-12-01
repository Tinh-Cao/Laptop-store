/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author msi
 */
public class PostDTO extends AccountDTO{

    private int postID;
    private String accountID;
    private String title;
    private String Description;
    private int type;
    private String create_date;
    private String modify_date;

    public PostDTO() {
    }

    public PostDTO(int postID, String accountID, String title, String Description, int type, String create_date, String modify_date) {
        this.postID = postID;
        this.accountID = accountID;
        this.title = title;
        this.Description = Description;
        this.type = type;
        this.create_date = create_date;
        this.modify_date = modify_date;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getModify_date() {
        return modify_date;
    }

    public void setModify_date(String modify_date) {
        this.modify_date = modify_date;
    }

}

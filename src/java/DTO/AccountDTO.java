/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author msi
 */
public class AccountDTO {

    //AccountID	Username	Password	Fullname	Phone	Email	Address	Role
    private String AccountID;
    private String Username;
    private String Password;
    private String Fullname;
    private String Phone;
    private String Email;
    private String Address;
    private int Role;
    private int AccountStatus;

    public AccountDTO() {
    }

    public AccountDTO(String AccountID, String Username, String Password, String Fullname, String Phone, String Email, String Address, int Role, int AccountStatus) {
        this.AccountID = AccountID;
        this.Username = Username;
        this.Password = Password;
        this.Fullname = Fullname;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Role = Role;
        this.AccountStatus = AccountStatus;
    }

    public int getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(int AccountStatus) {
        this.AccountStatus = AccountStatus;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "AccountDTO{" + "AccountID=" + AccountID + ", Username=" + Username + ", Password=" + Password + ", Fullname=" + Fullname + ", Phone=" + Phone + ", Email=" + Email + ", Address=" + Address + ", Role=" + Role + '}';
    }

}

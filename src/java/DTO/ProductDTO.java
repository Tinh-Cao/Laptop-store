/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author msi
 */
public class ProductDTO extends CategoryDTO {

    //ProductID	CategoryID	Name	QuantityAvailable		RamCapacity	StorageCapacity	CpuBrand	VgaBrand
    private int productID;
    private int categoryID;
    private String pname;
    private int quantity;
    private double price;
    private String ram;
    private String storage;
    private String cpu;
    private String vga;
    private int Status;
    private String image;

    public ProductDTO() {
    }

    public ProductDTO(int productID, int categoryID, String pname, int quantity, double price, String ram, String storage, String cpu, String vga, int Status) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.pname = pname;
        this.quantity = quantity;
        this.price = price;
        this.ram = ram;
        this.storage = storage;
        this.cpu = cpu;
        this.vga = vga;
        this.Status = Status;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", categoryID=" + categoryID + ", name=" + pname + ", quantity=" + quantity + ", price=" + price + ", ram=" + ram + ", storage=" + storage + ", cpu=" + cpu + ", vga=" + vga + ", Status=" + Status + '}';
    }

}

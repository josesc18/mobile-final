package pe.com.ritmocolorsabor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("price")
    @Expose
    private double price;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("state")
    @Expose
    private boolean state;

    @SerializedName("category")
    @Expose
    private int category;

    public Product() {
    }

    public Product(int id, String name, String image, double price, String time, boolean state, int category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.time = time;
        this.state = state;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}

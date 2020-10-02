import java.util.Date;

public class Cars {
    private long id;
    private String brand;
    private String model;
    private String bodyStyle;
    private Date yearOfManufacture;
    private String color;
    private double price;

    public Cars(){

    }

    public Cars(long id, String brand, String model, String bodyStyle, Date yearOfManufacture, String color, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.bodyStyle = bodyStyle;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public Date getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Date yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

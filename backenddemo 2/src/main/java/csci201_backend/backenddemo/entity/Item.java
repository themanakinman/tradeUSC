package csci201_backend.backenddemo.entity;
import jakarta.persistence.*;

@Entity
@Table(name="Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private int item_id;



    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Override
    public String toString() {
        return "Item{" +
                "ite_id=" + item_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image_url='" + image_url + '\'' +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Column(name="image_url")
    private String image_url;

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public Item(int item_id,  String title, String description, double price, String image_url, String category, String location) {
        this.item_id = item_id;

        this.title = title;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.category = category;
        this.location = location;
    }


    public int getItem_id() {
        return item_id;
    }

    public void setItem_id_id(int item_id) {
        this.item_id = item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name="category")
    private String category;

    @Column(name="location")
    private String location;

   public Item(){}

}

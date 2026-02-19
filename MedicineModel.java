package medstore;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicine")
public class MedicineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String category;

    @Column(nullable=false)
    private String company;

    @Column(nullable=false)
    private Double price;

    @Column(nullable=false)
    private Integer qty;

    @Column(name="expiry_date", nullable=false)
    private LocalDate expiryDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}

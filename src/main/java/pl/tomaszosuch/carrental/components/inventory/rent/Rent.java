package pl.tomaszosuch.carrental.components.inventory.rent;

import pl.tomaszosuch.carrental.components.assignment.Assignment;
import pl.tomaszosuch.carrental.components.inventory.category.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "rej_number", unique = true)
    private String rejNumber;
    @Column(name = "vin_number", unique = true)
    private String vinNumber;
    @Column(name = "serial_number", unique = true)
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "rent")
    private List<Assignment> assignments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getRejNumber() {
        return rejNumber;
    }

    public void setRejNumber(String rejNumber) {
        this.rejNumber = rejNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return Objects.equals(id, rent.id) &&
                Objects.equals(carBrand, rent.carBrand) &&
                Objects.equals(carModel, rent.carModel) &&
                Objects.equals(rejNumber, rent.rejNumber) &&
                Objects.equals(vinNumber, rent.vinNumber) &&
                Objects.equals(serialNumber, rent.serialNumber) &&
                Objects.equals(category, rent.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carBrand, carModel, rejNumber, vinNumber, serialNumber, category);
    }
}

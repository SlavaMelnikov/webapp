package by.melnikov.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int addressId;
    private String city;
    private String street;
    private String building;

    public Address(String city, String street, String building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }
}

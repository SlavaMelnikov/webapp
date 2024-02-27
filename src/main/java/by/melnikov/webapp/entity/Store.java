package by.melnikov.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private int storeId;
    private int addressId;

    public Store(int addressId) {
        this.addressId = addressId;
    }
}

package by.melnikov.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bookId;
    private String title;
    private Author author;
    private int price;

    public Book(String title, Author author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

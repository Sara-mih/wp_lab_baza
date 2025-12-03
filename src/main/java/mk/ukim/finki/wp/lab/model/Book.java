package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//@AllArgsConstructor
@Data
@Entity
@Table(name="knigi")
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String genre;
    private double averageRating;


    @ManyToOne

//  @JoinColumn(name = "author_id") // името на колоната во базата
    private Author author;
    public Book() {
    }

    public Book(String title, String genre, double averageRating,Author author) {
//        this.id=(long)(Math.random()*1000);
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}



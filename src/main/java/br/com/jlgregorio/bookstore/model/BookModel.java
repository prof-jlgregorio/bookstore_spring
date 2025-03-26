package br.com.jlgregorio.bookstore.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "summary", length = 100)
    private String summary;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private GenderModel gender;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorModel author;

}

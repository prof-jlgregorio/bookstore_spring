package br.com.jlgregorio.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {

    private long id;
    private String name;
    private String summary;
    private GenderDto gender;
    private AuthorDto author;
    private int year;

    public String toString(){
        return this.name + " - " + year + " - " +this.summary +
                " - " + this.gender + " By: " + this.author;
    }

}

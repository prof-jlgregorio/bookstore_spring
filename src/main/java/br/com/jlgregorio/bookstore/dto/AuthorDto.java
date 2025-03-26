package br.com.jlgregorio.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthorDto {

    private long id;
    private String name;
    private String country;

    public String toString(){
        return name + " - " + this.country;
    }

}

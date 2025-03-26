package br.com.jlgregorio.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenderDto {

    private long id;
    private String name;
    private String description;

    public String toString(){
        return this.name + " - " + this.description;
    }

}

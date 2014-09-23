/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tomate.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author teeyoshi
 */
@Entity
public class BookReference extends AbstractPersistable<Long>{
    
    @NotEmpty
    private String authors;
    
    @NotEmpty
    private String title;
    
    @NotEmpty
    private String publisher;
    
    @NotNull
//    @Digits(integer=4, fraction=0)
    private Integer year;

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    
    
    
}

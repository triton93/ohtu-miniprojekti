
package tomate.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Toni Oksanen
 */

@Entity
public class Reference extends AbstractPersistable<Long> {
  
  public static final int BOOK = 1;
  public static final int ARTICLE = 2;
  public static final int INPROCEEDINGS = 3;
  
  @NotNull
  private Integer type;
  
  @NotBlank
  private String authors;

  @NotBlank
  private String title;
  
  @NotNull
  private Integer year;
  
  private String publisher;
  private String booktitle;
  
  public int getType() {
    return this.type;
  }
  
  public void setType( int type ) {
    this.type = type;
  }
  
  public String getAuthors() {
    return authors;
  }

  public void setAuthors( String authors ) {
    this.authors = authors;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle( String title ) {
    this.title = title;
  }

  public String getPublisher() {
    return this.publisher;
  }

  public void setPublisher( String publisher ) {
    this.publisher = publisher;
  }

  public Integer getYear() {
    return this.year;
  }

  public void setYear( Integer year ) {
    this.year = year;
  }
  
  public String getBooktitle() {
    return this.booktitle;
  }
  
  public void setBooktitle( String booktitle ) {
    this.booktitle = booktitle;
  }
  
}

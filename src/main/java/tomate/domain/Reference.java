
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
  
  @NotBlank
  @NotNull
  private String authors;

  @NotBlank
  @NotNull
  private String title;

  @NotBlank
  @NotNull
  private String publisher;

  @NotNull
  private Integer year;

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

}

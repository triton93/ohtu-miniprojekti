

package tomate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tomate.component.BibTexFormatter;
import tomate.repository.ReferenceRepository;

/**
 *
 * @author Toni Oksanen
 */
@RestController
@RequestMapping( "/api/bibtex" )
public class BibTexController {
 
  @Autowired
  private BibTexFormatter formatter;
  
  @Autowired
  private ReferenceRepository referenceRepository;
  
  @RequestMapping( value = "/{id}", method = RequestMethod.GET )
  public String retrieve( @PathVariable Long id ) {
    return this.formatter.format( this.referenceRepository.findOne( id ) ); 
  }
  
}

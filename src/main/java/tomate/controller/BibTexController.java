

package tomate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tomate.component.BibTexFormatter;
import tomate.domain.Reference;
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
  
  @RequestMapping( value = "/{id}/download", method = RequestMethod.GET )
  public ResponseEntity<byte[]> downloadOne( @PathVariable Long id ) {
    
    byte[] bytes = this.formatter.format( this.referenceRepository.findOne( id ) ).getBytes();
    
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType( MediaType.parseMediaType( "text/plain;charset=utf-8" ) );
    headers.setContentLength( bytes.length );
    headers.add("Content-Disposition", "attachment; filename=ref" + id + ".bib");

    return new ResponseEntity<>( bytes, headers, HttpStatus.CREATED );
  
  }
  
  @RequestMapping( value = "/download", method = RequestMethod.GET )
  public ResponseEntity<byte[]> downloadAll() {
    
    StringBuilder file = new StringBuilder();
    
    for ( Reference ref : this.referenceRepository.findAll() ) {
      file.append( this.formatter.format( ref ) ).append( "\n\n" ); 
    }
    
    byte[] bytes = file.toString().getBytes();
    
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType( MediaType.parseMediaType( "text/plain;charset=utf-8" ) );
    headers.setContentLength( bytes.length );
    headers.add("Content-Disposition", "attachment; filename=all-refs.bib");

    return new ResponseEntity<>( bytes, headers, HttpStatus.CREATED );
  
  }
  
  
}

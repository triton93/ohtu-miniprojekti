

package tomate.component;

import org.springframework.stereotype.Component;
import tomate.domain.Reference;

/**
 *
 * @author Toni Oksanen
 */

@Component
public class BibTexFormatter {
  
  public String format( Reference ref ) {
    
    StringBuilder sb = new StringBuilder( "@Book{" );
    sb.append( formatRef( ref.getAuthors() ) ).append( "," );
    sb.append( keyValuePair( "author", formatUmlauts( ref.getAuthors() ), true, true ) );
    sb.append( keyValuePair( "title", formatUmlauts( ref.getTitle() ), true, true ) );
    sb.append( keyValuePair( "publisher", formatUmlauts( ref.getPublisher() ), true, true ) );
    sb.append( keyValuePair( "year", String.valueOf( ref.getYear() ), false, false ) );
    sb.append( "\n}" );
    
    return sb.toString();
  
  }
  
  private static String formatRef( String ref ) {
    
    String[] parts = ref.toLowerCase().replaceAll( ",", "" ).split( "[\\s]" );    
    
    if ( parts.length == 2 ) {
      return parts[ 1 ];
    }
    
    String newRef = "";
    
    for ( int i = 0; i < parts.length; i++ ) {
      if ( i % 2 == 1 ) {
        newRef += parts[ i ] + ( i < parts.length - 1 ? "+" : "" );
      }
    }
    
    return newRef;
  }
  
  private static String keyValuePair( String key, String value, boolean quotes, boolean comma ) {
    
    if ( quotes ) {
      value = "\"" + value + "\"";
    }
    
    return "\n\t" + key + "  =  " + value + ( comma ? "," : "" );
    
  }
  
  private static String formatUmlauts( String str ) {
    
    return str.replaceAll( "ä", "\\\\ddot{a}" )
              .replaceAll( "Ä", "\\\\ddot{A}" )
              .replaceAll( "ö", "\\\\ddot{o}" )
              .replaceAll( "Ö", "\\\\ddot{O}" );
    
  }
  
  
}

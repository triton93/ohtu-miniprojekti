/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomate.domain.BookReference;

/**
 *
 * @author teeyoshi
 */
public interface BookReferenceRepository extends JpaRepository<BookReference, Long>{
    
}

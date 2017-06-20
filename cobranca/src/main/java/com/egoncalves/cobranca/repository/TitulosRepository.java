/**
 * 
 */
package com.egoncalves.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egoncalves.cobranca.model.Titulo;

/**
 * @author Esmael
 *
 */
public interface TitulosRepository extends JpaRepository<Titulo, Long> {

}

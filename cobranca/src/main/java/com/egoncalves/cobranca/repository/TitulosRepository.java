/**
 * 
 */
package com.egoncalves.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egoncalves.cobranca.model.Titulo;

/**
 * @author Esmael
 *
 */
public interface TitulosRepository extends JpaRepository<Titulo, Long> {
	public List<Titulo> findByDescricaoContaining(String descricao);
}

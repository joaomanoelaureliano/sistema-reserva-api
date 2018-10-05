package com.joaomanoel.hotel.repository;

import com.joaomanoel.hotel.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmano
 */    
public interface HospedeRepository  extends JpaRepository<Hospede, Long>{
    Hospede findByNome(String nome);
    
    Hospede findById(long id);
    
    
}


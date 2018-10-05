package com.joaomanoel.hotel.repository;

import com.joaomanoel.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jmano
 */
public interface HotelRepository  extends JpaRepository<Hotel, Long>{
    Hotel findByNome(String nome);
    
    Hotel findById(long id);
}

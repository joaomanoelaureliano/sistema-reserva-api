package com.joaomanoel.hotel.repository;

import com.joaomanoel.hotel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jmano
 */
public interface ReservaRepository  extends JpaRepository<Reserva, Long>{
    Reserva findById(String idReserva);
    
      Reserva findById(long id);
    
}
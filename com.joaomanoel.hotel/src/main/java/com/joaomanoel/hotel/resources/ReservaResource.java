package com.joaomanoel.hotel.resources;

import com.joaomanoel.hotel.model.Reserva;
import com.joaomanoel.hotel.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jmano
 */
@RestController
@RequestMapping("/api")
public class ReservaResource {

    @Autowired
    private ReservaRepository reservaRepository;
    
    @GetMapping("/reserva")
    public List<Reserva> listaReserva(){
        return reservaRepository.findAll();
    }
    
    @GetMapping("/reserva/{id}")
    public Reserva listaReservaId(@PathVariable(value="id") long id){
        return reservaRepository.findById(id);
    }
       
    @PostMapping("/reserva")
    public Reserva SalvaReserva(@RequestBody Reserva reserva){
        return reservaRepository.save(reserva);
    }
    
    @DeleteMapping("/reserva/{id}")
    public void deleteReserva (@PathVariable Long id){
        reservaRepository.deleteById(id);
    }
    
    @PutMapping("/reserva/{id}")
    public Reserva atualizaReserva(@PathVariable Integer id,@RequestBody Reserva reserva){
        return reservaRepository.save(reserva);
    }
}

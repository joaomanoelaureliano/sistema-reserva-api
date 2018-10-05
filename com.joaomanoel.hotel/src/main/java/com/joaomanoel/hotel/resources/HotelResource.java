package com.joaomanoel.hotel.resources;

import com.joaomanoel.hotel.model.Hotel;
import com.joaomanoel.hotel.repository.HotelRepository;
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
public class HotelResource {

    @Autowired
    private HotelRepository hotelRepository;
    
    @GetMapping("/hotel")
    public List<Hotel> listaHotel(){
        return hotelRepository.findAll();
    }
    
    @GetMapping("/hotel/{id}")
    public Hotel listaHotelId(@PathVariable(value="id") long id){
        return hotelRepository.findById(id);
    }
       
    @PostMapping("/hotel")
    public Hotel SalvaHotel(@RequestBody Hotel hotel){
        return hotelRepository.save(hotel);
    }
    
    @DeleteMapping("/hotel/{id}")
    public void deleteHotel (@PathVariable Long id){
        hotelRepository.deleteById(id);
    }
    
    @PutMapping("/hotel/{id}")   
    public Hotel atualizaHotel(@PathVariable Integer id, @RequestBody Hotel hotel){
        return hotelRepository.save(hotel);
    }
}

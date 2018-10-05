package com.joaomanoel.hotel.resources;

import com.joaomanoel.hotel.model.Hospede;
import com.joaomanoel.hotel.repository.HospedeRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jmano
 */
@RestController
@RequestMapping("/api")
public class HospedeResource {

    @Autowired
    private HospedeRepository hospedeRepository;
    
    
    @GetMapping("/hospede")
    public List<Hospede> listaHospede(){
        return hospedeRepository.findAll();
    }
    
    @GetMapping("/hospede/{id}")
    public Hospede listaHospedeId(@PathVariable(value="id") long id){
        return hospedeRepository.findById(id);
    }
       
    @PostMapping("/hospede")
    public Hospede SalvaHospede(@RequestBody Hospede hospede){
        return hospedeRepository.save(hospede);
    }
    
    @DeleteMapping("/hospede/{id}")
    public void deleteHospede (@PathVariable Long id){
       hospedeRepository.deleteById(id);
    }
    
    @PutMapping("/hospede/{id}")
    public Hospede atualizaHospede(@PathVariable Integer id, @RequestBody Hospede hospede){
        return hospedeRepository.save(hospede);
    }
}


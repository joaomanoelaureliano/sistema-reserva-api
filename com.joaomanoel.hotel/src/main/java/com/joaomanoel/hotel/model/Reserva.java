package com.joaomanoel.hotel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joao.aureliano
 */

@Entity
@Table(name = "RESERVA")
@SequenceGenerator(name = "RESERVA_SEQ", sequenceName = "RESERVA_SEQ", allocationSize = 1)
@JsonSerialize
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva implements Entidade {
    
    @Id
    @Column(name = "ID_RESERVA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RESERVA_SEQ")
    private Long id;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOTEL")
    private Hotel hotel;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_HOSPEDE")
    private Hospede hospede;
    
    @NotNull
    @Column(name = "DT_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEntrada;
    
    @NotNull
    @Column(name = "DT_SAIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtSaida;

    public Reserva() {
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.hotel);
        hash = 97 * hash + Objects.hashCode(this.hospede);
        hash = 97 * hash + Objects.hashCode(this.dtEntrada);
        hash = 97 * hash + Objects.hashCode(this.dtSaida);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.hotel, other.hotel)) {
            return false;
        }
        if (!Objects.equals(this.hospede, other.hospede)) {
            return false;
        }
        if (!Objects.equals(this.dtEntrada, other.dtEntrada)) {
            return false;
        }
        if (!Objects.equals(this.dtSaida, other.dtSaida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", hotel=" + hotel + ", hospede=" + hospede + ", dtEntrada=" + dtEntrada + ", dtSaida=" + dtSaida + '}';
    }
} 

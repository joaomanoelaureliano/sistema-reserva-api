package com.joaomanoel.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author joao.aureliano
 */

@Entity
@Table(name = "HOTEL")
@SequenceGenerator(name = "HOTEL_SEQ", sequenceName = "HOTEL_SEQ", allocationSize = 1)
@JsonSerialize
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hotel implements Entidade{
    
    @Id
    @Column(name = "ID_HOTEL")
    @GeneratedValue(generator = "HOTEL_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @OneToMany(targetEntity = Reserva.class, mappedBy = "hotel")
    private List<Reserva> reserva;
    
    @Column(name = "NOME", length = 100)
    @NotNull(message = "{Hotel.nome.NotNull}")
    @Size(max = 100, message = "{Hotel.nome.Size}")
    private String nome;
    
    @Column(name = "ESTADO", length = 40)
    @NotNull(message = "{Hotel.estado.NotNull}")
    private String estado;
    
    @Column(name = "CIDADE", length = 40)
    @NotNull(message = "{Hotel.cidade.NotNull")
    @Size(max = 40, message = "{Hotel.cidade.Size}")
    private String cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Hotel() {
        
    }
    
    @JsonIgnore
    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.reserva);
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.estado);
        hash = 73 * hash + Objects.hashCode(this.cidade);
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
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.reserva, other.reserva)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", reserva=" + reserva + ", nome=" + nome + ", estado=" + estado + ", cidade=" + cidade + '}';
    }
}
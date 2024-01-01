package com.example.nasastealphoto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Getter
@Setter
@Table(name = "sols")
public class Sol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sol_id_gen")
    @SequenceGenerator(name = "sol_id_gen", sequenceName = "sols_seq", allocationSize = 1)
    private Long id;
    @NaturalId
    private String data;
}

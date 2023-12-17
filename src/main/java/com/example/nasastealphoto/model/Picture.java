package com.example.nasastealphoto.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "picture_id_gen")
    @SequenceGenerator(name = "picture_id_gen", sequenceName = "pictures_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long nasaId;

    @Column(nullable = false)
    private  String imgSrc;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Camera camera;
}

package com.example.nasastealphoto.model;

import static jakarta.persistence.CascadeType.PERSIST;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cameras")
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "camera_id_gen")
    @SequenceGenerator(name = "camera_id_gen", sequenceName = "cameras_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private Long nasaId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ToString.Exclude
    @JsonBackReference
    @Setter(value = AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "camera", cascade = PERSIST)
    List<Picture> pictures = new ArrayList<>();

    public void addPicture(Picture picture) {
        pictures.add(picture);
        picture.setCamera(this);
    }
}

package edu.eskisehir.teklifyap.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "material")
public class Material implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private int material_id;

    @OneToOne
    @JoinColumn(name = "user_id")
//    @JsonIgnore
    private User user;

    @Column(name = "material_name")
    private String material_name;

    @Column(name = "material_unit")
    private String material_unit;

    @Column(name = "material_is_verified")
    private short material_is_verified;


}

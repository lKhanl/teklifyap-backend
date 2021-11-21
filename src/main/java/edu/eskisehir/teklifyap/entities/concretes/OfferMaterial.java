package edu.eskisehir.teklifyap.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "offer_material")
public class OfferMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Column(name = "offer_material_price_per_unit")
    private int offer_material_price_per_unit;

    @Column(name = "offer_material_unit_quantity")
    private int offer_material_unit_quantity;
}

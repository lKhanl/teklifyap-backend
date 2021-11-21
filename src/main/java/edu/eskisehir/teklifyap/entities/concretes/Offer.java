package edu.eskisehir.teklifyap.entities.concretes;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "offer")
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private int offer_id;

    @Column(name = "offer_title")
    private String offer_title;

    @Column(name = "offer_company_name")
    private String offer_company_name;

    @Column(name = "offer_status")
    private String offer_status;

    @Column(name = "offer_total_price")
    private int offer_total_price;

    @Column(name = "offer_date")
    private Date offer_date;

    @Column(name = "offer_profit_rate")
    private int offer_profit_rate;

    @Column(name = "offer_username")
    private String offer_username;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Offer{" +
                "offer_id=" + offer_id +
                ", offer_title='" + offer_title + '\'' +
                ", offer_status='" + offer_status + '\'' +
                ", offer_total_price=" + offer_total_price +
                ", offer_date=" + offer_date +
                ", user=" + user +
                '}';
    }
}

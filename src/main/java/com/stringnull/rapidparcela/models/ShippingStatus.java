package com.stringnull.rapidparcela.models;

import com.stringnull.rapidparcela.models.embeddables.Location;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shipment_status")
public class ShippingStatus {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    private LocalDateTime createdAt;

    @Embedded
    private Location current;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name="destination_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name="destination_longitude"))
    })
    private Location destination;


}
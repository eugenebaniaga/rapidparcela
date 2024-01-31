package com.stringnull.rapidparcela.models.embeddables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Location {
    private Double longitude;
    private Double latitude;

}
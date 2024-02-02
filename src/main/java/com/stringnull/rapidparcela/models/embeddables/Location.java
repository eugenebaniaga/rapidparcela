package com.stringnull.rapidparcela.models.embeddables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Data
public class Location {
    private Double longitude;
    private Double latitude;

}
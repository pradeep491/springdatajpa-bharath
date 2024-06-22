package com.test.springdata.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    @Temporal(TemporalType.DATE)
    private LocalDate validFrom;
    @Temporal(TemporalType.DATE)
    private LocalDate validTo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

}

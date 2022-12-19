package com.tourist.malitourist.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Region {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String habitants;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "annee", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

    @JsonIgnore
    private Annee annees;

//fetch = FetchType.LAZY, veut dire
    @ManyToOne( optional = false)
    @JoinColumn(name = "nomregion", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Nomregion nomregions;

}

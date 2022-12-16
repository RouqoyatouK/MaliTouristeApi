package com.tourist.malitourist.Model;

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
public class Nomregion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnomregion;
    private String nom;
    private String superfie;
    private String coderegion;
    private String activite;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pays", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pays pays;
}
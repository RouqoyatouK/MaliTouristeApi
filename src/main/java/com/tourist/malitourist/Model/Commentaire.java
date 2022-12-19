package com.tourist.malitourist.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcmt;
    private Date datecmt;
    private String message;

    @ManyToOne( optional = false)
    @JoinColumn(name = "region", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Region regions;

}


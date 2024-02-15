package com.sbs.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "bets")
public class Bet {
    @Id
    @Column(name = "ID")
    private Long id;
    private String matchName;
    private String name;
    private Float course;
    private BetStatus betStatus;
}

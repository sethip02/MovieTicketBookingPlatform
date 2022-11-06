package com.bookmymovie.movie_shows.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="theatre")
@Data
public class Theatre {
    @Id
    private int id;
    private String name;
    private String address;
    private String city;
    @Column(name = "ticket_price")
    private double ticketPrice;
    @OneToMany(mappedBy = "theatre")
    private List<MovieShow> movieShows;
}
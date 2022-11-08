package com.bookmymovie.movie_shows.entities;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Partner {
    @Id
    private int id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String contact;
    @JsonProperty("registration_num")
    private String registrationNum;
    @OneToMany( mappedBy = "partner")
    private List<Theatre> theatres;
}

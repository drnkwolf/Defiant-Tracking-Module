package com.defiants.trackingmodule.model;

import javax.persistence.*;

@Entity
public class Package {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Carrier carrier;

    private String description;
}

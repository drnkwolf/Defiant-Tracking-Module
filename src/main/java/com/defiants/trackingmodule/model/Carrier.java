package com.defiants.trackingmodule.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Carrier {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "carrier")
    Set<Package> packages;
}

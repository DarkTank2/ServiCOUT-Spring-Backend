package com.aseiler.servicout.servicoutbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sizes")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public Integer getId () {
        return this.id;
    }
    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return this.name;
    }
    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return String.format("[id=%d;name=%s]", this.id, this.name);
    }
}

package com.concretepage.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "person")
/*@SecondaryTables(
        {
            @SecondaryTable(name = "shirt", pkJoinColumns = @PrimaryKeyJoinColumn(name = "owner", referencedColumnName = "id"))
            ,
            @SecondaryTable(name = "shirtb", pkJoinColumns = @PrimaryKeyJoinColumn(name = "owner", referencedColumnName = "id"))
        }
)*/
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner")
    private Set<Shirt> shirts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner")
    private Set<Shirtb> shirtsb;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Set<Shirt> getShirts() {
        return shirts;
    }

    public void setShirts(Set<Shirt> shirts) {
        this.shirts = shirts;
    }
   
    public Set<Shirtb> getShirtsb() {
        return shirtsb;
    }

    public void setShirtsb(Set<Shirtb> shirtsb) {
        this.shirtsb = shirtsb;
    }

}

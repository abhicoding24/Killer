package com.api.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Killer{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false,length=255)
    private String name;
    @Column(nullable=false,length=255,unique=true)
    private String email;
    @Column(nullable=false,length=10,unique=true)
    private String mobile;
    public void setId(long id){
        this.id=id;
    }
    public long getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setMobile(String mobile){
        this.mobile=mobile;
    }
    public String getMobile(){
        return mobile;
    }
}

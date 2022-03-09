package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "SURVIVOR")
public class Survivor {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(name = "age")
   private int age;

   @Column(name = "gender")
   private String gender;

   private boolean infected;

   @Embedded
   private Location location;

   @OneToMany(mappedBy = "survivor", cascade = CascadeType.ALL)
   private Set<Resource> res;

   public Survivor() {
   }

   public Survivor(long id, int age, String gender, boolean infected, Location location, Set<Resource> res) {
      this.id = id;
      this.age = age;
      this.gender = gender;
      this.infected = infected;
      this.location = location;
      this.res = res;
   }

   public long getId() {
      return this.id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public int getAge() {
      return this.age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getGender() {
      return this.gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public boolean isInfected() {
      return this.infected;
   }

   public boolean getInfected() {
      return this.infected;
   }

   public void setInfected(boolean infected) {
      this.infected = infected;
   }

   public Location getLocation() {
      return this.location;
   }

   public void setLocation(Location location) {
      this.location = location;
   }

   public Set<Resource> getRes() {
      return this.res;
   }

   public void setRes(Set<Resource> res) {
      this.res = res;
   }

   public Survivor id(long id) {
      setId(id);
      return this;
   }

   public Survivor age(int age) {
      setAge(age);
      return this;
   }

   public Survivor gender(String gender) {
      setGender(gender);
      return this;
   }

   public Survivor infected(boolean infected) {
      setInfected(infected);
      return this;
   }

   public Survivor location(Location location) {
      setLocation(location);
      return this;
   }

   public Survivor res(Set<Resource> res) {
      setRes(res);
      return this;
   }

   @Override
   public String toString() {
      return "{" + " id='" + getId() + "'" + ", age='" + getAge() + "'" + ", gender='" + getGender() + "'"
            + ", infected='" + isInfected() + "'" + ", location='" + getLocation() + "'" + ", res='" + getRes() + "'"
            + "}";
   }

}
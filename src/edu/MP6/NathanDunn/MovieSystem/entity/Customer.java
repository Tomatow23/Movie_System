package edu.MP6.NathanDunn.MovieSystem.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="cust")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="cust_name")
    String name;
    @Column(name="cust_age")
    int age;

    @OneToMany(mappedBy ="customer", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Checkout> checkoutList = new ArrayList<>();

    public void addCheckout(Checkout checkout){
        checkoutList.add(checkout);
        checkout.setCustomer(this);
    }
    public void deleteCheckout(Checkout checkout){
        checkoutList.remove(checkout);

    }
    public Checkout getCheckout(int index){
        return checkoutList.get(index);
    }
    public List<Checkout> getCheckouts(){
        return checkoutList;
    }
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Customer(){

    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", checkoutList=" + checkoutList +
                '}';
    }
}

package com.list.todolist.entity;



import javax.persistence.*;

@Entity
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String item;


    public List(){
    }

    public List(String item) {
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


}

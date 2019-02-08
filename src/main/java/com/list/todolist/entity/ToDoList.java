package com.list.todolist.entity;



import javax.persistence.*;

@Entity
@Table(schema = "to-do-list")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String item;

    public ToDoList(){
    }

    public ToDoList(String item) {
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

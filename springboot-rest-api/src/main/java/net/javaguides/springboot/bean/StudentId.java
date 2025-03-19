package net.javaguides.springboot.bean;

import org.springframework.stereotype.Component;

@Component
public class StudentId {

    private int id;

    public StudentId() {
    }

    public StudentId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

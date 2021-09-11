package com.tms.homework.task1.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Accountant extends Post implements IPost {

    public Accountant(String name, String surname, int age) {
        super(name, surname, age);
    }
}

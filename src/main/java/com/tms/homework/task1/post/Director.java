package com.tms.homework.task1.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Director extends Post implements IPost {

    public Director(String name, String surname, int age) {
        super(name, surname, age);
    }
}

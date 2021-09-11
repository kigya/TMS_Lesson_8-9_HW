package com.tms.homework.task1.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Worker extends Post implements IPost {
    public Worker(String name, String surname, int age) {
        super(name, surname, age);
    }

}

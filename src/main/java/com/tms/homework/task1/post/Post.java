package com.tms.homework.task1.post;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Post implements IPost{

    private String name;
    private String surname;
    private int age;

    public static void printPost(Post postName){
        if (postName instanceof Accountant) {
            System.out.println("Accountant");
        } else if (postName instanceof Director) {
            System.out.println("Director");
        } else {
            System.out.println("Worker");
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age;
    }
}

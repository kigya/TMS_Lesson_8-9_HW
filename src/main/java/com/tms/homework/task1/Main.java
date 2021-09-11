package com.tms.homework.task1;

import com.tms.homework.task1.post.Accountant;
import com.tms.homework.task1.post.Director;
import com.tms.homework.task1.post.Post;
import com.tms.homework.task1.post.Worker;

import java.util.Collections;
import java.util.List;

import static com.tms.homework.task1.post.Post.printPost;

public class Main {

    public static void main(String[] args) {
        List<Post> postList = new java.util.ArrayList<>(Collections.emptyList());
        postList.add(new Accountant("Jasmin", "Williams", 33));
        postList.add(new Director("Elyse", "Mason", 26));
        postList.add(new Worker("Habib", "Doherty", 28));
        postList.forEach(post -> {
            System.out.println(post);
            printPost(post);
        });
    }

}

package com.pangypeng;

import com.pangypeng.chapter01.stackandqueue.subject04.Cat;
import com.pangypeng.chapter01.stackandqueue.subject04.Dog;
import com.pangypeng.chapter01.stackandqueue.subject04.DogCatQueue;
import com.pangypeng.chapter01.stackandqueue.subject04.Pet;

public class Main {

    public static void main(String[] args) {
        DogCatQueue queue = new DogCatQueue();
        queue.add(new Dog());
        queue.add(new Cat());

        System.out.println(queue.isDogQEmpty());
        System.out.println(queue.isCatQEmpty());
        System.out.println(queue.isEmpty());

        Pet pet = queue.pollAll();
        System.out.println(pet.getPetType());
    }
}

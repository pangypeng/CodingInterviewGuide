package com.pangypeng.chapter01.stackandqueue.subject04;

/**
 * Created by pang on 2016/4/5 0005.
 */
public class PetEnterQueue {
    private Pet pet;
    private int count;
    public PetEnterQueue(Pet pet ,int count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }

    public String getEnterPetType(){
        return  pet.getPetType();
    }

}

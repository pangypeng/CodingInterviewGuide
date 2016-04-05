package com.pangypeng.chapter01.stackandqueue.subject04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pang on 2016/4/5 0005.
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    int count= 0;

    public DogCatQueue(){
        dogQ = new LinkedList<>();
        catQ = new LinkedList<>();
    }

    /**
     *
     * @param pet
     */
    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            dogQ.add(new PetEnterQueue(pet,count++));
        } else if (pet.getPetType().equals("cat")){
            catQ.add(new PetEnterQueue(pet,count++));
        } else {
            throw new RuntimeException("Pet类型错误");
        }
    }

    public Pet pollAll(){
        if (!isDogQEmpty() && !isCatQEmpty()){
            if (dogQ.peek().getCount() < catQ.peek().getCount()){
                return dogQ.poll().getPet();
            }else {
                return catQ.poll().getPet();
            }
        }else if (!isDogQEmpty()){
            return dogQ.poll().getPet();
        }else if (!isCatQEmpty()){
            return catQ.poll().getPet();
        }else {
            throw new RuntimeException("Queue为空");
        }
    }

    public Dog pollDog(){
        if(!isDogQEmpty()){
            return (Dog) dogQ.poll().getPet();
        }else {
            throw new RuntimeException("DigQ为空");
        }
    }

    public Cat pollCat(){
        if(!isCatQEmpty()){
            return (Cat) catQ.poll().getPet();
        }else{
            throw new RuntimeException("CatQ为空");
        }
    }

    public boolean isEmpty(){
        return isDogQEmpty()&&isCatQEmpty();
    }

    public boolean isDogQEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatQEmpty(){
        return catQ.isEmpty();
    }


}

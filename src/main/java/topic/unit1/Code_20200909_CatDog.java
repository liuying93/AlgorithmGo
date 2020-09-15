package main.java.topic.unit1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗问题
 *
 * @Author: liuy
 * @Date: 2020/9/9 17:33
 * @Description:
 */
public class Code_20200909_CatDog {
    private Queue<PetEnterQueue> catQueue;
    private Queue<PetEnterQueue> dogQueue;
    private Long count;

    public Code_20200909_CatDog() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
        this.count = 0L;
    }

    public void add(Pet pet) {
        if (!"Cat".equals(pet.getPetType()) && !"Dog".equals(pet.getPetType())) {
            throw new RuntimeException("Type is misMatch");
        }
        if ("Cat".equals(pet.getPetType())) {
            catQueue.add(new PetEnterQueue(new Cat(), count++));
        }
        if ("Dog".equals(pet.getPetType())) {
            dogQueue.add(new PetEnterQueue(new Dog(), count++));
        }
    }

    public Pet pollAll() {
        if (catQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        }
        if (dogQueue.isEmpty()) {
            return catQueue.poll().getPet();
        }
        if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
            if (catQueue.peek().count < dogQueue.peek().count) {
                return catQueue.poll().getPet();
            }
            if (catQueue.peek().count > dogQueue.peek().count) {
                return dogQueue.poll().getPet();
            }
        }
        throw new RuntimeException("Queue is empty");
    }

    public Pet pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("DogQueue is empty");
        }
        return dogQueue.poll().getPet();
    }

    public Pet pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("CatQueue is empty");
        }
        return catQueue.poll().getPet();
    }

    public Boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public Boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public Boolean isCatEmpty() {
        return catQueue.isEmpty();
    }


    public static void main(String[] args) {
        Code_20200909_CatDog cd = new Code_20200909_CatDog();
        cd.add(new Cat());
        cd.add(new Cat());
        cd.add(new Dog());
        cd.add(new Cat());
        cd.add(new Dog());
        cd.add(new Cat());
        cd.add(new Cat());
        while (!cd.isEmpty()) {
            System.out.println(cd.pollAll().getPetType());
            System.out.println(cd.pollCat().getPetType());
            System.out.println(cd.pollDog().getPetType());
        }
    }


}


class Pet {
    private String type;

    public String getPetType() {
        return this.type;
    }

    public Pet(String type) {
        this.type = type;
    }
}


class Cat extends Pet {

    public Cat() {
        super("Cat");
    }
}


class Dog extends Pet {
    public Dog() {
        super("Dog");
    }
}


class PetEnterQueue {
    public Pet pet;
    public Long count;

    public PetEnterQueue(Pet pet, Long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public Long getCount() {
        return this.count;
    }

    public String getPetType() {
        return this.pet.getPetType();
    }
}





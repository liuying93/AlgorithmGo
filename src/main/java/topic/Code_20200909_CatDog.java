package main.java.topic;

/**
 * 猫狗问题
 *
 * @Author: liuy
 * @Date: 2020/9/9 17:33
 * @Description:
 */
public class Code_20200909_CatDog {

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
    public Cat() {
        super("Dog");
    }
}

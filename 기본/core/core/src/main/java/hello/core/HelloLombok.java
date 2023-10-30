package hello.core;

import lombok.Data;

@Data
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("홍길동");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}

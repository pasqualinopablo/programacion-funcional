package org.example.pedrojoya;

import java.util.Random;

public class Main {
    private Random random = new Random();
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Integer total = Flujo.proveer(10, () -> random.nextInt(10))
                .filtrar(x -> x % 2 == 0)
                .transformar(x -> x * x)
                .actuar(x -> System.out.println(x))
                .reducir(0, (x, y) -> x + y);

        System.out.println("Reduccion :" + total);


         Flujo.proveer(10, () -> random.nextLong())
                .filtrar(x -> x % 2 == 0)
                .transformar(x -> x + x)
                .consumir(System.out::println);
    }
}
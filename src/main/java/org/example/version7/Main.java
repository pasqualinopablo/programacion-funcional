package org.example.version7;

import org.example.pedrojoya.Flujo;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    private Random random = new Random();
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Stream.generate( () -> random.nextInt(10))
                .limit(10)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .forEach(x -> System.out.println(x));

        Optional<Integer> total = Stream.generate( () -> random.nextInt(10))
                .limit(10)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .peek(System.out::println)
                .reduce((x, y) -> x + y);

        System.out.println("Reduce: ".concat(total.isPresent() ? total.get().toString(): "nada"));
        //otra version aprovechando el orElse
        System.out.println("Reduce: ".concat(total.map(Object::toString).orElse("nada")));


        Integer total2 = Flujo.proveer(10, () -> random.nextInt(10))
                .filtrar(x -> x % 2 == 0)
                .transformar(x -> x * x)
                .actuar(x -> System.out.println(x))
                .reducir(0, (x, y) -> x + y);

        System.out.println("Reduccion :" + total2);
    }
}
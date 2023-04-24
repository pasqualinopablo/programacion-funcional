package org.example.referenciaaMetodo;

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
        Stream.generate( this::randomInt)
                .limit(10)
                .filter(NumberUtils::esPar)
                .map(NumberUtils::elevarAlCuadrado)
                .forEach(System.out::println);

        Optional<Integer> total = Stream.generate( () -> random.nextInt(10))
                .limit(10)
                .filter(NumberUtils::esPar)
                .map(NumberUtils::elevarAlCuadrado)
                .peek(System.out::println)
                .reduce(Integer::sum);

        System.out.println("Reduce: ".concat(total.map(Object::toString).orElse("nada")));


        Integer total2 = Flujo.proveer(10, () -> random.nextInt(10))
                .filtrar(NumberUtils::esPar)
                .transformar(NumberUtils::elevarAlCuadrado)
                .actuar(System.out::println)
                .reducir(0, Integer::sum);

        System.out.println("Reduccion :" + total2);
    }

    private Integer randomInt (){
        return random.nextInt(10);
    }
}
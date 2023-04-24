package org.example.test1;

import org.example.test1.model.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        /**
         1. Consumers (recibe parametros pero no devuelve nada)
         */
        Consumer impresor = x -> System.out.println(x);

        List<String> lista = Arrays.asList("hola", "que" , "tal");
        lista.stream().forEach(x -> System.out.println(x));

        /**
         2. Function (recibe parametros y retorna algo)
         */
        lista.stream().map(x -> x.toUpperCase() ).forEach(x -> System.out.println(x));

        /**
         3. Suppliers (Proveedor)
         */
        //A
        List<Persona>  listaPersona = Stream.generate(Persona::new)
                .limit(4)
                .peek(persona -> persona.setNombre("Pablo Pasqualino"))
                .collect(Collectors.toList());
        listaPersona.stream().forEach(impresor);

        //B
        Random ran = new Random();
        List<Integer> listaEnteros = Stream.generate(()-> ran.nextInt(100))
                .limit(5)
                .collect(Collectors.toList());
        listaEnteros.stream().forEach(impresor);

        /**
         4. Predicate (como funcion pero devuelve true o false)
         */
        listaEnteros.stream().filter(r -> r>50).forEach(impresor);

        /**
         5. Operators (es como la funcion pero devuelve el mismo tipo de dato que le es pasado por parametro)
         */
        //A
        Optional<String> resultado =  lista.stream().reduce((x,y) -> x.concat(y));
        System.out.println(resultado.isPresent() ? resultado.get() : "no hay nada");
        //B
        Optional<String> resultado2 =  lista.stream().reduce(String::concat);
        System.out.println(resultado2.isPresent() ? resultado2.get() : "no hay nada");
        //C
        Optional<Integer> resultado3 =  listaEnteros.stream().reduce((x,y) -> x + y);
        System.out.println(resultado3.isPresent() ? resultado3.get() : "no hay nada");
    }
}
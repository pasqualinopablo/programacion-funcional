package org.example.test1;

import org.example.test1.model.Developer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlatMapTest {
    @Test
    public void flatMap() {
        List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer("experto");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        Developer busy = new Developer("estandard");
        busy.add("java");
        busy.add("javascript");

        Developer becario = new Developer("becario");

        team.add(polyglot);
        team.add(busy);
        team.add(becario);

        List<String> teamLanguages = team.stream().
                map(d -> d.getLanguages()).
                flatMap(l -> l.stream()).
                collect(Collectors.toList());

        assertTrue(teamLanguages.containsAll(polyglot.getLanguages()));
        assertTrue(teamLanguages.containsAll(busy.getLanguages()));

    }
}

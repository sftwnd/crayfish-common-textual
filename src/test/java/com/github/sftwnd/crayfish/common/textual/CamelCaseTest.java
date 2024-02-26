package com.github.sftwnd.crayfish.common.textual;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.github.sftwnd.crayfish.common.textual.CamelCase.camelCase;
import static com.github.sftwnd.crayfish.common.textual.CamelCase.lowerCamelCase;
import static com.github.sftwnd.crayfish.common.textual.CamelCase.upperCamelCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CamelCaseTest {

    private static final String SOURCE_STR = "CamelCaseTest";

    @Test
    void camelCaseTest() {
        Stream.of(Map.of("", "",
                                "A", "a",
                                "Ab", "ab",
                                "Abc", "abc",
                                "AB", "aB",
                                "ABx", "aBx ",
                                "ABC", "aBC",
                                "ABy", " ABy",
                                "AbC", "AbC"),
                        Map.of( "ABD", "ABD",
                                "AD", "a d",
                                "CD", "c D",
                                "ABe", "a Be",
                                "ABF", "a BF",
                                "ABCDeFGh", " a b c De fGh "
                        ))
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .forEach(entry -> assertEquals(
                        entry.getKey(),
                        camelCase(entry.getValue()),
                        "camelCase(" + entry.getValue() +") has to be equals " + entry.getKey()
                ));
    }

    @Test
    void lowerCamelCaseStringTest() {
        sourceStrings()
                .forEach(
                        str -> assertEquals(Character.toLowerCase(str.charAt(0))+str.substring(1), lowerCamelCase(str))
                );
    }

    @Test
    void lowerCamelCaseSupplierTest() {
        sourceStrings()
                .forEach(
                        str -> assertEquals(Character.toLowerCase(str.charAt(0))+str.substring(1), lowerCamelCase(() -> str))
                );
    }

    @Test
    void lowerCamelCaseNullSupplierTest() {
        assertNull(lowerCamelCase((Supplier<String>) null));
    }

    @Test
    void lowerCamelCaseSupplierNullTest() {
        assertNull(lowerCamelCase(() -> null));
    }

    @Test
    void upperCamelCaseStringTest() {
        sourceStrings()
                .forEach(
                        str -> assertEquals(Character.toUpperCase(str.charAt(0))+str.substring(1), upperCamelCase(str))
                );
    }

    @Test
    void upperCamelCaseSupplierTest() {
        sourceStrings()
                .forEach(
                        str -> assertEquals(Character.toUpperCase(str.charAt(0))+str.substring(1), upperCamelCase(() -> str))
                );
    }

    @Test
    void upperCamelCaseNullSupplierTest() {
        assertNull(upperCamelCase((Supplier<String>) null));
    }

    @Test
    void upperCamelCaseSupplierNullTest() {
        assertNull(upperCamelCase(() -> null));
    }

    private static Stream<String> sourceStrings() {
        return Stream.of(SOURCE_STR)
                .flatMap(str -> Stream.of(str, str.toLowerCase(), str.toUpperCase()))
                .flatMap(str -> Stream.of('x'+str, 'X'+str));
    }

}
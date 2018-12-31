package com.practice.Chapter_01.Refactoring_a_First_Example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    Customer customer;
    List<Movie> movieList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Movie zero = new Movie("Zero", Movie.NEW_RELEASE);
        Movie thugsOfHindusthan = new Movie("Thugs of Hisdusthan", Movie.NEW_RELEASE);
        Movie aquaMan = new Movie("Aqua-man", Movie.NEW_RELEASE);
        movieList.add(zero); // 0
        movieList.add(thugsOfHindusthan); // 1
        movieList.add(aquaMan); // 2

        Movie ghazni = new Movie("Ghazni", Movie.REGULAR);
        Movie manpura = new Movie("Manpura", Movie.REGULAR);
        Movie thirdPersonSingularNumber = new Movie("Third Person Singular Number", Movie.REGULAR);
        movieList.add(ghazni); // 3
        movieList.add(manpura); // 4
        movieList.add(thirdPersonSingularNumber); // 5

        Movie incredible2 = new Movie("Incredible 2", Movie.CHILDREN);
        Movie minuscule = new Movie("Minuscule", Movie.CHILDREN);
        movieList.add(incredible2); // 6
        movieList.add(minuscule); // 7
    }

    @Test
    void statement1() {
        customer = new Customer("Mr. Guddu");
        Rental mrGudduRental = new Rental(movieList.get(0), 5);
        customer.addRental(mrGudduRental);
        mrGudduRental = new Rental(movieList.get(4), 5);
        customer.addRental(mrGudduRental);
        mrGudduRental = new Rental(movieList.get(7), 5);
        customer.addRental(mrGudduRental);

        assertEquals("Rental Record for Mr. Guddu\n" +
                "\tZero\t15.0\n" +
                "\tManpura\t6.5\n" +
                "\tMinuscule\t4.5\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent rentar points", customer.statement());
    }

    @Test
    void statement2() {
        customer = new Customer("Piklu Sharma");
        Rental mrGudduRental = new Rental(movieList.get(6), 2);
        customer.addRental(mrGudduRental);
        mrGudduRental = new Rental(movieList.get(7), 2);
        customer.addRental(mrGudduRental);

        assertEquals("Rental Record for Piklu Sharma\n" +
                "\tIncredible 2\t1.5\n" +
                "\tMinuscule\t1.5\n" +
                "Amount owed is 3.0\n" +
                "You earned 2 frequent rentar points", customer.statement());
    }

    @Test
    void statement3() {
        customer = new Customer("Tita Mohon");
        for (int i = 0, sz = movieList.size(); i < sz; i++) {
            Rental mrGudduRental = new Rental(movieList.get(i), i + 1);
            customer.addRental(mrGudduRental);
        }

        assertEquals("Rental Record for Tita Mohon\n" +
                "\tZero\t3.0\n" +
                "\tThugs of Hisdusthan\t6.0\n" +
                "\tAqua-man\t9.0\n" +
                "\tGhazni\t5.0\n" +
                "\tManpura\t6.5\n" +
                "\tThird Person Singular Number\t8.0\n" +
                "\tIncredible 2\t7.5\n" +
                "\tMinuscule\t9.0\n" +
                "Amount owed is 54.0\n" +
                "You earned 10 frequent rentar points", customer.statement());
    }
}
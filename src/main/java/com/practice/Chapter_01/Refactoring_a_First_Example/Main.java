package com.practice.Chapter_01.Refactoring_a_First_Example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create Some Movies
        List<Movie> movieList = new ArrayList<>();
        Movie zero = new Movie("Zero", Movie.NEW_RELEASE);
        Movie thugsOfHindusthan = new Movie("Thugs of Hisdusthan", Movie.NEW_RELEASE);
        Movie aquaMan = new Movie("Aqua-man", Movie.NEW_RELEASE);
        movieList.add(zero);
        movieList.add(thugsOfHindusthan);
        movieList.add(aquaMan);

        Movie ghazni = new Movie("Ghazni", Movie.REGULAR);
        Movie manpura = new Movie("Manpura", Movie.REGULAR);
        Movie thirdPersonSingularNumber = new Movie("Third Person Singular Number", Movie.REGULAR);
        movieList.add(ghazni);
        movieList.add(manpura);
        movieList.add(thirdPersonSingularNumber);

        Movie incredible2 = new Movie("Incredible 2", Movie.CHILDREN);
        Movie minuscule = new Movie("Minuscule", Movie.CHILDREN);
        movieList.add(incredible2);
        movieList.add(minuscule);

//        String[] customers = new String[]{"Mr. Guddu", "Mrs. Renoyat", "Piklu Sharma", "Tita Mohon"};

        Customer mrGuddu = new Customer("Mr. Guddu");
        Rental mrGudduRental = new Rental(zero, 5);
        mrGuddu.addRental(mrGudduRental);
        mrGudduRental = new Rental(manpura, 5);
        mrGuddu.addRental(mrGudduRental);
        mrGudduRental = new Rental(minuscule, 5);
        mrGuddu.addRental(mrGudduRental);
        System.out.println(mrGuddu.statement());
    }
}

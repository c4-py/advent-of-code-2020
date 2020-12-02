package com.adventofcode.day02;

import com.adventofcode.ChallengeSolver;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2Solver extends ChallengeSolver {

    @Override
    public String getInputPath() {
        return "/home/franco/Documents/old-repos/AdventOfCode/src/com/adventofcode/day02/input.txt";
    }

    @Override
    public void solve(List<String> input) {
        final String regex = "([0-9]*)-([0-9]*)\\s([a-z]):\\s(.*)";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        int validCounter = 0;
        for (String line : input) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                int min = Integer.parseInt(matcher.group(1));
                int max = Integer.parseInt(matcher.group(2));
                char character = matcher.group(3).charAt(0);
                String password = matcher.group(4);
                if (isPartOneValid(character, min, max, password)) {
                    validCounter++;
                }
            }
        }
        System.out.println(validCounter);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        final String regex = "([0-9]*)-([0-9]*)\\s([a-z]):\\s(.*)";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        int validCounter = 0;
        for (String line : input) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                int positionA = Integer.parseInt(matcher.group(1));
                int positionB = Integer.parseInt(matcher.group(2));
                char character = matcher.group(3).charAt(0);
                String password = matcher.group(4);
                if (isPartTwoValid(character, positionA, positionB, password)) {
                    validCounter++;
                }
            }
        }
        System.out.println(validCounter);
    }

    private boolean isPartOneValid(char character, int min, int max, String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == character) {
                counter++;
            }
        }
        return counter <= max && counter >= min;
    }

    private boolean isPartTwoValid(char character, int positionA, int positionB, String password) {
        boolean positionAcheck = password.charAt(positionA - 1) == character;
        boolean positionBcheck = password.charAt(positionB - 1) == character;
        return positionAcheck ^ positionBcheck;
    }

    public static void main(String[] args) {
        new Day2Solver().run();
    }
}

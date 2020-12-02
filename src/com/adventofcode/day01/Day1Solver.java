package com.adventofcode.day01;

import com.adventofcode.ChallengeSolver;
import java.util.List;

public class Day1Solver extends ChallengeSolver {

    @Override
    public String getInputPath() {
        return "/home/franco/Documents/old-repos/AdventOfCode/src/com/adventofcode/day01/input.txt";
    }

    @Override
    public void solve(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            int a = Integer.parseInt(input.get(i));
            for (int j = 0; j < input.size(); j++) {
                int b = Integer.parseInt(input.get(j));
                if (a + b == 2020) {
                    System.out.println(a * b);
                    return;
                }
            }
        }
    }

    @Override
    public void solvePartTwo(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            int a = Integer.parseInt(input.get(i));
            for (int j = 0; j < input.size(); j++) {
                int b = Integer.parseInt(input.get(j));
                for (int z = 0; z < input.size(); z++) {
                    int c = Integer.parseInt(input.get(z));
                    if (a + b + c == 2020) {
                        System.out.println(a * b * c);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Day1Solver().run();
    }
}

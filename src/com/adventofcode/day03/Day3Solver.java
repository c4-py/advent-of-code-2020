package com.adventofcode.day03;

import com.adventofcode.ChallengeSolver;
import java.util.List;

public class Day3Solver extends ChallengeSolver {

    @Override
    public String getInputPath() {
        return "/home/franco/Documents/old-repos/AdventOfCode/src/com/adventofcode/day03/input.txt";
    }

    @Override
    public void solve(List<String> input) {
        System.out.println(countSlope(input, 3, 1));
    }

    private int countSlope(List<String> input, int right, int down) {
        int treeCounter = 0;
        for (int y = 0, x = 0; y < input.size(); y += down){
            if (input.get(y).charAt(x) == '#') treeCounter++;
            x = (x + right) % input.get(y).length();
        }
        return treeCounter;
    }

    @Override
    public void solvePartTwo(List<String> input) {
        int result = countSlope(input, 1, 1);
        result *= countSlope(input, 3, 1);
        result *= countSlope(input, 5, 1);
        result *= countSlope(input, 7, 1);
        result *= countSlope(input, 1, 2);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new Day3Solver().run();
    }
}

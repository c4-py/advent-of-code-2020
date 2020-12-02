package com.adventofcode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class ChallengeSolver {

    public abstract String getInputPath();
    public abstract void solve(List<String> input);
    public abstract void solvePartTwo(List<String> input);

    public void run() {
        try {
            System.out.println("Solving part 1: ");
            solve(Files.readAllLines(Path.of(getInputPath())));
            System.out.println("Solving part 2: ");
            solvePartTwo(Files.readAllLines(Path.of(getInputPath())));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

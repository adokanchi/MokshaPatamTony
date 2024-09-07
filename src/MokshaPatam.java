/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 * <p>
 * Completed by: Tony Dokanchi
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MokshaPatam {
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        Queue<Integer> toVisit = new LinkedList<Integer>();
        int[] map = new int[boardsize + 1];
        boolean[] visited = new boolean[boardsize + 1];
        int[] rollsToReach = new int[boardsize + 1];

        // Set up map
        for (int[] ladder : ladders) {
            map[ladder[0]] = ladder[1];
        }
        for (int[] snake : snakes) {
            map[snake[0]] = snake[1];
        }

        // We start on cell 1
        visited[1] = true;
        toVisit.add(1);

        while (!toVisit.isEmpty()) {
            int startCell = toVisit.remove();
            for (int roll = 1; roll <= 6; roll++) {
                // Move to nextCell
                int nextCell = startCell + roll;
                if (map[nextCell] != 0) {
                    nextCell = map[nextCell];
                }
                // If the goal is reached
                if (nextCell == boardsize) {
                    return 1 + rollsToReach[startCell];
                }
                // If nextCell hasn't been seen yet
                if (!visited[nextCell]) {
                    toVisit.add(nextCell);
                    visited[nextCell] = true;
                    rollsToReach[nextCell] = 1 + rollsToReach[startCell];
                }

            }
        }
        return -1;
    }

    public static int fewestMovesOld(int boardsize, int[][] ladders, int[][] snakes) {
        int numRolls = 0;
        // foundCells = all cells visited, ever
        // oldCells = the start points of the next time step
        // newCells = the end points of the next time step
        ArrayList<Integer> foundCells = new ArrayList<Integer>();
        ArrayList<Integer> oldCells = new ArrayList<Integer>();
        ArrayList<Integer> newCells = new ArrayList<Integer>();

        // We start on cell 1
        oldCells.add(1);
        foundCells.add(1);

        while (numRolls < boardsize + 10) { // Repeat until we're sure there is no solution
            numRolls++;
            for (int roll = 1; roll <= 6; roll++) {
                for (int oldCell : oldCells) {
                    // Move from oldCell to newCell
                    int newCell = oldCell + roll;
                    newCell = followPath(newCell, ladders, snakes);

                    // If the goal is reached
                    if (newCell == boardsize) {
                        return numRolls;
                    }

                    // If newCell hasn't been reached yet
                    if (!foundCells.contains(newCell)) {
                        newCells.add(newCell);
                        foundCells.add(newCell);
                    }
                }
            }
            // Next roll
            oldCells = newCells;
            newCells = new ArrayList<Integer>();
        }
        return -1;
    }

    // Takes in a startCell and the corresponding paths. Returns the cell that startCell leads to.
    public static int followPath(int startCell, int[][] ladders, int[][] snakes) {
        for (int[] ladder : ladders) {
            if (startCell == ladder[0]) {
                return ladder[1];
            }
        }
        for (int[] snake : snakes) {
            if (startCell == snake[0]) {
                return snake[1];
            }
        }
        return startCell;
    }
}
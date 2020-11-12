package de.lostuxos.puzzle.sum;


public class Solute {

    public static void main(String args[]) {
        SumPuzzel sumPuzzel = new SumPuzzel();
        var result = sumPuzzel.solvePuzzle("SEND".toCharArray(), "MORE".toCharArray(), "MONEY".toCharArray());
        System.out.println(result);
    }
}

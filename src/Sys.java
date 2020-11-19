import java.util.Scanner;

import java.util.Stack;

public class Sys {

    public static void main(String[] args) {

        final Stack st = new Stack();
        Core core = new Core(st);
        System.out.println(core.allCalls());
        System.out.println(core.call("O1"));
    }
}
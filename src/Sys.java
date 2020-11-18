import java.util.Scanner;

import java.util.Stack;

public class Sys {

    public static void main(String[] args) {

        Stack<String> st = new Stack<String>();
        Core core = new Core(st);
        boolean end = false;
        Scanner sc = new Scanner(System.in);

        while (!end) {
            switch (sc.next()) {
                case "call":
                    String id = sc.next();
                    String[] str = sc.next().split(",");
                    st.clear();
                    for (int i = 0; i < str.length; i++) {
                        st.push(str[i]);
                    }
                    System.out.println(core.call(id));
                    break;
                case "allcalls":
                    System.out.println(core.allCalls());
                    break;
                case "end":
                    end = true;
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
        sc.close();
    }
}
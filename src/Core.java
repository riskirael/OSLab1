import java.util.Stack;

public class Core {

    final Call[] calls;

    private Stack<String> stack;

    public Core(Stack<String> st) {
        stack = st;
        calls = new Call[5];
        calls[0] = new Call(1, "Call" + (1), "a,b", "O1");
        calls[1] = new Call(2, "Call" + (2), "a,b,c", "O2");
        calls[2] = new Call(3, "Call" + (3), "b", "O3");
        calls[3] = new Call(4, "Call" + (4), "a", "O4");
        calls[4] = new Call(5, "Call" + (5), "a,b,k", "O5");

    }

    public String allCalls() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < calls.length; i++) {
            sb.append(calls[i].GetId() + " ");
            sb.append(calls[i].GetName() + " ");
            for (int j = 0; j < calls[i].GetArguments().length; j++) {
                sb.append(calls[i].GetArguments()[j] + " ");
            }
            sb.append(calls[i].GetDescription() + '\n');
        }
        return sb.toString();

    }

    public String call(String _id) {

        StringBuilder sb = new StringBuilder();
        int id = -1;
        try {
            id = Integer.parseInt(_id);
        } catch (Exception e) {
            return "ERROR";
        }
        boolean flag = false;

        for (int i = 0; i < calls.length; i++) {
            if (id == calls[i].GetId()) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return "ERROR";
        }
        id--;
        if (id > -1 && id < calls.length) {
            for (int i = calls[id].GetArguments().length - 1; i >= 0; i--) {
                if (!calls[id].GetArguments()[i].equals(stack.pop())) {
                    return "ERROR";
                }
            }

            if (!stack.isEmpty()) {
                return "ERROR";
            }

            sb.append(calls[id].GetId() + " ");
            sb.append(calls[id].GetName() + " ");

            for (int j = 0; j < calls[id].GetArguments().length; j++) {
                sb.append(calls[id].GetArguments()[j] + " ");
            }
            sb.append(calls[id].GetDescription());

        } else {
            sb.append("ERROR");
        }
        return sb.toString();
    }
}
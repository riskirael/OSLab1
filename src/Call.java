public class Call {

    final int id;
    final String name;
    final String[] arguments;
    final String desc;

    public Call(int i, String n, String a, String o) {

        id = i;
        name = n;
        arguments = a.split(",");
        desc = o;

    }

    public int GetId() {
        return id;
    }

    public String GetName() {
        return name;
    }

    public String[] GetArguments() {
        return arguments;
    }

    public String GetDescription() {
        return desc;
    }
}
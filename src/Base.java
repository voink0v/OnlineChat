import java.util.ArrayList;

public class Base {
    ArrayList<String> names = new ArrayList<String>();


    private String name;

    public Base(String name) {

        this.name = name;

    }

    @Override
    public String toString() {
        return "Base{" +
                "name='" + name + '\'' +
                '}';
    }



}


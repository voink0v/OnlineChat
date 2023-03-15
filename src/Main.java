import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {

        Chat chat = new Chat();
        Thread thread = new Thread(chat);
        thread.start();
    }
}
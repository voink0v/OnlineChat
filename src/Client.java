import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class Client implements Runnable {

   // Validator validator = new Validator();
    Server server;

    PrintStream out;
    Socket socket;

    public Client(Socket socket, Server server) {
        this.server = server;
        this.socket = socket;
        new Thread(this).start();
    }

    public void run() {

        try {
            // получаем потоки ввода и вывода
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // создаем удобные средства ввода и вывода
            Scanner in = new Scanner(is);
            out = new PrintStream(os);

            // читаем из сети и пишем в сеть
            out.println("What you name?");
            String name = in.next();
           // validator.daNet(socket.getPort(), name);
            server.listNameBase.put(socket.getPort(),name);

            out.print("Welcome to mountains! " + name + "\n For exit enter \" bye \" \n");
            out.print("For To view a list of clients enter \" list \" ");
            server.messageEx(name + " was connected");

            String input = in.next();
            while (!input.equals("bye")) {
                if (input.equals("list")) {
                    // for (HashMap hashMap : validator.ListNameBase){
                    out.println(server.listNameBase);
                    // }

                }

                server.messageEx(input);
                input = in.nextLine();

            }
            server.listNameBase.remove(socket.getPort(),name);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ExMessage(String message) {
        out.println(message);

    }
}

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

public class Chat extends Thread {
    Base base;


    @Override
    public void run() {
        ServerSocket server = null;
        OutputStream os = null;
        InputStream is = null;
        Socket s = null;

        try {
            server = new ServerSocket(1234); // создаем серверный сокет на порту 1234
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String tmpName = null;

        while (true) {


            try {
                System.out.println("Waiting...");
                s = server.accept();  // ждем клиента
                os = s.getOutputStream(); // получаем потоки  ВЫВОДА
                is = s.getInputStream(); // получаем потоки ВВОДА
                System.out.println("Client connected!");

                Scanner in = new Scanner(is);
                PrintStream out = new PrintStream(os);


                // читаем из сети и пишем в сеть
                out.println("What's your name?");
                tmpName = in.nextLine();   //tmpName
                out.println("Hello, " + tmpName);
                base = new Base(tmpName);
                out.println("TEST TEXT2");
                out.println("TEST TEXT3");
                System.out.println(base);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }
}

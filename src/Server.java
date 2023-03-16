import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server extends Thread{
    List<Client> baseClient = new ArrayList<>();
    HashMap<Integer, String> listNameBase = new HashMap<>();

    @Override
    public void run(){


    try {
        //Validator validator = new Validator();

        ServerSocket server = new ServerSocket(1234);

        while (true) {
            System.out.println("Ожидаем подключение клиента к серверу");
            Socket socket = server.accept();

            System.out.println("Подключен клиент");
            baseClient.add(new Client(socket,this));
            // System.out.println(server + ";" + socket);
            //System.out.println(validator.baseClient);
            //for (Client client : baseClient){
                //System.out.println(client);

            //}

        }

    } catch (Exception e) {
        System.out.println(e);
    }


}
    public void messageEx(String name) {
        for (Client client : baseClient) {
            client.ExMessage(name);
            //System.out.println(client);

        }


    }

}

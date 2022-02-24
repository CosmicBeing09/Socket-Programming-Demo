package BiDirectionalMessageShareDemo.Client;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to Server");
            new Thread(new ReadHandler(socket)).start();
            new Thread(new WriteHandler(socket)).start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

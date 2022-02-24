package BiDirectionalMessageShareDemo.Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server Started");
            while (true){
                Socket client = serverSocket.accept();
                System.out.println("Client Added");
                new Thread(new ReadHandler(client)).start();
                new Thread(new WriteHandler(client)).start();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if(serverSocket != null)
                    serverSocket.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

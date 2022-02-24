package BiDirectionalMessageShareDemo.Server;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteHandler implements Runnable {
    private Socket client;
    public WriteHandler(Socket client){
        this.client = client;
    }
    public void run() {
        DataOutputStream dataOutputStream = null;
        Scanner scanner = null;

        try {
//            System.out.print("input > ");
            dataOutputStream = new DataOutputStream(client.getOutputStream());
            scanner = new Scanner(System.in);
            String message;
            while (true){
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if(dataOutputStream != null)
                    dataOutputStream.close();
                if(client != null)
                    client.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

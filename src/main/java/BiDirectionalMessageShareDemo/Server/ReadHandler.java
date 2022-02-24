package BiDirectionalMessageShareDemo.Server;

import java.io.DataInputStream;
import java.net.Socket;

public class ReadHandler implements Runnable {
    private Socket client;
    public ReadHandler(Socket client){
        this.client = client;
    }
    public void run() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(client.getInputStream());
            String message;
            while (true){
                message = dataInputStream.readUTF();
                System.out.println(message);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
               if(dataInputStream != null)
                   dataInputStream.close();
               if(client != null)
                   client.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

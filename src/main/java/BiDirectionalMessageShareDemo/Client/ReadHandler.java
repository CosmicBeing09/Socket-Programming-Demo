package BiDirectionalMessageShareDemo.Client;

import java.io.DataInputStream;
import java.net.Socket;

public class ReadHandler implements Runnable {

    private Socket socket;
    public ReadHandler(Socket socket){
        this.socket = socket;
    }
    public void run() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                String message = dataInputStream.readUTF();
                System.out.println("Server > " + message);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if(dataInputStream != null)
                    dataInputStream.close();
                if(socket != null)
                    socket.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


    }
}

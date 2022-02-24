package BiDirectionalMessageShareDemo.Client;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteHandler implements Runnable {
    private Socket socket;
    public WriteHandler(Socket socket){
        this.socket = socket;
    }
    public void run() {
        DataOutputStream dataOutputStream = null;
        Scanner scanner = null;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);

            while (true){
//                System.out.print("input > ");
                String message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if(dataOutputStream != null)
                    dataOutputStream.close();
                if(socket != null)
                    socket.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

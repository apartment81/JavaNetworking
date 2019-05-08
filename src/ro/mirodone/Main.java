package ro.mirodone;


import java.io.IOException;
import java.net.ServerSocket;


public class Main {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(5000)){

           /* Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);*/

            //this infinite loop will wait for a response from the Client though method .readLine()
            //moving all the above* code inside the loop, we can achieve multiple connections

            while (true){
                //all the code was moved to Echoer.java class

                //we start a new thread for every connection created

                new Echoer(serverSocket.accept()).start();
//                Socket socket = serverSocket.accept();
  //              Echoer echoer = new Echoer(socket);
    //            echoer.start();

            }
        }catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }

    }
}

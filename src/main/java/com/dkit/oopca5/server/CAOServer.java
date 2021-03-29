package com.dkit.oopca5.server;

/* The server package should contain all code to run the server.
 The server uses TCP sockets and thread per client.
 The server should connect to a MySql database to register clients,
  allow them to login and choose courses
 The server should listen for connections and once a connection is accepted
 it should spawn a new CAOClientHandler thread to deal with that connection.
 The server then returns to listening
 */

import com.dkit.oopca5.server.DAOs.MySqlStudentDao;
import com.dkit.oopca5.server.DAOs.StudentDaoInterface;
import com.dkit.oopca5.server.DTOs.Student;
import com.dkit.oopca5.server.Exceptions.DaoException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

import static com.dkit.oopca5.core.CAOService.*;

public class CAOServer
{
    public static void main(String[] args)
    {
        CAOServer server = new CAOServer();
        server.start();
    }

    public void start()
    {
        try
        {
            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection,
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber)); // create a new ClientHandler for the client,
                t.start();                                                  // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e)
        {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;
        MySqlStudentDao studentDao;



        public ClientHandler(Socket clientSocket, int clientNumber)
        {
            try
            {
                //CREATE DAO HERE and above
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);

                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

                this.clientNumber = clientNumber;  // ID number that we are assigning to this client

                this.socket = clientSocket;  // store socket ref for closing

                this.studentDao = studentDao;

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            String message;
            try
            {
                while ((message = socketReader.readLine()) != null)  //message.split(BREAKING_CHARACTER)
                {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);

                    String [] arr =  message.split(BREAKING_CHARACTER);

                    //REGISTER LOGIC
                    //dao calls in here bc here is where the server reacts to client
                    if(arr[0].equals(REGISTER_COMMAND))
                    {

                       //create student obj
                        Student s = new Student(arr[1], arr[2], arr[3]);
                        boolean success = studentDao.registerStudent(s);
                        if(success = true){
                            socketWriter.println(SUCCESSFUL_REGISTER);
                        }
                        else if(success=false){
                            socketWriter.println(FAILED_REGISTER);
                        }

                    }

                    //LOGIN
                    if(arr[0].equals(LOGIN_COMMAND)){
                        boolean login;
                        Student s = studentDao.findStudent(arr[1]);


                    }



                    else
                    {
                        socketWriter.println("I'm sorry I don't understand :(");
                    }
                }

                socket.close();

            } catch (IOException | DaoException ex)
            {
                ex.printStackTrace();
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

}


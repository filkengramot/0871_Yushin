package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Socket> clients = new ArrayList<>();
    static ArrayList<String> userNames = new ArrayList<>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8182);
            System.out.println("Сервер завелся");
            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String userName = null;
                        try {
                            out.writeUTF("Как Вас величать?!");
                            userName = in.readUTF();
                            userNames.add(userName);
                            broadcastMsg("Юзверь " + userName + " берет табуреточку и садится в уютной комнате чата.", "Сервер");
                            System.out.println(userName + " подключился к чату.");
                            while (true) {
                                String str = in.readUTF();
                                broadcastMsg(str, userName);
                                System.out.println(userName + " сообщает: " + str);
                            }
                        } catch (IOException e) {
                            System.out.println("Юзверь" + userName + " ушел, но еще вернется!");
                        } finally {
                            try {
                                clients.remove(socket);
                                userNames.remove(userName);
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void broadcastMsg(String str, String userName) throws IOException {
        DataOutputStream out;
        for (Socket socket : clients) {
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(userName + ": " + str);
        }
    }
}

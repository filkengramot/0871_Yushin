import java.io.*;
import java.net.*;


public class ProxyCheckerN2 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C://java/test.txt");
        int c;
        String ipList = "";
        while ((c = reader.read()) != -1) {
            ipList += (char) c;
        }
        String[] ipListArray = ipList.split("\r\n");

        for (int i = 0; i < ipListArray.length; i++) {

            String[] splitString = ipListArray[i].split(":");
            String ip = splitString[0].trim();
            int port = Integer.parseInt(splitString[1]);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));

                    try {
                        URLConnection connection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);

                        InputStream is = connection.getInputStream();
                        InputStreamReader reader = new InputStreamReader(is);
                        char[] buffer = new char[256];
                        int rc;

                        StringBuilder sb = new StringBuilder();

                        while ((rc = reader.read(buffer)) != -1)
                            sb.append(buffer, 0, rc);

                        reader.close();
                        System.out.println(Thread.currentThread().getName() + "- ip: " + ip + ":" + port + " - ДОСТУПЕН");
                    } catch (Exception e) {
                        System.out.println(Thread.currentThread().getName() + "- ip: " + ip + ":" + port + " - недоступен");
                    }
                }
            });
            thread.start();


        }
    }
}

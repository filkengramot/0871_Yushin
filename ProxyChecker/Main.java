//без многопотока//
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C://java/test.txt");//читаем файл с диска
        int c;              //переменная символа который будем читать
        String ipList = "";//строковый список ip, сначала тут ничего не лежит
        while ((c = reader.read()) != -1) { // reader.read не равно -1 - метод read возвращ только один символ, читаем смволы в файле и в нем сравиваем коды символов с -1 если он не равен -1, то пишем символ в консоль, пока в конце файла цикл не найдет -1
            ipList += (char) c;             //сохранить в ipList то что прочитали из файла по одному символу
        }
        String[] ipListArray = ipList.split("\r");//чтение массива с разделением по символу возврата каретки \r
        for (int i = 0; i < ipListArray.length; i++) {//все адреса в массиве перебираем с пом цикла для каждого элемента начиная с нуля и меньше длины массива, i++
            String[] splitString = ipListArray[i].split(":");//массив дробим инфу в нем на два куска по символу ":" через .split
            String ip = splitString[0].trim(); //обращаемся к нулевому элементу массива вытаскивая ip-адрес, .trim удаляет пробелы
            int port = Integer.parseInt(splitString[1]);//достаем port, запихиваем строку в число,т.к. разделенная инфа это строка
            checkProxy(ip, port);                          //вызов метода checkProxy с выводом ip и port, проверка доступен(или нет) сайт
        }
    }

    //делаем метод для проверки прокси с параметрами string ip и int port
    static void checkProxy(String ip, int port) throws Exception { //тут пробрасываем (trows) Exeption тому кто вызывает этот метод чтоб не писать и здесь try/catch
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

            System.out.println("ip:" +ip+ ":"+port+" - ДОСТУПЕН");
        }catch (Exception e){
            System.out.println("ip:" +ip+ ":"+port+" - недоступен");
        }
    }
}

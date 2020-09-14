Перед решением прочтите https://www.codeflow.site/ru/article/java-buffered-reader
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> listCity = new ArrayList<>();
        List<String> listFamily = new ArrayList<>();

        while (true) {
            System.out.println("Укажите город: ");
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }

            System.out.println("Укажите фамилию: ");
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }

            listCity.add(city);
            listFamily.add(family);
        }

        while(true) {
            System.out.println("Укажите город для поиска фамилии: ");
            String findСity = reader.readLine();
            if (findСity.isEmpty()){
                break;
            }
            System.out.println(listFamily.get(listCity.indexOf(findСity)));

        }
    }
}

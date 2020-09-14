/*
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Укажите путь к файлу с данными: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
        ArrayList<Long> list = new ArrayList<>();
        while(scanner.hasNext()) {
            long number = scanner.nextLong();
            if ((number % 2) == 0) {
                list.add(number);
            }
        }
        Collections.sort(list);
        for (long number : list) {
            System.out.println(number);
        }
    }
}

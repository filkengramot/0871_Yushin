/*
Написать функцию, которая вычисляет минимум из четырёх чисел.
Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
Подсказка:
Нужно написать тело двух существующих функций min.
Требования:
•	Программа должна выводить текст на экран.
•	Методы min не должны выводить текст на экран.
•	Метод main должен вызывать метод min(a, b) и метод min(a, b, c, d).
•	Метод main должен выводить на экран результат работы методов min. Каждый раз с новой строки.
•	Метод min(a, b) должен возвращать минимальное значение из чисел a, b.
•	Метод min(a, b, c, d) должен использовать метод min(a, b)
•	Метод min(a, b, c, d) должен возвращать минимальное значение из чисел a, b, c, d.
*/

public class Main {
    public static int min(int a, int b, int c, int d) {
        if (a < b && a < c && a < d) return a;
        else if (b < a && b < c && b < d) return b;
        else if (c < a && c < b && c < d) return c;
        else if (d < a && d < b && d < c) return d;
        else return a;

    }

    public static int min(int a, int b) {
        if (a < b) return a;
        else if (b < a ) return b;
        else return a;

    }

    public static void main(String[] args) {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}



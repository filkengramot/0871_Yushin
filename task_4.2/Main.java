/*
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.
Требования:
•	Создай класс Dog.
•	Создай класс Cat.
•	В классе Dog должно быть три переменные.
•	В классе Cat должно быть три переменные.
•	Должен быть создан хотя бы один объект типа Mouse.
•	Должен быть создан хотя бы один объект типа Dog.
•	Должен быть создан хотя бы один объект типа Cat.
*/

public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 10, 5, 7, "orange", "male");
        Cat tomCat = new Cat("Tom", 55, 45, 21, 25, "navy", "male");
        Dog spikeDog = new Dog("Spike", 35, 100, 10, "grey", "male");
    }

    static class Mouse {
        String name;
        int height;
        int weight;
        int mustaches;
        int tail;
        String color;
        String sex;

        public Mouse(String name, int height, int weight, int mustaches, int tail, String color, String sex) {
            this.name = name;
            this.height = height;
            this.weight = weight;
            this.mustaches = mustaches;
            this.tail = tail;
            this.color = color;
            this.sex = sex;
        }
    }

    static class Cat {
        String name;
        int height;
        int weight;
        int mustaches;
        int tail;
        String color;
        String sex;

        public Cat(String name, int height, int weight, int mustaches, int tail, String color, String sex) {
            this.name = name;
            this.height = height;
            this.weight = weight;
            this.mustaches = mustaches;
            this.tail = tail;
            this.color = color;
            this.sex = sex;
        }
    }

    static class Dog {
        String name;
        int height;
        int weight;
        int tail;
        String color;
        String sex;

        public Dog(String name, int height, int weight, int tail, String color, String sex) {
            this.name = name;
            this.height = height;
            this.weight = weight;
            this.tail = tail;
            this.color = color;
            this.sex = sex;

        }
    }
}

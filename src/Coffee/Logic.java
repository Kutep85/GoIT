package Coffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Evgeny.Kutepov on 21.04.2017.
 */

/*
        Задачка для разминки следующая: создать алгоритм для кофе-машины с подсвечивающимися кнопками.
        Надеюсь, видели такие автоматы, когда в него закидываешь некую сумму, то загорается ряд кнопок с доступными напитками.
        Так вот, суть задачи вывести некий список допустимых напитков в зависимости от суммы вкинутых денег + сдача.
        Условия: эспрессо - 6грн, американо - 7 грн, капучино и кофе с молоком по 8 грн и латте 9 грн.
        Пример - я внес 8 грн. В консоли хочу при этом увидеть список напитков до 8 грн включительно + сумма сдачи напротив каждого.
        Подсказка: лучше создать класс Напиток() с нужными полями и далее использовать его для всех напитков.
*/


public class Logic {

    public static void main(String[] args) throws IOException {

        Boisson[] coffee = new Boisson[5];
        coffee[0] = new Boisson("Latte", 9);
        coffee[1] = new Boisson("Coffe with milk", 8);
        coffee[2] = new Boisson("Capuccino", 8);
        coffee[3] = new Boisson("Americano", 7);
        coffee[4] = new Boisson("Espresso", 6);

        System.out.println("Введите сумму");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(reader.readLine());
        list(coffee, money);
    }

    private static void list(Boisson[]coffee, int money) {

        for (int i = 0; i < 5; i++) {
            if (coffee[i].getPrice() <= money) {
                System.out.println(coffee[i].getName() + "   -   цена:  " + coffee[i].getPrice() + " грн");
                System.out.println("сдача:  " + (money - coffee[i].getPrice()) + " грн");
                System.out.println();
            }
        }

    }
}

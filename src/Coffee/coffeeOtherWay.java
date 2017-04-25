package Coffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Evgeny.Kutepov on 22.04.2017.
 */
public class coffeeOtherWay {

    public static void main(String[] args) throws IOException {

        List<Boisson> coffee = new ArrayList<Boisson>();
        coffee.add(new Boisson("Latte", 9));
        coffee.add(new Boisson("Coffe with milk", 8));
        coffee.add(new Boisson("Capuccino", 8));
        coffee.add(new Boisson("Americano", 7));
        coffee.add(new Boisson("Espresso", 6));

        System.out.println("Введите сумму");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(reader.readLine());
        list(coffee, money);
    }

    private static void list(List<Boisson> coffee, int money) {

        Logger log = Logger.getLogger(coffeeOtherWay.class.getName());

        for (int i = 0; i < 5; i++) {
            if (coffee.get(i).getPrice() <= money) {
                log.info(coffee.get(i).getName() + "   -   цена:  " + coffee.get(i).getPrice() + " грн\n" + "сдача:  " + (money - coffee.get(i).getPrice()) + " грн \n");
            }
        }

    }
}

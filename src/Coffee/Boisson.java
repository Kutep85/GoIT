package Coffee;

/**
 * Created by Evgeny.Kutepov on 21.04.2017.
 */
public class Boisson {

    private String name;
    private int price;

    public Boisson(String name, int price) {
        this.name = name;
        this.price =  price;
    }


    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}

/**
 * Created by Evgeny.Kutepov on 19.04.2017.
 */
public class Method_Amazoon {
    public static void main(String[] args) {
        System.out.println(changePage(10, "fst=p90x%3A1&rh=i%3Aaps%2Ck%3Aumbrella&page=3&keywords=umbrella&ie=UTF8&qid=1492586698&spIA=B06Y3265XF,B00UR0EFEK,B01J4UCSFG,B01NAYOAXE"));
    }

    public static String changePage(int page, String URL) {
        String[] arr = URL.split("&");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith("page="))
                arr[i] = "page=" + page;
        }

        URL = "";
        for (int i = 0; i < arr.length; i++) {
            URL = URL + arr[i];
            if (i < arr.length - 1)
                URL = URL + "&";
        }
        return URL;
    }
}

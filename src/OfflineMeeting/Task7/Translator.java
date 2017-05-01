package OfflineMeeting.Task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Evgeny.Kutepov on 01.05.2017.
 */
public class Translator {

    public static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/*
        System.out.println("===========   DO YOU NEED TO WRITE MESSAGE?    ==========");
        System.out.println("1. YES");
        System.out.println("2. NO");
*/
//       /String command = reader.readLine();
  //      switch (command) {
    //        case "1":
                definer(reader.readLine());
      //          break;
        //    case "2":*/
//                System.out.println("Program was stopped");
/*
                break;
            default:
                System.out.println("Wrong parameter. Try again");
*/
  //              run();
   //             break;
  //      }
    }

    private static void definer (String msg) throws IOException {
        String[] arr = msg.split(" ");
        for (int i = 0; i < arr.length; i++) {
            char[] msg1 = arr[i].toCharArray();
            int countLat = 0, countKir = 0;
            for (int j = 0; j < msg1.length; j++) {

                if (msg1[j] == 'Ё' | msg1[j] == 'ё' | (msg1[j] >= 'А' & msg1[j] <= 'я'))
                    countKir++;
                else if ((msg1[j] >= 'A' & msg1[j] <= 'Z') | (msg1[j] >= 'a' & msg1[j] <= 'z'))
                    countLat++;
            }

            if (countKir > 0)
                arr[i] = Litres.translateKirLat(arr[i]);
            else if (countLat > 0)
                arr[i] = Litres.translateLatKir(arr[i]);

            if (i < arr.length - 1)
                System.out.print(arr[i] + " ");
            else
                System.out.println(arr[i]);
            }
        System.out.println();
            run();
        }
    }

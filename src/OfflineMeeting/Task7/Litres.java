package OfflineMeeting.Task7;

import java.util.Arrays;

/**
 * Created by Evgeny.Kutepov on 30.04.2017.
 */
public class Litres {

    private static char[] kir = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'з', 'ж', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т',
            'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я'};
    private static String[] lat = {"a", "b", "v", "g", "d", "e", "yo", "z", "zh", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t",
            "u", "f", "x", "c", "ch", "sh", "shh", "`", "y`", "``", "e`", "yu", "ya"};

    public static String translateKirLat(String msg) {
        char[] msgToChar = msg.toCharArray();
        String newMsg = "";
        for (int i = 0; i < msgToChar.length; i++) {
            int count = 0;
            for (int j = 0; j < kir.length; j++) {
                if (msgToChar[i] == kir[j]) {
                    newMsg += lat[j];
                    count++;
                }
            }
            if (count == 0)
                newMsg += msgToChar[i];

        }
        return newMsg;
    }

    public static String translateLatKir(String msg) {
        char[] msgToChar = msg.toCharArray();
        String newMsg = "";
        for (int i = 0; i < msgToChar.length; i++) {
            String control = "" + msgToChar[i];
            int count = 0;
            for (int j = 0; j < lat.length; j++) {
                if (lat[j].startsWith(control)) {
                    if (msgToChar[i] == 'y') {
                        i++;
                            if (msgToChar[i] == 'o') {
                                newMsg += 'ё';
                                count++;
                            }
                            if (msgToChar[i] == '`') {
                                newMsg += 'ы';
                                count++;
                            }
                            if (msgToChar[i] == 'u') {
                                newMsg += 'ю';
                                count++;
                            }
                            if (msgToChar[i] == 'a') {
                                newMsg += 'я';
                                count++;
                            }
                        }

                    if (msgToChar[i] == 'c') {
                        if (i < msgToChar.length - 1) {
                            if (msgToChar[i + 1] == 'h') {
                                newMsg += 'ч';
                                i++;
                                count++;
                            }
                        }
                    }


                    if (msgToChar[i] == 's') {
                        if (i < msgToChar.length - 2) {
                            if (msgToChar[i + 2] == 'h') {
                                newMsg += 'щ';
                                i += 2;
                                count++;
                            }
                        }
                    if (i < msgToChar.length - 1) {
                        if (msgToChar[i + 1] == 'h') {
                            newMsg += 'ш';
                            i++;
                            count++;
                            }
                        }
                    }

                        if (msgToChar[i] == '`') {
                            if (i < msgToChar.length - 1) {
                                if (msgToChar[i + 1] == '`') {
                                    newMsg += 'ъ';
                                    i++;
                                    count++;
                                }
                            }
                        }

                        if (msgToChar[i] == 'e') {
                            if (i < msgToChar.length - 1) {
                                if (msgToChar[i + 1] == '`') {
                                    newMsg += 'э';
                                    i++;
                                    count++;
                                }
                            }
                        }

                        if (msgToChar[i] == 'z') {
                            if (i < msgToChar.length - 1) {
                                if (msgToChar[i + 1] == 'h') {
                                    newMsg += 'ж';
                                    i++;
                                    count++;
                                }
                            }
                        }

                        if (count == 0) {
                            newMsg += kir[j];
                            count++;
                        }
                }
            }
                    if (count == 0)
                        newMsg += msgToChar[i];
            }
        return newMsg;
        }
    }

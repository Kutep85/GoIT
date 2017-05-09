package CrossesAndZeros;

/**
Необходимо создать консольное приложение, которое эмулирует игру "Крестики-Нолики".
        Игроки: Человек и Компьютер.
        Человек ходит первым.
        С помощью консоли указывает номер ячейки, которую хочет занять.
        Далее, компьютер, с помощью генератора псевдослучайных чисел выбирает свободную ячейку и деалет ход.
        Цикл повторяется до победы. Условия победы согласно правилам игры.
        Технологии: Java SE.
        Требования: Необходимо создать 3 отдельных класса -
        Field, GameLogic и GameRunner
        Field описывает поле и предоставляет доступ к ячейкам игрового поля
        GameLogic - описывает ходы игроков, вносит изменения в Field и определяет победителя
        GameRunner - клиентский класс, котоый в методе main содержит:
        GameLogic gameLogic = new GameLogic(); gameLogic.start();
        Рекомендации: Для поля рекомендуется использовать массив String.
*/

/**
 * Created by Evgeny.Kutepov on 07.05.2017.
 */
    public class Field {

    private String[] playProcess = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    String[] getPlayProcess (){

        return playProcess;
    }

    void fieldFill () {
        for (int i = 0; i < 9;){
        System.out.println(" " + playProcess[i] + " | " + playProcess[++i] + " | " + playProcess[++i]);
        if (i < 6)
            System.out.println("---+---+---");
        ++i;
        }
    }
}

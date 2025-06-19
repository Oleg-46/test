package ok.dice;

import java.util.Scanner;

public class Dice_test {
    public static void main(String[] args) {
        //int i = 0, m = 0;

        int i = (int) (Math.random() * 100) + 1;

        int m = throwDice(i);
        System.out.println(" Было " + m + " попыток.");
    }

    private static int throwDice(int d_num) {

        //System.out.println(d_num);
        Scanner s = new Scanner(System.in);
        int d_number = 0, a = 0;
        System.out.println(" Введите число...");
        do {
            a = s.nextInt();
            if (a < d_num )
                System.out.println("Я сам в шоке, но, загаданное число больше, брат...");
            else if (a > d_num)
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат...");
            d_number++;

        } while (d_num != a);

        System.out.println(" Да это было число " + d_num);
        return d_number;
    }
}
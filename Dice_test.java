package ok.dice;

import java.util.Scanner;

public class Dice_test {
    public static void main(String[] args) {
        //int i = 0, m = 0;

        int i = (int) (Math.random() * 101);
        if (i == 0)

            i = 1;


        int m = throwDice(i);
        System.out.println(" Было "+m+ " попыток.");
    }

    private static int throwDice(int d_num) {

        System.out.println(d_num);
        Scanner s = new Scanner(System.in);
        int d_number = 1;
        System.out.println(" Введите число...");
        while (d_num != s.nextInt()) {
            System.out.println("Вы не попали сэр...");
            d_number++;
        }

        System.out.println(" Да это было число "+d_num);
        return d_number;
    }
}
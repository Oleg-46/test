package ok.dice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dice_test2 {
    public static Scanner s;
    public static File f;
    public static int i = (int) (Math.random() * 100) + 1;

    public static void main(String[] args) throws IOException {
        //int i = 0, m = 0;

        int i = (int) (Math.random() * 100) + 1;

        File f = new File("results.txt");

        System.out.println(" Введите число... Или RESULT для вывода результатов");
        s = new Scanner(System.in);
        String str = s.nextLine().trim();
        if (str.matches("(\\d{1,3})|(RESULT|result|Result)"))
            if (str.charAt(0) == 'R' || str.charAt(0) == 'r')
                System.out.println(from_file());
            else {

                int n = Integer.parseInt(str);
                throwDice(n);

            }
        else return;


        // throwDice(i);
        // System.out.println(throwDice(i));
    }

    public static String data_file(String text) throws IOException {



        FileOutputStream fos = new FileOutputStream(f, true);

        fos.write(text.getBytes());

        return;
    }

    public static String from_file() throws IOException {
        if (!f.exists()) {

            f.createNewFile();
            return "Результатов пока нет!";
        }
        Scanner sc = new Scanner(f);
        String str2 = sc.nextLine();
        String[] num_str = str2.split(" ");
        int[] numbers = new int[20];
        int sch = 0;
        for (String num : num_str)
            numbers[sch++] = Integer.parseInt(num);
        sc.close();

         return Arrays.toString(numbers);

    }


    public static String throwDice(int d_num) throws IOException {


        int popyt_num = 0;

        while (d_num != i)

         {

            if (d_num < i)
                System.out.println("Я сам в шоке, но, загаданное число больше, брат...");
            else if (d_num > i)
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат...");
            popyt_num++;

        }
        popyt_num == 0 ? popyt_num++ : popyt_num;

        System.out.println("  Да это было число " + d_num + "\nБыло " + popyt_num + "попыток.");

        data_file("" + popyt_num + " ");
        return " Было " + popyt_num + "попыток.";
    }
}




package ok.dice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dice_test2 {
    public static Scanner s;
    public static File f;

    public static void main(String[] args) throws IOException {
        //int i = 0, m = 0;

        int i = (int) (Math.random() * 100) + 1;

        File f = new File("results.txt");
        s = new Scanner(System.in);
        String str = s.nextLine().trim();
        if (str.matches("(\\d{1,3})|(RESULT|result|Result)"))
            if (str.charAt(0) == 'R' || str.charAt(0) == 'r')
                if (!f.exists()) {

                    f.createNewFile();
                    System.out.println(" Результатов пока нет!");
                } else
                    from_file();
            else {

                int n = Integer.parseInt(str);
                throwDice(n);

            }
        else return;


        // throwDice(i);
        // System.out.println(throwDice(i));
    }

    public static void data_file(String text) throws IOException {

        FileOutputStream fos = new FileOutputStream(f, true);

        fos.write(text.getBytes());

        return;
    }

    public static void from_file() throws IOException {
        Scanner sc = new Scanner(f);
        String str2 = sc.nextLine();
        String[] num_str = str2.split(" ");
        int[] numbers = new int[3];
        int sch = 0;
        for (String num : num_str) {
            numbers[sch++] = Integer.parseInt(num);

            System.out.println(Arrays.toString(numbers));
            sc.close();

        }
    }


    public static String throwDice(int d_num) throws IOException {


        int popyt_num = 0, a = 0;
        System.out.println(" Введите число...");
        do {
            a = s.nextInt();
            if (a < d_num)
                System.out.println("Я сам в шоке, но, загаданное число больше, брат...");
            else if (a > d_num)
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат...");
            popyt_num++;

        } while (d_num != a);

        System.out.println("  Да это было число " + d_num + "\nБыло " + popyt_num + "попыток.");

        data_file("" + popyt_num + " ");
        return " Было " + popyt_num + "попыток.";
    }
}




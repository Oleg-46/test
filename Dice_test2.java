package ok.dice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dice_test2 {
    public static Scanner s;
    public static File f = new File("results.txt");
    public static int i = (int) (Math.random() * 100) + 1;

    public static void main(String[] args) throws IOException {
        //int i = 0, m = 0;



        //File f = new File("results.txt");
        if (!f.exists())

            f.createNewFile();



        System.out.println(" Введите число от 1 до 100... Или RESULT для вывода результатов");
        s = new Scanner(System.in);
        String str = s.nextLine().trim();
        if (str.matches("(\\d{1,3})|(RESULT|result|Result)"))
            if (str.charAt(0) == 'R' || str.charAt(0) == 'r')
                System.out.println(from_file());
            else {

                int n = Integer.parseInt(str);
                System.out.println(throwDice(n));

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

    public static String from_file() throws IOException {

        Scanner sc = new Scanner(f);
        String str2;
        if (sc.hasNextLine())
              str2 = sc.nextLine();
        else return " Пока нет рузультатов брат...";

        String[] num_str = str2.split(" ");
        int[] numbers = new int[2000];
        int sch = 0;
        for (String num : num_str)
            numbers[sch++] = Integer.parseInt(num);
        sc.close();

        int[] numbers2 = Arrays.copyOfRange(numbers,0,sch);

        Arrays.sort(numbers2);
        return " Лучший результат "+ numbers2[0]+ " попыток, всего было "+sch+ " игр.";

         // return Arrays.toString(numbers);

    }


    public static String throwDice(int d_num) throws IOException {


        int popyt_num = 1;

        while (d_num != i)

         {

            if (d_num < i)
                System.out.println("Я сам в шоке, но, загаданное число больше, брат...");
            else if (d_num > i)
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат...");
            popyt_num++;
            String str = s.nextLine().trim();

            boolean b = str.matches("\\d{1,3}");
             if (!b)
                return " Ошибка ввода брат..." ;

             d_num = Integer.parseInt(str);


        }


        data_file("" + popyt_num + " ");
        return "  Да это было число " + d_num + "\nБыло " + popyt_num + " попыток.";
    }
}




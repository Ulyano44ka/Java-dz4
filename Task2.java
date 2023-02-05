/*1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки.
Фамилии, имена, очества, возраст и пол в отдельных списках.
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Task2 {

    public static void main(String[] args) {

        String str = "";
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();


        try {
            /* FileWriter writer = new FileWriter("bd.sql"); // создание файла
            writer.append("Антонов Дмитрий Иванович 46 М\n");
            writer.append("Баринов Сергей Михайлович 30 М\n");
            writer.flush();*/


            FileReader reader = new FileReader("bd.sql");
            while (reader.ready()) {
                str += (char) reader.read();
            }
            System.out.println("Исходный список данных:");
            System.out.println(str);

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        String[] strArr = str.split("\n");
        for (int i = 0; i < strArr.length; i++) {
            String[] temp = strArr[i].split(" ");

            surname.add(temp[0]);
            name.add(temp[1]);
            patronymic.add(temp[2]);
            age.add(Integer.parseInt(temp[3]));
            gender.add(temp[4].equals("М") ? false : true);

        }
        System.out.println(surname);
        System.out.println(name);
        System.out.println(patronymic);
        System.out.println(age);
        System.out.println(gender);

    }
}
/*Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
Загруженный и разбитый по строкам текст загрузить в подготовленные списки.
Фамилии, имена, очества, возраст и пол в отдельных списках.
Отсортировать по возрасту используя дополнительный список индексов.*/

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Task {
    public static void main(String[] args) {

        String str = "";
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> id = new LinkedList<>();

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
            id.add(i);
        }
        System.out.println(surname);

        System.out.println("Отсортированный по возрасту с использованием дополнительного списка индексов данных:");
        sortWithIndex(age, id);
        formList(surname, name, patronymic, age, gender, id);

    }

    private static void formList(ArrayList<String> lst1, ArrayList<String> lst2, ArrayList<String> lst3,
                                       ArrayList<Integer> lst4, ArrayList<Boolean> lst5, LinkedList<Integer> index) {

        for (Integer i : index) {
            String gender = (lst5.get(i).equals(true) ? "Ж" : "М");
            System.out.printf("%s %s.%s. %s %s\n", lst1.get(i), lst2.get(i).charAt(0), lst3.get(i).charAt(0), lst4.get(i), gender);
        }
    }

    private static void sortWithIndex(ArrayList<Integer> listBySort, LinkedList<Integer> index) {
            ArrayList<Integer> lst = new ArrayList<>(listBySort);

          for (int i = 0; i < lst.size(); i++) {
                for (int j = 0; j < lst.size() - 1; j++) {
                    if (lst.get(j) > lst.get(j + 1)) {
                        int tmp = index.get(j);
                        index.set(j, index.get(j + 1));
                        index.set(j + 1, tmp);

                        tmp = lst.get(j);
                        lst.set(j, lst.get(j + 1));
                        lst.set(j + 1, tmp);
                    }
                }
          }
    }
}
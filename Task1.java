/*1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {

        String str = "";

        try {
//            FileWriter writer = new FileWriter("bd.sql");
//            writer.append("Антонов Дмитрий Иванович 46 М\n");
//            writer.append("Баринов Сергей Михайлович 30 М\n");
//            writer.flush();

            FileReader reader = new FileReader("bd.sql");
            while (reader.ready()) {
                str += (char)reader.read();
            }
            System.out.println(str);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] strArr = str.split("\n");
        System.out.println("Данные из файла в формате Фамилия И.О. возраст пол: ");
        for (int i = 0; i < strArr.length; i++) {
            String[] temp = strArr[i].split(" ");
            System.out.printf("%s %s.%s. %s %s\n", temp[0], temp[1].charAt(0), temp[2].charAt(0), temp[3], temp[4]);
        }

    }
}
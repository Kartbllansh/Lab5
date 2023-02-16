import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int b = 0; //инициирование переменной благодаря, которой работает цикл
        FileInputStream fis = null; //Не знаю, почему так. Однако без них поток не закрывается
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream("C:\\Users\\Home\\IdeaProjects\\inform.txt");
            isr = new InputStreamReader(fis, "UTF-8");
            while ((b = isr.read()) != -1) {  //простой цикл, который выводит символы
                System.out.print((char) b);
            }

        } catch (IOException e) { //объединение двух ошибок( не найден файл и прерыв прочтения данных)
            System.out.println("ох, ох я не нашел файл, или вы прервали прочтения файла");
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
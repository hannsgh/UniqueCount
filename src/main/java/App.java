import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App {

    public static void main(String[] args) {


        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/properties.properties");
            property.load(fis);

           // String paths = property.getProperty("paths");

            long before = System.currentTimeMillis();
            System.out.println(property.getProperty("paths"));
           // long unique = count(paths);
            long after = System.currentTimeMillis();

          //  System.out.println("Существует " + unique + " уникальных строк ");
            System.out.println(" Время работы приложения : " + (after - before) / 1_000 + " sec");


        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;

public class App {

    public static void main(String[] args) {


        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/properties.properties");
            property.load(fis);

           String paths = property.getProperty("paths");

            long before = System.currentTimeMillis();
            System.out.println(property.getProperty("paths"));
           long unique = count(paths);
            long after = System.currentTimeMillis();

            System.out.println("Существует " + unique + " уникальных строк ");
            System.out.println(" Время работы приложения : " + (after - before) / 1_000 + " sec");


        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }


        }

    static long count(String paths) throws IOException {
        long unique = Files.lines(Paths.get(paths), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split("\n")))
                .distinct()
                .count();
        return unique;
    }
    }

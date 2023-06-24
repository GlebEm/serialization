package task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
В методе main() происходит считывание пути к файлу с консоли и заполнение runtimeStorage данными из файла.
Тебе необходимо в методе save() реализовать логику записи в файл для карты runtimeStorage,
а в методе load() - логику чтения из файла для runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле игнорируй.
Про .properties прочитай в вики.
Подсказка: используй объект класса Properties.


Requirements:
1. Метод save() должен сохранять карту runtimeStorage в параметр outputStream.
2. Метод load() должен восстанавливать состояние карты runtimeStorage из параметра inputStream.*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();
        try {
            properties.putAll(runtimeStorage);
            properties.store(outputStream, null);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            for (String x : properties.stringPropertyNames())
                runtimeStorage.put(x, properties.getProperty(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {   //   C:/Users/Admin/Desktop/task2003/Test.txt
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);
        System.out.println(runtimeStorage.size());
    }
}

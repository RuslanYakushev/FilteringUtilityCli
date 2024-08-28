/*
 * Общая информация :
 * Название : FiltrationCli
 * Интерфейс : CLI
 * Язык программирования : Java
 * Платформа : openjdk version "21.0.2" 2024-01-16 LTS.
 * ОС : РЕД ОС 8.0
 * Среда разработки : vscode
 * Разработал : Якушев Р.А. / mail: ruslanykushev@yandex.ru
 */

/*
 * Инструкция по использованию :
 * Программа запускается пользователем в терминале, для этого в терминале необходимо перейти в директорию с утилитой и выполнить запуск,
 * указав файлы для обработки.
 * Входящие файлы указать по названию через пробел.
 * Пример запуска : java FiltrationCli strings.txt integers.txt
 * Исходящие файлы будут сохранены в директории с утилитой, если нужен другой путь для сохранения, то указать опцию -o при запуске и полный путь.
 * ВАЖНО - указывается полный путь, который завершается косой чертой '/' .
 * Пример запуска с опцией -o : java FiltrationCli strings.txt integers.txt doubles.txt -o /home/user/
 * Названия исходящих файлов будет по их типу, дополнительно можно установить префикс к названию с помощью опции -p .
 * Пример запуска с опцией -p : java FiltrationCli strings.txt integers.txt doubles.txt -p test_
 * Показать статистистику кратко при запуске -s :  java FiltrationCli -s strings.txt
 * Показать полную статистистику при запуске -f :  java FiltrationCli -f strings.txt
 * При использовании опций их можно комбинировать и указывать в различном регистре.
 * После указания опции необходимо указать следующим элементом значение для этой опции, если опция не принимает значение,
 * то её можно указать в любом месте после имени утилиты.
 * При работе утилиты выводится успешные шаги : запуск, чтение, запись.
 * При выборе показа информации -s и -f, первым будет всегда короткая информация.
 * Пример компиляции : javac FilteringUtilityCli.java -Xlint
 * Пример запуска со всеми параметрами : java FilteringUtilityCli integers.txt floats.txt strings.txt -o /home/ruslan/Projects/shift_test/FilteringUtilityCli/src/result/ -p tak_ -a -f -s
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilteringUtilityCli {
    public static void main(String[] args){
        System.out.println("Program run");
        // проверка наличия аргументов при запуске программы
        if (args.length < 1) {
            System.out.println("Error. You not have input files and arguments");
            System.exit(1);
        }

        // первичная инициализация переменных
        List<String> inputFiles = new ArrayList<>();

        // полный путь для размещения файлов
        String resultPath = "";

        // префикс для имени
        String prefixName = "";

        // параметр добавления в файл (по умолчанию перезапись)
        boolean addToFile = false;

        // параметр вывода короткой статистики (по умолчанию не выводится)
        boolean shortStaticstic = false;

        // параметр вывода полной статистики (по умолчанию не выводится)
        boolean fullStatistic = false;

        //  дифференцированние полученных значений
        for (int i = 0; i < args.length; i++){
            if (args[i].toLowerCase().equals("-o")) {
                i++;
                resultPath = args[i];
            } else if (args[i].toLowerCase().equals("-p")) {
                i++;
                prefixName = args[i];
            }else if (args[i].toLowerCase().equals("-a")) {
                addToFile = true;
            }else if (args[i].toLowerCase().equals("-s")) {
                shortStaticstic = true;
            }else if (args[i].toLowerCase().equals("-f")) {
                fullStatistic = true;
            }else{
                inputFiles.add(args[i]);
            }
        }

        //  проверяем наличие файлов
        if (inputFiles.size() < 1) {
            System.out.println("Error. You not have input files");
            System.exit(1);
        }

        // создания объектов для каждого типа
        InputInteger inputInteger = new InputInteger();
        InputFloat inputFloat = new InputFloat();
        InputString inputString = new InputString();

        // чтение входящих файлов
        System.out.println("\n*****************************");
        readData(inputFiles, inputInteger, inputFloat, inputString);

        System.out.println("\n*****************************");
        // запись фильтрованных по типу данных
        writeData(inputFiles.size(),addToFile,resultPath,prefixName, inputInteger, inputFloat, inputString);
        System.out.println("*****************************\n");

        // вывод короткой статистики
        if(shortStaticstic){
            System.out.println("Short info :");
            if(inputInteger.getCount() > 0)
                System.out.printf("writed in integer.txt : %d \n", inputInteger.getCount());
            if(inputFloat.getCount() > 0)
                System.out.printf("writed in float.txt : %d \n", inputFloat.getCount());
            if(inputString.getCount() > 0)
                System.out.printf("writed in string.txt : %d \n", inputString.getCount());
            System.out.println("\n");
        }

        // вывод полной статистики
        if(fullStatistic){
            if(inputInteger.getCount() > 0){
                System.out.printf("Full info integer.txt:\nwrited in float.txt: %d\n"+
                                "minimal value: %d\n" +
                                "maximal value: %d\n" +
                                "sum: %d\n" +
                                "average value: %d\n\n", inputInteger.getCount(), inputInteger.getMinValue(), inputInteger.getMaxValue(),
                                inputInteger.getSum(),inputInteger.getAverageValue());

            }
            if(inputFloat.getCount() > 0){
                System.out.printf("Full info float.txt:\nwrited in float.txt: %d\n"+
                        "minimal value: %f\n" +
                        "maximal value: %f\n" +
                        "sum: %f\n" +
                        "average value: %f\n\n", inputFloat.getCount(), inputFloat.getMinValue(), inputFloat.getMaxValue(),
                        inputFloat.getSum(), inputFloat.getAverageValue());
            }
            if(inputString.getCount() > 0){
                System.out.printf("Full info string.txt:\nwrited in string.txt: %d\n" +
                        "minimal size: %d\n"+
                        "maximal size: %d\n\n", inputString.getCount(),inputString.getMinSizeString(),inputString.getMaxSizeString());
            }
        }
    }

    // метод для записи данных в файл
    public static void writeData(int size, boolean addToFile, String resultPath, String prefixName,
                                 InputInteger inputInteger, InputFloat inputFloat, InputString inputString){
        try {
            BufferedWriter writer;
            // проверяем каждый список на наличие элементов
            if(inputInteger.getCount() > 0){
                File fileInteger = new File(resultPath + prefixName + inputInteger.getNameOutputFile());
                System.out.println("File integer.txt recorded");
                writer = new BufferedWriter(new FileWriter(fileInteger, addToFile));

                for (int i = 0; i < inputInteger.getCount(); i++) {
                    writer.write(inputInteger.getListData().get(i) + "\n");
                }
                writer.close();
            }
            if(inputFloat.getCount() > 0) {
                File fileDouble = new File(resultPath + prefixName + inputFloat.getNameOutputFile());
                System.out.println("File float.txt recorded");

                writer = new BufferedWriter(new FileWriter(fileDouble,addToFile));
                for (int i = 0; i < inputFloat.getCount(); i++) {
                    writer.write(inputFloat.getListData().get(i) + "\n");
                }
                writer.close();
            }
            if(inputString.getCount() > 0) {
                File fileString = new File(resultPath + prefixName + inputString.getNameOutputFile());
                System.out.println("File string.txt recorded");
                writer = new BufferedWriter(new FileWriter(fileString,addToFile));

                for (int i = 0; i < inputString.getCount(); i++) {
                    writer.write(inputString.getListData().get(i) + "\n");
                }
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error recorded file!");
            e.printStackTrace();
        }
    }

    // метод для чтения данных из файлов
    public static void readData(List<String> inputFiles, InputInteger inputInteger, InputFloat inputFloat, InputString inputString){
        // читаем каждый принятый файл
        for(int i = 0; i < inputFiles.size(); i++){
            // проверяем что файл существует и не пустой
            File file = new File(inputFiles.get(i));
            if (file.exists() && file.length() > 0){
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(inputFiles.get(i)));
                    String readStr = "";
                    // определяем тип и добавляем в список соответствующего объекта
                    while((readStr = reader.readLine())!=null){
                        if (isInteger(readStr)){
                            inputInteger.addInt(Integer.parseInt(readStr));
                        } else if (isFloat(readStr)){
                            inputFloat.addDouble(Float.parseFloat(readStr));
                        } else {
                            inputString.addString(readStr);
                        }
                    }
                    System.out.printf("File %s read \n", inputFiles.get(i));
                    reader.close();
                } catch (Exception e) {
                    System.out.println("File not found : " + inputFiles.get(i));
                }
            }
        }
    }


    // метод для проверки, является ли строка целым числом
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // метод для проверки, является ли строка вещественным числом
    public static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

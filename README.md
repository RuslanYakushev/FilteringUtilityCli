# FilteringUtilityCli
# Общая информация :
 * Название : FilteringUtilityCli
 * Интерфейс : CLI
 * Язык программирования : Java
 * Платформа : openjdk version "21.0.2" 2024-01-16 LTS.
 * ОС : РЕД ОС 8.0
 * Среда разработки : vscode
 * Утилита сортирует, полученные данные из файлов, по разным типам (строка, целое число, вещественное число) и записывает в соответствующие типам файлы (создаются при отсутствии). В процессе работы собирается информация по статистике (см. Инструкция по использованию).

# Инструкция по использованию :
 * Программа запускается пользователем в терминале, для этого в терминале необходимо перейти в директорию с утилитой и выполнить запуск, указав файлы для обработки.
 * Входящие файлы указать по названию через пробел.
 * Исходящие файлы будут сохранены в директории с утилитой, если нужен другой путь для сохранения, то указать опцию `-o` при запуске и полный путь.
 * ВАЖНО - указывается полный путь, который завершается косой чертой `/`.
 * Названия исходящих файлов будет по их типу, дополнительно можно установить префикс к названию с помощью опции `-p`.
 * После указания опции (регистр не имеет значения) необходимо указать следующим элементом значение для этой опции, если опция не принимает значение, то её можно указать в любом месте после имени утилиты.
 * При работе утилиты выводится успешные шаги : запуск, чтение, запись.
 * При выборе показа информации `-s` и `-f`, первым будет всегда короткая информация.
 * Показать статистистику кратко при запуске `-s` :  `java FiltrationCli -s strings.txt`
 * Показать полную статистистику при запуске `-f` :  `java FiltrationCli -f strings.txt`
 * Пример запуска : `java FiltrationCli strings.txt integers.txt`
 * Пример запуска с опцией `-o` : `java FiltrationCli strings.txt integers.txt doubles.txt -o /home/user/` 
 * Пример запуска с опцией `-p` : `java FiltrationCli strings.txt integers.txt doubles.txt -p test_`

# Использование :
 * Перейти в директорию для программы и склонировать командой : `git clone https://github.com/RuslanYakushev/FilteringUtilityCli.git`
 * Пример запуска со всеми параметрами : `java FilteringUtilityCli integers.txt floats.txt strings.txt -o /home/ruslan/Projects/shift_test/FilteringUtilityCli/src/result/ -p tak_ -a -f -s`
 * Пример запуска со всеми параметрами : `java -jar FilteringUtilityCli.jar integers.txt floats.txt strings.txt -o /home/ruslan/Projects/shift_test/FilteringUtilityCli/src/result/ -p tak_  -f -s`

# Собрать :
 * Перейти в директорию для программы и склонировать командой : `git clone https://github.com/RuslanYakushev/FilteringUtilityCli.git`
 * Пример компиляции : `javac FilteringUtilityCli.java -Xlint`
 * Создания архива : `jar cfm FilteringUtilityCli.jar MANIFEST.MF *.class`


 

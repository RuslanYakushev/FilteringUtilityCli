import java.util.ArrayList;

public class InputString {
    // список считанных значений
    private ArrayList<String> data = new ArrayList<>();

    // имя файла
    private String nameOutputFile = "strings.txt";

    // получить число записей
    public int getCount(){
        return data.size();
    }

    // получить минимальный размер строки
    public int getMinSizeString(){
        int resultMin = Integer.MAX_VALUE;
        for (String str : data) {
            if(str.length() < resultMin)
                resultMin = str.length();
        }
        return resultMin;
    }

    // получить максимальный размер строки
    public int getMaxSizeString(){
        int resultMax = Integer.MIN_VALUE;
        for (String str : data) {
            if(str.length() > resultMax)
                resultMax = str.length();
        }
        return resultMax;
    }

    // добавить строку
    public void addString(String input){
        data.add(input);
    }

    // получить имя файла
    public String getNameOutputFile (){
        return nameOutputFile;
    }

    // получить список
    public ArrayList<String> getListData(){
        return data;
    }
}

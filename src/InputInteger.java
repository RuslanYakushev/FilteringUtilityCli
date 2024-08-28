import java.util.ArrayList;
import java.util.List;

public class InputInteger {
    // список считанных значений
    private List<Integer> data = new ArrayList<>();

    // имя файла
    private String nameOutputFile = "integers.txt";

    // получить число записей
    public int getCount(){
        return data.size();
    }

    // получить минимальное значение
    public int getMinValue(){
        int resultMin = Integer.MAX_VALUE;
        for (int num : data) {
            if(num  < resultMin)
                resultMin = num;
        }
        return resultMin;
    }

    // получить максимальное значение
    public int getMaxValue(){
        int resultMax = Integer.MIN_VALUE;
        for (int num : data) {
            if(num  > resultMax)
                resultMax = num;
        }
        return resultMax;
    }

    // добавить элемент
    public void addInt(int input){
        data.add(input);
    }

    // получить имя файла
    public String getNameOutputFile (){
        return nameOutputFile;
    }

    // получить список
    public List<Integer> getListData(){
        return data;
    }

    // получить сумму всех элементов
    public int getSum(){
        int result = 0;
        for (int d : data)
            result += d;
        return result;
    }

    // получить средне значение
    public int getAverageValue(){
        return (getSum() / getCount());
    }
}

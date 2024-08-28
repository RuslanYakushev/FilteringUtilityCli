import java.util.ArrayList;

public class InputFloat {
    // список считанных значений
    private ArrayList<Float> data = new ArrayList<>();

    // имя файла
    private String nameOutputFile = "floats.txt";

    // получить число записей
    public int getCount(){
        return data.size();
    }

    // получить минимальное значение
    public Float getMinValue(){
        Float resultMin = Float.MAX_VALUE;
        for (Float num : data) {
            if(num  < resultMin)
                resultMin = num;
        }
        return resultMin;
    }

    // получить максимальное значение
    public Float getMaxValue(){
        Float resultMax = Float.MIN_VALUE;
        for (Float num : data) {
            if(num  > resultMax)
                resultMax = num;
        }
        return resultMax;
    }

    // добавить элемент
    public void addDouble(Float input){
        data.add(input);
    }

    // получить имя файла
    public String getNameOutputFile (){
        return nameOutputFile;
    }

    // получить список
    public ArrayList<Float> getListData(){
        return data;
    }

    // получить сумму всех элементов
    public Double getSum(){
        Double result = 0.0;
        for (Float f : data)
            result += Double.parseDouble(f + "");
        return result;
    }

    // получить средне значение
    public double getAverageValue(){
        return Double.parseDouble(getSum() + "") / Double.parseDouble(data.size() + "");
    }
}

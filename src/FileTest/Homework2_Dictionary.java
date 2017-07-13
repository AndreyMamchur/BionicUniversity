package FileTest;

import java.util.HashMap;
import java.util.Map;

public class Homework2_Dictionary {
    public static void main(String[] args) {
        //создаем объект класса Dictionary
        Dictionary dictionary = new Dictionary();
        //выводим Мапу в консоль
        for (Map.Entry<String, String> entry : dictionary.getDictionaryMap().entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
        System.out.println("Cancel translate as: " + dictionary.getDictionaryMap().get("Cancel"));
        System.out.println();

        //Добавляем новые слова в файл
        Map<String, String> newWord = new HashMap<>();
        newWord.put("Dictionary", "Словник");
        newWord.put("Word", "Слово");
        newWord.put("Name", "Ім'я");

        dictionary.saveDictionary(newWord);

        //выводим новый словарь
        dictionary.readFile();
        for (Map.Entry<String, String> entry : dictionary.getDictionaryMap().entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

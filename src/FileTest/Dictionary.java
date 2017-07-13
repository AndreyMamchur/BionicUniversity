package FileTest;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<String, String> dictionaryMap;

    public Dictionary() {
        dictionaryMap = new HashMap<>();
        String dictionaryString = this.readFileToString("Dict.txt");
        dictionaryMap = this.getMap(dictionaryString);
    }

    public Map<String, String> getDictionaryMap() {
        return dictionaryMap;
    }

    public void setDictionaryMap(Map<String, String> dictionaryMap) {
        this.dictionaryMap = dictionaryMap;
    }

    public void readFile(){
        String dictionaryString = this.readFileToString("Dict.txt");
        dictionaryMap = this.getMap(dictionaryString);
    }

    public String readFileToString(String path){
        String dictionaryString ="";
        BufferedReader inputStream = null;
        try {
            inputStream = Files.newBufferedReader(Paths.get(path), Charset.forName("UTF-8"));
            String line;
            while ((line = inputStream.readLine())!= null) {
                dictionaryString = dictionaryString + line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dictionaryString;
    }

    public Map<String, String> getMap(String dictionaryString){
        Map<String, String> dictionaryMap = new HashMap<>();
        int length = dictionaryString.length();
        char[] dictionaryArray = new char[length];
        dictionaryArray = dictionaryString.toCharArray();
        String key = "";
        String value = "";
        String buffer = "";
        for (int i = 0; i<length; i++){
            if ((dictionaryArray[i] == '\n') && (dictionaryArray[i-1] == '\n')){
                continue;
            } else if ((dictionaryArray[i] == ' ') && (dictionaryArray[i+1] == ':')) {
                key = buffer;
                buffer = "";
                continue;
            } else if (dictionaryArray[i] == '\n'){
                value = buffer;
                dictionaryMap.put(key, value);
                buffer = "";
                continue;
            } else if (dictionaryArray[i] == ':'){
                continue;
            } else if (dictionaryArray[i] == ' '){
                continue;
            } else if (dictionaryArray[i] == '\uFEFF'){
                continue;
            }
            buffer += dictionaryArray[i];
//            System.out.println(dictionaryArray[i]);
        }
        return dictionaryMap;
    }

    public void saveDictionary(Map<String, String> dictionaryMap){
        BufferedWriter bufferedWriter = null;
        String path = "Dict.txt";
        try {
            bufferedWriter = Files.newBufferedWriter(Paths.get(path), Charset.forName("UTF-8"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, String>entry : dictionaryMap.entrySet()){
            if (this.dictionaryMap.containsKey(entry.getKey())){
                continue;
            }
            String line = entry.getKey() + " : " + entry.getValue();
            try {
                bufferedWriter.newLine();
                bufferedWriter.write(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

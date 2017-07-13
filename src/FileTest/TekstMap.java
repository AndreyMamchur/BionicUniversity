package FileTest;

import sun.swing.BakedArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TekstMap {
    public static void main(String[] args) {
        TekstMap tekstMap = new TekstMap();
        String fileString = tekstMap.readFileToString("D:\\IntelIdeaWorkspace\\BionicUniversity\\src\\FileTest\\America’s music culture.txt");
//        System.out.println(fileString);
        char[] fileChar = fileString.toCharArray();
        Set<Character> setChar = new HashSet<>();
        for (char c : fileChar){
            setChar.add(c);
        }
        List<Character> characterList = new ArrayList<>();
        characterList.addAll(setChar);

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        characterIntegerMap = tekstMap.getMap(characterList, fileChar);

        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()){
            System.out.println("char " + entry.getKey() + " found in the text " + entry.getValue());
        }
    }

    public String readFileToString(String path){
        String fileString ="";
        BufferedReader inputStream = null;
        try {
            inputStream = Files.newBufferedReader(Paths.get(path), Charset.forName("UTF-8"));
            String line;
            while ((line = inputStream.readLine())!= null) {
                fileString = fileString + line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileString;
    }

    public Map<Character, Integer> getMap(List<Character> characterList, char[] fileChar){
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character character : characterList){
            Integer cout = 0;
            for (char c : fileChar){
                if (character == c){
                    cout++;
                }
            }
            charMap.put(character, cout);
        }
        return charMap;
    }
}

package Homework3;

import java.io.*;

public class Homework3 {
    public static void main(String[] args) {
        //создаём объекты
        SMS sms1 = new SMS("Hello", "+380675235445", "+380675235335");
        MMS mms1 = new MMS("Hi", "+380675235445", "+380675235335");
        EmailMessage emailMessage1 = new EmailMessage("Hello World!!!", "mamchurandrey87@gmail.com","1threedog1@gmail.com");
        PushMessage pushMessage1 = new PushMessage("Get new version!", "14564c78q","65736kjdf8");

        //Проводим сериализацию в корень проекта
        try (ObjectOutputStream outSerializable = new ObjectOutputStream(new FileOutputStream("Serializable.bin"))){
            outSerializable.writeObject(sms1);
            outSerializable.writeObject(mms1);
            outSerializable.writeObject(emailMessage1);
            outSerializable.writeObject(pushMessage1);
            System.out.println("Serialization has been successful");
        } catch (IOException e){
            e.printStackTrace();
        }

        //копируем файл Serializable.bin в папку back-up
        try (FileInputStream inFile = new FileInputStream("Serializable.bin");
             FileOutputStream outFile = new FileOutputStream("D:\\IntelIdeaWorkspace\\gitRepository\\BionicUniversity\\back-up\\Serializable.bin"))
        {
            int c;
            while ((c = inFile.read()) != -1){
                outFile.write(c);
            }
            System.out.println("File copy successful\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Проводим десериализацию
        SMS sms2 = null;
        MMS mms2 = null;
        EmailMessage emailMessage2 = null;
        PushMessage pushMessage2 = null;
        try (ObjectInputStream inSerializable = new ObjectInputStream(new FileInputStream("D:\\IntelIdeaWorkspace\\gitRepository\\BionicUniversity\\back-up\\Serializable.bin")))
        {
            sms2 = (SMS) inSerializable.readObject();
            mms2 = (MMS) inSerializable.readObject();
            emailMessage2 = (EmailMessage) inSerializable.readObject();
            pushMessage2 = (PushMessage) inSerializable.readObject();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("Deserialization has been successful");
        System.out.println(sms2);
        System.out.println(mms2);
        System.out.println(emailMessage2);
        System.out.println(pushMessage2);
    }
}

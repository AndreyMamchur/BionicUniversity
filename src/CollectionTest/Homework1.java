package CollectionTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.of;

public class Homework1 {
    public static void main(String[] args) {
        //Создание счетов
        Deposit depo1 = new Deposit("Альфа-Банк","Simple", of(2017, 9, 8), 61, 10000, 18);
        Deposit depo2 = new Deposit("Приват Банк","Month Capit", of(2016, 2, 1), 181, 10000, 21);
        Deposit depo3 = new Deposit("Приват Банк","Simple", of(2016, 11, 12), 30, 5500, 15.3);
        Deposit depo4 = new Deposit("Правекс Банк","Barier", of(2016, 12, 18), 370, 43000, 19.56);
        Deposit depo5 = new Deposit("Правекс Банк","Month Capit", of(2016, 7, 12), 91, 12000, 16);

        //Создание ArrayList и добавление в него дерозитов
        List<Deposit> depositList = new ArrayList<>();
        depositList.add(depo1);
        depositList.add(depo2);
        depositList.add(depo3);
        depositList.add(depo4);
        depositList.add(depo5);

        //Создаем объект класса DepoArrayListTools
        DepoArrayListTools depoArrayListTools = new DepoArrayListTools();

        //проставление статуса активный/архивный и отсортировка активных
        List<Deposit> activeList = new ArrayList<>();
        activeList = depoArrayListTools.statusCheck(depositList);
        System.out.println("Print active deposit");
        depoArrayListTools.printAll(activeList);

        //Метод, который возвращает мапу название банка на колекцию депозитов
        System.out.println("Print Map NameOfBank:Depo");
        Map<String, List<Deposit>> mapBankDep = new HashMap<>();
        mapBankDep = depoArrayListTools.getMapForBanks(depositList);
        for (Map.Entry<String, List<Deposit>>entry : mapBankDep.entrySet()){
            String key = entry.getKey();
            List<Deposit> value = entry.getValue();
            System.out.println(key);
            for (Deposit depo : value){
                System.out.println(depo);
            }
            System.out.println();
        }

        //Метод, который возвращает мапу статус на колекцию депозитов
        System.out.println("Print Map Status:Deposit");
        Map<String, List<Deposit>> mapStatusDep = new HashMap<>();
        mapStatusDep = depoArrayListTools.getMapForStatus(depositList);
        for (Map.Entry<String, List<Deposit>>entry : mapStatusDep.entrySet()){
            String key = entry.getKey();
            List<Deposit> value = entry.getValue();
            System.out.println(key);
            for (Deposit depo : value){
                System.out.println(depo);
            }
            System.out.println();
        }

        //Метод, который принимает название (стринг) одного из полей модели и возвращает отсортированый за ним лист депозитов
        System.out.println("Print ArrayList sorted by Name of Banks");
        try {
            depoArrayListTools.fieldSort("nameOfBank", depositList);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        depoArrayListTools.printAll(depositList);

        System.out.println("Print ArrayList sorted by Depo Type");
        try {
            depoArrayListTools.fieldSort("depoType", depositList);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        depoArrayListTools.printAll(depositList);

        System.out.println("Print ArrayList sorted by Start Date");
        try {
            depoArrayListTools.fieldSort("startDate", depositList);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        depoArrayListTools.printAll(depositList);

        System.out.println("Print ArrayList sorted by Day Long");
        try {
            depoArrayListTools.fieldSort("dayLong", depositList);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        depoArrayListTools.printAll(depositList);

        System.out.println("Print ArrayList sorted by Sum");
        try {
            depoArrayListTools.fieldSort("sum", depositList);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        depoArrayListTools.printAll(depositList);

        System.out.println("Print ArrayList sorted by Interest Rate");
        try {
            depoArrayListTools.fieldSort("interestRate", depositList);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        depoArrayListTools.printAll(depositList);

        System.out.println("Print ArrayList sorted by Deposit Status");
        try {
            depoArrayListTools.fieldSort("depositStatus", depositList);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        depoArrayListTools.printAll(depositList);
    }
}

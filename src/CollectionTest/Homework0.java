package CollectionTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static java.time.LocalDate.of;

public class Homework0 {
    public static void main(String[] args) {
        //Создание счетов
        Deposit depo1 = new Deposit("Simple", of(2013, 9, 8), 61, 10000, 18);
        Deposit depo2 = new Deposit("Month Capit", of(2012, 2, 1), 181, 10000, 21);
        Deposit depo3 = new Deposit("Simple", of(2013, 11, 12), 30, 5500, 15.3);
        Deposit depo4 = new Deposit("Barier", of(2011, 12, 18), 370, 43000, 19.56);
        Deposit depo5 = new Deposit("Month Capit", of(2013, 7, 12), 91, 12000, 16);

        //Создание ArrayList и добавление в него дерозитов
        List<Deposit> depositList = new ArrayList<>();
        depositList.add(depo1);
        depositList.add(depo2);
        depositList.add(depo3);
        depositList.add(depo4);
        depositList.add(depo5);

        //Создаем объект класса DepoArrayListTools
        DepoArrayListTools depoArrayListTools = new DepoArrayListTools();

        //Проверка метода getPrincipal
        System.out.println("Sum of all deposits: " + depoArrayListTools.getPrincipal(depositList));
        System.out.println("Sum of all deposits(Iterator): " + depoArrayListTools.getPrincipialIterator(depositList));
        System.out.println();

        //Проводим сортировку без компаратора
        Collections.sort(depositList);
        System.out.println("Print the ArrayList");
        depoArrayListTools.printAll(depositList);
        System.out.println("Print the reverse ArrayList");
        Collections.reverse(depositList);
        depoArrayListTools.printAll(depositList);

        //Проверяем работу TreeSet
        TreeSet<Deposit> treeSet = new TreeSet<>();
        treeSet.add(depo1);
        treeSet.add(depo2);
        treeSet.add(depo3);
        treeSet.add(depo4);
        treeSet.add(depo5);

        System.out.println("Print the TreeSet");

        for (Deposit dep : treeSet) {
            System.out.println(dep);
        }
        System.out.println();

        //Создаем компаратор для сортировки по полю interestRate
        Comparator<Deposit> comparator = new Comparator<Deposit>() {
            @Override
            public int compare(Deposit dep1, Deposit dep2) {
                if ((dep1.getInterestRate()- dep2.getInterestRate()) < 0){
                    return -1;
                } else if ((dep1.getInterestRate()- dep2.getInterestRate()) > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        //Сортировка с использованием компаратора
        Collections.sort(depositList, comparator);
        System.out.println("Print the ArrayList sorted by Interest Rate");
        depoArrayListTools.printAll(depositList);

        //Проверка метода remove
        System.out.println("Size of depositList: " + depositList.size());
        depoArrayListTools.removeOver10000(depositList);
        System.out.println("Size of depositList: " + depositList.size());
    }
}

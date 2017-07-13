package CollectionTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

import static java.time.LocalDate.of;

public class DepoArrayListTools {

    //метод возвращающий сумму всех депозитов в ArrayList
    public long getPrincipal(List<Deposit> depo) {
        long sumDepo = 0;
        int sizeDepoList = depo.size();
        for (int i = 0; i < sizeDepoList; i++) {
            sumDepo += depo.get(i).getSum();
        }
        return sumDepo;
    }

    //метод возвращающий сумму всех депозитов в ArrayList с помощью итератора
    public long getPrincipialIterator(List<Deposit> depo) {
        long sumDepo = 0;
        for (Iterator<Deposit> iter = depo.iterator(); iter.hasNext(); ) {
            sumDepo += iter.next().getSum();
        }
        return sumDepo;
    }

    //удаление депозитов с величиной вклада больше 10000
    public void removeOver10000(List<Deposit> depo) {
        Iterator<Deposit> iter = depo.iterator();
        while (iter.hasNext()) {
            if (iter.next().getSum() > 10000) {
                iter.remove();
            }
        }
        System.out.println("Remove deposit with sum over 10000");
    }

    //выведение на экран всех депозитов
    public void printAll(List<Deposit> depo) {
        for (Deposit deposit : depo) {
            System.out.println(deposit);
        }
        System.out.println();
    }

    //проставление статуса активный/архивный и отсортировка активных
    public List<Deposit> statusCheck (List<Deposit> depo){
        List<Deposit> depoActive = new ArrayList<>();
        LocalDate dateNow = LocalDate.now();
        for (Deposit deposit : depo) {
            if (deposit.getStartDate().plusDays(deposit.getDayLong()).isAfter(dateNow)){
                deposit.setDepositStatus("active");
                depoActive.add(deposit);
            } else {
                deposit.setDepositStatus("archived");
            }
        }
        return depoActive;
    }

    //Метод, который возвращает мапу название банка на колекцию депозитов
    public Map<String, List<Deposit>> getMapForBanks(List<Deposit> depo){
        Set<String> nameOfBanks = new HashSet<>();
        for (Deposit deposit:depo){
            nameOfBanks.add(deposit.getNameOfBank());
        }

        List<String> listNameOfBanks = new ArrayList<>();
        listNameOfBanks.addAll(nameOfBanks);

        Map<String, List<Deposit>> depositOfBank = new HashMap<>();
        for(int i = 0; i<listNameOfBanks.size();i++){
            List<Deposit> listDepo = new ArrayList<>();
            for (Deposit deposit:depo){
                if (deposit.getNameOfBank().equals(listNameOfBanks.get(i))){
                    listDepo.add(deposit);
                }
            }
            depositOfBank.put(listNameOfBanks.get(i), listDepo);
        }
        return depositOfBank;
    }

    //Метод, который возвращает мапу статус на колекцию депозитов
    public Map<String, List<Deposit>> getMapForStatus(List<Deposit> depo){
        List<String> listStatus = new ArrayList<>();
        listStatus.add("active");
        listStatus.add("archived");

        Map<String, List<Deposit>> depositOfStatus = new HashMap<>();

        for(int i = 0; i<listStatus.size();i++){
            List<Deposit> listDepo = new ArrayList<>();
            for (Deposit deposit:depo){
                if (deposit.getDepositStatus().equals(listStatus.get(i))){
                    listDepo.add(deposit);
                }
            }
            depositOfStatus.put(listStatus.get(i), listDepo);
        }
        return depositOfStatus;
    }

    //Метод, который принимает название (стринг) одного из полей модели и возвращает отсортированый за ним лист депозитов
    public List<Deposit> fieldSort(String nameOfField, List<Deposit> depo) throws NoSuchMethodException {
        Class c = Deposit.class;
        Field[] publicFields = c.getDeclaredFields();
        for (Field field : publicFields) {
            field.setAccessible(true);
            if (nameOfField.equals(field.getName())) {
                String typeOfField = field.getType().getName();

                if (typeOfField.equals("int")) {
                    Comparator<Deposit> comparatorInt = new Comparator<Deposit>() {
                        @Override
                        public int compare(Deposit dep1, Deposit dep2) {
                            int valueDep1 = 0;
                            int valueDep2 = 0;

                            try {
                                valueDep1 = field.getInt(dep1);
                                valueDep2 = field.getInt(dep2);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            if ((valueDep1 - valueDep2) < 0) {
                                return -1;
                            } else if ((valueDep1 - valueDep2) > 0) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    };

                    Collections.sort(depo, comparatorInt);

                } else if (typeOfField.equals("long")){
                    Comparator<Deposit> comparatorLong = new Comparator<Deposit>() {
                        @Override
                        public int compare(Deposit dep1, Deposit dep2) {
                            long valueDep1 = 0;
                            long valueDep2 = 0;
                            try {
                                valueDep1 = field.getLong(dep1);
                                valueDep2 = field.getLong(dep2);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            if ((valueDep1 - valueDep2) < 0) {
                                return -1;
                            } else if ((valueDep1 - valueDep2) > 0) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    };

                    Collections.sort(depo, comparatorLong);

                } else if (typeOfField.equals("double")){
                    Comparator<Deposit> comparatorDouble = new Comparator<Deposit>() {
                        @Override
                        public int compare(Deposit dep1, Deposit dep2) {
                            double valueDep1 = 0;
                            double valueDep2 = 0;
                            try {
                                valueDep1 = field.getDouble(dep1);
                                valueDep2 = field.getDouble(dep2);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            if ((valueDep1 - valueDep2) < 0) {
                                return -1;
                            } else if ((valueDep1 - valueDep2) > 0) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    };

                    Collections.sort(depo, comparatorDouble);

                } else if (typeOfField.equals("java.time.LocalDate")){
                    Comparator<Deposit> comparatorLocalDate = new Comparator<Deposit>() {
                        @Override
                        public int compare(Deposit dep1, Deposit dep2) {
                            LocalDate valueDep1 = of(1,1,1);
                            LocalDate valueDep2 = of(1,1,1);
                            try {
                                valueDep1 = (LocalDate) field.get(dep1);
                                valueDep2 = (LocalDate) field.get(dep2);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            if (valueDep1.isBefore(valueDep2)) {
                                return -1;
                            } else if (valueDep1.isAfter(valueDep2)) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    };

                    Collections.sort(depo, comparatorLocalDate);

                } else if (typeOfField.equals("java.lang.String")){
                    Comparator<Deposit> comparatorString = new Comparator<Deposit>() {
                        @Override
                        public int compare(Deposit dep1, Deposit dep2) {
                            String valueDep1 = "";
                            String valueDep2 = "";

                            try {
                                valueDep1 = (String) field.get(dep1);
                                valueDep2 = (String) field.get(dep2);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            if (valueDep1.compareTo(valueDep2) < 0) {
                                return -1;
                            } else if (valueDep1.compareTo(valueDep2) > 0) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    };
                    Collections.sort(depo, comparatorString);
                }
            }
        }
        return depo;
    }
}

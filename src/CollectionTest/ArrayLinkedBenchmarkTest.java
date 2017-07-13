package CollectionTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayLinkedBenchmarkTest {
    public static void main(String[] args) {
        List<Cat> arrayList = new ArrayList<>();
        List<Cat> linkedList = new LinkedList<>();
        ArrayLinkedBenchmarkTest test = new ArrayLinkedBenchmarkTest();

        //Создаем миллион рандомных котов и вносим их в списки
        for (int i = 0; i < 1000000; i++){
            Cat cat = new Cat();
            cat.setName(cat.getRandomName());
            cat.setAge((int)(Math.random()*25));
            cat.setColor(cat.getRandomColor());
            arrayList.add(cat);
            linkedList.add(cat);
        }
        System.out.println("Размер ArrayList:" + arrayList.size());
        System.out.println("Размер LinkedList:" + linkedList.size());
        System.out.println();

        //сравниваем скорость работы команд get()
        System.out.println("CРАВНИВАЕМ СКОРОСТЬ РАБОТЫ КОМАНД get()\n");
        long timeBefore = 0;
        long timeAfter = 0;

        timeBefore = System.nanoTime();
        System.out.println("Данные кота №1 в ArrayList:\n" + "Имя: " + arrayList.get(0).getName() + "\n" + "Возраст: " + arrayList.get(0).getAge() + "\n" + "Цвет: " + arrayList.get(0).getColor());
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды get для ArrayList для 1 элемента: " + (timeAfter-timeBefore) +" ns");
        System.out.println();

        timeBefore = System.nanoTime();
        System.out.println("Данные кота №1 в LinkedList:\n" + "Имя: " + linkedList.get(0).getName() + "\n" + "Возраст: " + linkedList.get(0).getAge() + "\n" + "Цвет: " + linkedList.get(0).getColor());
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды get для LinkedList для 1 элемента: " + (timeAfter-timeBefore) +" ns");
        System.out.println();

        timeBefore = System.nanoTime();
        System.out.println("Данные кота №1000000 в ArrayList:\n" + "Имя: " + arrayList.get(999999).getName() + "\n" + "Возраст: " + arrayList.get(999999).getAge() + "\n" + "Цвет: " + arrayList.get(999999).getColor());
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды get для ArrayList для 1000000 элемента: " + (timeAfter-timeBefore) +" ns");
        System.out.println();

        timeBefore = System.nanoTime();
        System.out.println("Данные кота №1000000 в LinkedList:\n" + "Имя: " + linkedList.get(999999).getName() + "\n" + "Возраст: " + linkedList.get(999999).getAge() + "\n" + "Цвет: " + linkedList.get(999999).getColor());
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды get для LinkedList для 1000000 элемента: " + (timeAfter-timeBefore) +" ns");
        System.out.println();

        timeBefore = System.nanoTime();
        System.out.println("Данные кота №500000 в ArrayList:\n" + "Имя: " + arrayList.get(499999).getName() + "\n" + "Возраст: " + arrayList.get(499999).getAge() + "\n" + "Цвет: " + arrayList.get(499999).getColor());
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды get для ArrayList для 500000 элемента: " + (timeAfter-timeBefore) +" ns");
        System.out.println();

        timeBefore = System.nanoTime();
        System.out.println("Данные кота №500000 в LinkedList:\n" + "Имя: " + linkedList.get(499999).getName() + "\n" + "Возраст: " + linkedList.get(499999).getAge() + "\n" + "Цвет: " + linkedList.get(499999).getColor());
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды get для LinkedList для 500000 элемента: " + (timeAfter-timeBefore) +" ns");
        System.out.println();



        //сравниваем скорость работы команд set()
        System.out.println("CРАВНИВАЕМ СКОРОСТЬ РАБОТЫ КОМАНД set()\n");

        Cat catNew = new Cat();
        catNew.setName(catNew.getRandomName());
        catNew.setAge((int)(Math.random()*25));
        catNew.setColor(catNew.getRandomColor());
        System.out.println("Данные кота №1 в ArrayList:\n" + "Имя: " + arrayList.get(0).getName() + "\n" + "Возраст: " + arrayList.get(0).getAge() + "\n" + "Цвет: " + arrayList.get(0).getColor() + "\n");
//        timeBefore = System.currentTimeMillis();
        timeBefore = System.nanoTime();
        arrayList.set(0, catNew);
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды set для ArrayList для 1 элемента: " + (timeAfter-timeBefore) + " ns\n");
        System.out.println("Данные кота №1 в ArrayList:\n" + "Имя: " + arrayList.get(0).getName() + "\n" + "Возраст: " + arrayList.get(0).getAge() + "\n" + "Цвет: " + arrayList.get(0).getColor() + "\n");
        System.out.println();

        System.out.println("Данные кота №1 в LinkedList:\n" + "Имя: " + linkedList.get(0).getName() + "\n" + "Возраст: " + linkedList.get(0).getAge() + "\n" + "Цвет: " + linkedList.get(0).getColor() + "\n");
        timeBefore = System.nanoTime();
        linkedList.set(0, catNew);
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды set для LinkedList для 1 элемента: " + (timeAfter-timeBefore) + " ns\n");
        System.out.println("Данные кота №1 в LinkedList:\n" + "Имя: " + linkedList.get(0).getName() + "\n" + "Возраст: " + linkedList.get(0).getAge() + "\n" + "Цвет: " + linkedList.get(0).getColor() + "\n");
        System.out.println();

        System.out.println("Данные кота №1000000 в ArrayList:\n" + "Имя: " + arrayList.get(999999).getName() + "\n" + "Возраст: " + arrayList.get(999999).getAge() + "\n" + "Цвет: " + arrayList.get(999999).getColor() + "\n");
        timeBefore = System.nanoTime();
        arrayList.set(999999, catNew);
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды set для ArrayList для 1000000 элемента: " + (timeAfter-timeBefore) + " ns\n");
        System.out.println("Данные кота №1000000 в ArrayList:\n" + "Имя: " + arrayList.get(999999).getName() + "\n" + "Возраст: " + arrayList.get(999999).getAge() + "\n" + "Цвет: " + arrayList.get(999999).getColor() + "\n");
        System.out.println();

        System.out.println("Данные кота №1000000 в LinkedList:\n" + "Имя: " + linkedList.get(999999).getName() + "\n" + "Возраст: " + linkedList.get(999999).getAge() + "\n" + "Цвет: " + linkedList.get(999999).getColor() + "\n");
        timeBefore = System.nanoTime();
        linkedList.set(999999,catNew);
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды set для LinkedList для 1000000 элемента: " + (timeAfter-timeBefore) + " ns\n");
        System.out.println("Данные кота №1000000 в LinkedList:\n" + "Имя: " + linkedList.get(999999).getName() + "\n" + "Возраст: " + linkedList.get(999999).getAge() + "\n" + "Цвет: " + linkedList.get(999999).getColor() + "\n");
        System.out.println();

        System.out.println("Данные кота №500000 в ArrayList:\n" + "Имя: " + arrayList.get(499999).getName() + "\n" + "Возраст: " + arrayList.get(499999).getAge() + "\n" + "Цвет: " + arrayList.get(499999).getColor() + "\n");
        timeBefore = System.nanoTime();
        arrayList.set(499999, catNew);
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды set для ArrayList для 500000 элемента: " + (timeAfter-timeBefore) + " ns\n");
        System.out.println("Данные кота №500000 в ArrayList:\n" + "Имя: " + arrayList.get(499999).getName() + "\n" + "Возраст: " + arrayList.get(499999).getAge() + "\n" + "Цвет: " + arrayList.get(499999).getColor() + "\n");
        System.out.println();

        System.out.println("Данные кота №500000 в LinkedList:\n" + "Имя: " + linkedList.get(499999).getName() + "\n" + "Возраст: " + linkedList.get(499999).getAge() + "\n" + "Цвет: " + linkedList.get(499999).getColor() + "\n");
        timeBefore = System.nanoTime();
        linkedList.set(499999, catNew);
        timeAfter = System.nanoTime();
        System.out.println("Время работы команды set для LinkedList для 500000 элемента: " + (timeAfter-timeBefore) + " ns\n" );
        System.out.println("Данные кота №500000 в LinkedList:\n" + "Имя: " + linkedList.get(499999).getName() + "\n" + "Возраст: " + linkedList.get(499999).getAge() + "\n" + "Цвет: " + linkedList.get(499999).getColor() + "\n");

    }
}

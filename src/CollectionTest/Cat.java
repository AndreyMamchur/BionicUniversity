package CollectionTest;

public class Cat {
    private String name;
    private int age;
    private String color;

    public Cat() {
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRandomName(){
        switch ((int)(Math.random()*10)){
            case 0:
                return "Мурчик";
            case 1:
                return "Васька";
            case 2:
                return "Красавчик";
            case 3:
                return "Мурзик";
            case 4:
                return "Пушистик";
            case 5:
                return "Гав";
            case 6:
                return "Том";
            case 7:
                return "Леопольд";
            case 8:
                return "Коготок";
            case 9:
                return "Гарфилд";
        }
        return " ";
    }

    public String getRandomColor() {
        switch ((int)(Math.random()*10)){
            case 0:
                return "Белый";
            case 1:
                return "Черный";
            case 2:
                return "Рыжий";
            case 3:
                return "Голубой";
            case 4:
                return "Шоколадный";
            case 5:
                return "Черепаховый";
            case 6:
                return "Кремовый";
            case 7:
                return "Полосатый";
            case 8:
                return "Серебристый";
            case 9:
                return "Темно-серый";
        }
        return " ";
    }

    public void printCat(){
        System.out.println("Имя: " + this.getName() + " Возраст: " + this.getAge() + " Раскраска: " + this.getColor());
    }
}

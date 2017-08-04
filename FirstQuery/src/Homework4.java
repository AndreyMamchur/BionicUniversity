import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Homework4 {
    public static void main(String[] args) {
        try {
            Connection connection = SQLTools.getConnection();
            List<Family> familyList = new ArrayList<>();
            Family family1 = null;
            //Заполнение Family с базы данных без сета детей
            family1 = SQLTools.getFamilyBySurnameWithoutChildPrepare("Ковальчук", connection);
            System.out.println(family1);
            //При прямом обращение к детям, сет заполняется.
            System.out.println(family1.getChildren());
            System.out.println(family1);
            //теперь тоже самое с Петами
            for (Child child : family1.getChildren()){
                System.out.println(child.getPets());
            }
            //Теперь в Family есть созданные Child, а в Child – Pet
            System.out.println(family1);

        } catch (Exception e){
            e.getStackTrace();
        }

    }
}

import java.io.*;
import java.sql.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class SQLTools {
    static Connection connection;

    //Создаем и возвращаем Connection
    public static Connection getConnection() {
        if (connection == null) {
            Properties props = null;
            try (InputStreamReader in = new InputStreamReader(new FileInputStream("appProperties.txt"), "UTF-8"))
            {
                props=new Properties();
                props.load(in);
                String connString = props.getProperty("DBConnectionString");
                connection = DriverManager.getConnection(connString);

                System.out.println("Connection created");
                return connection;
            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;

    }


    //Создаем и возвращаем обьект класса Child, заполняя его данными из БД по ID без setPets
    public static Child getChildByIdWithoutPets(int id, Connection connection, Family family) {
        //Проверки полученных данных на null
        if (family == null) {
            System.out.println("Family = null");
            return null;
        }
        if (connection == null) {
            System.out.println("Connection = null");
            return null;
        }
        ResultSet rs = null;
        //Создаю объект класса Child и заполняю его данными из БД по familyID
        Child child = new Child();
        String comanda = "SELECT * FROM CHILDREN WHERE ID=?";
        try (PreparedStatement statement = connection.prepareStatement(comanda)) {
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                child.setId(rs.getInt("ID"));
                child.setName(rs.getString("NAME"));
                child.setNickName(rs.getString("NICKNAME"));
                child.setFamily(family);
            }
            return child;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Создаем и возвращаем обьект класса Child, заполняя его данными из БД по ID c setPets
    public static Child getChildByIdWithPets(int id, Connection connection, Family family) {
        //Проверки полученных данных на null
        if (family == null) {
            System.out.println("Family = null");
            return null;
        }
        if (connection == null) {
            System.out.println("Connection = null");
            return null;
        }
        Child child = null;
        //получаю объект класса Child без setPets
        child = SQLTools.getChildByIdWithoutPets(id, connection, family);
        //заполняю setPets
        child.setPets(SQLTools.getSetPet(connection, child));
        return child;
    }

    //Возвращаем Set<Pet> заполненый зверюшками по одному ребенку
    public static Set<Pet> getSetPet(Connection connection, Child child) {
        //Проверки полученных данных на null
        if (child == null) {
            System.out.println("Child = null");
            return null;
        }
        if (connection == null) {
            System.out.println("Connection = null");
            return null;
        }
        ResultSet rs = null;
        String comanda = "SELECT * FROM PETS WHERE CHILDID=?";
        Pet pet = new Pet();
        Set<Pet> pets = new HashSet<>();
        try (PreparedStatement statement = connection.prepareStatement(comanda)) {
            statement.setInt(1, child.getId());
            rs = statement.executeQuery();
            while (rs.next()) {
                pet.setId(rs.getInt("ID"));
                pet.setName(rs.getString("NAME"));
                pet.setChild(child);
                pet.setAdress(rs.getString("ADRESS"));
                pet.setFavoriteFoods(rs.getString("FAVORITEFOODS"));
                pets.add(pet);
            }
            rs.close();

            return pets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Возвращаем Set<Child> заполненый детьми по одному родителю без setPets
    public static Set<Child> getSetChildWithoutPets(Connection connection, Family family) {
        //Проверки полученных данных на null
        if (family == null) {
            System.out.println("Family = null");
            return null;
        }
        if (connection == null) {
            System.out.println("Connection = null");
            return null;
        }
        Set<Child> children = new HashSet<>();
        ResultSet rs = null;
        String comanda = "SELECT * FROM FAMILY_CHILD WHERE FAMILYID=?";
        try (PreparedStatement statement = connection.prepareStatement(comanda)) {
            statement.setInt(1, family.getId());
            rs = statement.executeQuery();
            while (rs.next()) {
                Child child = new Child();
                child = SQLTools.getChildByIdWithoutPets(rs.getInt("ID"), connection, family);
                children.add(child);
            }
            rs.close();
            return children;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Возвращаем Set<Child> заполненый детьми по одному родителю c setPets
    public static Set<Child> getSetChildWithPets(Connection connection, Family family) {
        //Проверки полученных данных на null
        if (family == null) {
            System.out.println("Family = null");
            return null;
        }
        if (connection == null) {
            System.out.println("Connection = null");
            return null;
        }
        Set<Child> children = null;
        children = SQLTools.getSetChildWithoutPets(connection, family);
        for (Child child : children){
            child.setPets(SQLTools.getSetPet(connection, child));
        }
        return children;
    }

    //Создаем и возвращаем обьект класса Family, заполняя его данными из БД по фамилии. Пользуемся обычным Statement
    public static Family getFamilyBySurname(String surname, Connection connection) {
        //Проверки полученных данных на null
        if (connection == null) {
            System.out.println("Connection = null");
            return null;
        }
        ResultSet rs = null;
        String comanda = "";
        Family family = new Family();
        try (Statement statement = connection.createStatement()) {
            comanda = "SELECT * FROM FAMILY WHERE SURNAME='" + surname + "'";
            rs = statement.executeQuery(comanda);
            while (rs.next()) {
                family.setId(rs.getInt("ID"));
                family.setSurname(rs.getString("SURNAME"));
                family.setNumberOfPets(rs.getInt("NUMBEROFPETS"));
                family.setAdress(rs.getString("ADRESS"));
            }
            rs.close();

            family.setChildren(SQLTools.getSetChildWithPets(connection, family));

            return family;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Создаем и возвращаем обьект класса Family, заполняя его данными из БД по фамилии без setChildren. Пользуемся prepareStatement
    public static Family getFamilyBySurnameWithoutChildPrepare(String surname, Connection connection) {
        //Проверки полученных данных на null
        if (connection == null) {
            System.out.println("Connection = null");
            return null;
        }
        ResultSet rs = null;
        Family family = new Family();
        String comanda = "SELECT * FROM FAMILY WHERE SURNAME=?";
        try (PreparedStatement statement = connection.prepareStatement(comanda)) {
            statement.setString(1, surname);
            rs = statement.executeQuery();
            while (rs.next()) {
                family.setId(rs.getInt("ID"));
                family.setSurname(rs.getString("SURNAME"));
                family.setNumberOfPets(rs.getInt("NUMBEROFPETS"));
                family.setAdress(rs.getString("ADRESS"));
            }
            rs.close();
            return family;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Создаем и возвращаем обьект класса Family, заполняя его данными из БД по фамилии c setChildren. Пользуемся prepareStatement
    public static Family getFamilyBySurnameWithChildPrepare(String surname, Connection connection) {
        //Проверки полученных данных на null
        if (connection == null) {
            System.out.println("Connection = null");
            return null;
        }

        Family family = null;
        family = SQLTools.getFamilyBySurnameWithoutChildPrepare(surname, connection);
        family.setChildren(SQLTools.getSetChildWithoutPets(connection, family));
        return family;
    }

}

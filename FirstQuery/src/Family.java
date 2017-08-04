import java.util.List;
import java.util.Set;

public class Family {
    int id;
    String surname;
    int numberOfPets;
    String adress;
    Set<Child> children;

    public Family() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Set<Child> getChildren() {
        if (children == null){
            children = SQLTools.getSetChildWithoutPets(SQLTools.getConnection(), this);
        }
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Family { " +
                "id = " + id +
                ", surname = '" + surname + '\'' +
                ", numberOfPets = " + numberOfPets +
                ", adress = '" + adress + '\'' +
                ", children = " + children +
                '}';
    }
}

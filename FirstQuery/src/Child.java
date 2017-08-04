import java.util.Set;

public class Child {
    int id;
    String name;
    String nickName;
    Family family;
    Set<Pet> pets;

    public Child() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Set<Pet> getPets() {
        if (pets == null){
            pets = SQLTools.getSetPet(SQLTools.getConnection(), this);
        }
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Child {" +
                " id = " + id +
                ", name = '" + name + '\'' +
                ", nickName = '" + nickName + '\'' +
                ", pets = " + pets +
                '}';
    }
}

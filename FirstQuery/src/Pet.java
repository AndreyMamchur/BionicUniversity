public class Pet {
    int id;
    String name;
    Child child;
    String adress;
    String favoriteFoods;

    public Pet() {
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

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(String favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    @Override
    public String toString() {
        return "Pet {" +
                " id = " + id +
                ", name = '" + name + '\'' +
                ", adress = '" + adress + '\'' +
                ", favoriteFoods = '" + favoriteFoods + '\'' +
                '}';
    }
}

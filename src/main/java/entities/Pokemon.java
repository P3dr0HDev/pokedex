package entities;

public class Pokemon {
    int id;
    String name;
    String type;

    public Pokemon(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + name + " | Tipo: " + type;
    }
}

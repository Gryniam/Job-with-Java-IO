

public class Model {
    int id;
    double age;
    int height;
    String name;
    String priz;

    public Model() {
    }
    public Model(int id, double age, int height, String name, String priz) {
        this.id = id;
        this.age = age;
        this.height = height;
        this.name = name;
        this.priz = priz;
    }

    public int Sort(Model object) {
        int result = 0;
        if (id < object.id)
            result = -1;
        else if (id > object.id)
            result = 1;
        return result;
    }
    public int getId() {
        return this.id;
    }
    public double getAge() {
        return this.age;
    }
    public int getHeight() {
        return this.height;
    }
    public String getName() {
        return this.name;
    }
    public String getPriz() {
        return this.priz;
    }
}

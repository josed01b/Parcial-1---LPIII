package src.factoryMethod;

public interface Juguete {
    int getId();

    int setId(int id);
    String getColor();
    Juguete clone(int id);
}

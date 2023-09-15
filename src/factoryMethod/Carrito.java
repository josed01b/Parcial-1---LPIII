package src.factoryMethod;

public class Carrito implements Juguete {

    private int id;
    private String color;
    private String marca;
    private int nroPuertas;

    public Carrito(int id, String color, String marca, int nroPuertas) {
        this.id = id;
        this.color = color;
        this.marca = marca;
        this.nroPuertas = nroPuertas;
    }

    public Carrito(Carrito car, int id) {
        this.id = id;
        this.color = car.color;
        this.marca = car.marca;
        this.nroPuertas = car.nroPuertas;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int setId(int id) {
        return this.id = id;
    }

    @Override
    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public int getNroPuertas() {
        return nroPuertas;
    }

    public static CarritoBuilder builder() {
        return new CarritoBuilder();
    }

    public static class CarritoBuilder {
        private int id;
        private String color;
        private String marca;
        private int nroPuertas;

        public CarritoBuilder id(int id) {

            this.id = id;
            return this;

        }

        public CarritoBuilder color(String color) {

            this.color = color;
            return this;

        }

        public CarritoBuilder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public CarritoBuilder nroPuertas(int nroPuertas) {
            this.nroPuertas = nroPuertas;
            return this;
        }

        public Carrito build() {
            return new Carrito(id, color, marca, nroPuertas);
        }

    }

    public Carrito clone(int id){
        return new Carrito(this, id);
    }
    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", nroPuertas='" + nroPuertas + '\'' +
                '}';
    }
}






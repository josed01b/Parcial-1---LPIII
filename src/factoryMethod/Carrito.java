package src.factoryMethod;

public class Carrito {

    private Integer id;
    private String color;
    private String marca;
    private String nroPuertas;

    public Carrito(Integer id, String color, String marca, String nroPuertas) {
        this.id = id;
        this.color = color;
        this.marca = marca;
        this.nroPuertas = nroPuertas;
    }

    public static CarritoBuilder builder() {
        return new CarritoBuilder();
    }

    public static class CarritoBuilder {
        private Integer id;
        private String color;
        private String marca;
        private String nroPuertas;

        public CarritoBuilder id(Integer id) {

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

        public CarritoBuilder nroPuertas(String nroPuertas) {
            this.nroPuertas = nroPuertas;
            return this;
        }

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






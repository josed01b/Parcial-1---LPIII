package src.factoryMethod;

public class Peluche implements Juguete{
    private int id;
    private String color;
    private String materialExterior;
    private String relleno;

    public Peluche(int id, String color, String materialExterior, String relleno) {
        this.id = id;
        this.color = color;
        this.materialExterior = materialExterior;
        this.relleno = relleno;
    }

    public Peluche(Peluche teddy, int id) {
        this.id = id;
        this.color = teddy.color;
        this.materialExterior = teddy.materialExterior;
        this.relleno = teddy.relleno;
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

    public String getMaterialExterior() {
        return materialExterior;
    }

    public String getRelleno() {
        return relleno;
    }

    public static PelucheBuilder builder() {
        return new PelucheBuilder();
    }

    public static class PelucheBuilder {
        private int id;
        private String color;
        private String materialExterior;
        private String relleno;
        public PelucheBuilder id(int id) {

            this.id = id;
            return this;

        }

        public PelucheBuilder color(String color) {

            this.color = color;
            return this;

        }

        public PelucheBuilder materialExterior(String materialExterior){
            this.materialExterior = materialExterior;
            return this;
        }

        public PelucheBuilder relleno (String relleno){
            this.relleno = relleno;
            return this;
        }

        public Peluche build() {

            return new Peluche( id,color,materialExterior,relleno);

        }

    }
    public Peluche clone(int id){
        return new Peluche(this, id);
    }

    @Override
    public String toString() {
        return "Peluche{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", materialExterior='" + materialExterior + '\'' +
                ", relleno='" + relleno + '\'' +
                '}';
    }
}

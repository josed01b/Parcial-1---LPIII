package src.factoryMethod;

public class Peluche {
    private Integer id;
    private String color;
    private String materialExterior;
    private String relleno;

    public Peluche(Integer id, String color, String materialExterior, String relleno) {
        this.id = id;
        this.color = color;
        this.materialExterior = materialExterior;
        this.relleno = relleno;
    }

    public static class PelucheBuilder {
        private Integer id;
        private String color;
        private String materialExterior;
        private String relleno;
        public PelucheBuilder id(Integer id) {

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

public class PasarPorValor {
    public static void main(String[] args) {
        //toda variable primitiva se pasa por valor
        Integer  i = 10;

        System.out.println(" iniciamos en el metodo main con i = " + i);
        test(i);
        System.out.println(" terminamos en el metodo main con i = " + i);

    }

    public static void test(Integer i){
        System.out.println("iniciamos el metodo test con i = " + i);
        i = 35;
        System.out.println("Finaliza el metodo test con i = " + i);

    }
}

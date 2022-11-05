public class Main {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        Crianca crianca = new Crianca(
                "Pedro",
                "brazilian",
                11,
                "ps5"
        );

        Elfo elfo = new Elfo(
                "Elfo 1",
                "contador"
        );

        fabrica.novoCrianca(crianca);
        fabrica.novoElfo(elfo);

        try {
            fabrica.addBonzinho("Pedro");
        } catch (CraincaNaoEncontrada e) {
            System.out.println(e.getMessage());
        }

        fabrica.listarBonzinhos();
    }
}

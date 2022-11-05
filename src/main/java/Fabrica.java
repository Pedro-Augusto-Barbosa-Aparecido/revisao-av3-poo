import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    private List<Crianca> criancas;
    private List<Elfo> elfos;
    private List<Crianca> listaBonzinhos;
    private final FileManager fileManager = new FileManager("files");

    public Fabrica() {
        criancas = new ArrayList<>();
        elfos = new ArrayList<>();
        listaBonzinhos = new ArrayList<>();
    }

    public void novoElfo (Elfo elfo) {
        this.elfos.add(elfo);
        System.out.printf("Elfo %s adicionado\n", elfo.getNome());
    }

    public void novoCrianca (Crianca crianca) {
        this.criancas.add(crianca);
        System.out.printf("Crianca %s adicionado\n", crianca.getNome());
    }

    public void addBonzinho (String nomeCrianca) {
        boolean added = false;
        for (Crianca crianca : this.criancas) {
            if (crianca.getNome().equals(nomeCrianca)) {
                this.listaBonzinhos.add(crianca);
                added = true;
                System.out.printf("Crianca %s, foi adicionado na lista de bonzinhos\n", nomeCrianca);
                break;
            }
        }

        if (!added) {
            throw new CraincaNaoEncontrada("Crianca " + nomeCrianca + " nao foi encontrada\n");
        }

        List<String> strings = new ArrayList<>();
        for (Crianca crianca : criancas) {
            strings.add(crianca.getNome() + ";" + crianca.getNacionalidade() + ";" + crianca.getPresenteDesejado() + ";" + crianca.getIdade());
        }

        fileManager.write("bonzinhos.txt", strings);
    }

    public void listarBonzinhos () {
        List<String> criancasByFile = fileManager.read("bonzinhos.txt");
        this.listaBonzinhos.clear();

        for (String crianca: criancasByFile) {
            String[] criancaSplited = crianca.split(";");
            this.listaBonzinhos.add(new Crianca(
                    criancaSplited[0],
                    criancaSplited[1],
                    Integer.parseInt(criancaSplited[3]),
                    criancaSplited[2]
            ));
        }

        int i = 0;
        for (Crianca crianca : this.listaBonzinhos) {
            System.out.println("\n====================================================");
            System.out.printf("Bonzinho numero: %d\n", ++i);
            System.out.printf("Nome da crianca: %s\n", crianca.getNome());
            System.out.printf("Idade da crianca: %d\n", crianca.getIdade());
            System.out.printf("Nacionalidade da crianca: %s\n", crianca.getNacionalidade());
            System.out.printf("Presente da crianca: %s\n", crianca.getPresenteDesejado());
            System.out.println("====================================================");
            System.out.println("");

        }
    }

}

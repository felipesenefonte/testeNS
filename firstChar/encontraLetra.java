import java.util.ArrayList;
import java.util.List;

public class encontraLetra {

    public static void main(String[] args) {

		//TESTS
        //firstChar(new MyStrem("Felipe"));
        //firstChar(new MyStrem("FeliFe"));
        //firstChar(new MyStrem("asddddas"));
        firstChar(new MyStream("aAbBABac"));

   }

    public static void firstChar(Stream input) {

        List lista = new ArrayList();

        char next;
        String repetidos = "";

        while (input.hasNext()) {

            //recupera o prox char
            next = input.getNext();

            //verifica se já existe na lista, caso exista é um item duplicado
            // entao removemos da lista e a lista é reorganizada.
            if (lista.contains(next)) {
                lista.remove(lista.indexOf(next));
                repetidos += next; //adiciona na string de repetidos
            } else {

                //verifica lista de repetidos
                if (repetidos.indexOf(next) == -1) {
                    //caso nao exista, adicionamos na lista
                    lista.add(next);
                }

            }

        }

        //A lista contem somente os caracteres que não se repetem, em ordem.
        if (lista.size() > 0) {
            System.out.print(lista.get(0));
        } else {
            System.out.print("Todos os caracteres se repetem!");
        }

    }

}

/**
 * Classe que implementa a interface dada.
 */
class MyStream implements Stream {

    char[] str;
    int posAtual;

    public MyStream(String str) {
        this.str = str.toCharArray();
        this.posAtual = 0;
    }

    @Override
    public char getNext() {
        posAtual++;
        return str[posAtual-1];
    }

    @Override
    public boolean hasNext() {
        return str.length > posAtual;
    }
}

/**
 * Interface disponibilizada
 */
interface Stream {

    public char getNext();
    public boolean hasNext();

}
import java.util.Scanner;
import java.util.regex.Pattern;

public class Principal {

	public static void main(String[] args) {

		LerArquivo leitura = new LerArquivo();
		Scanner scan = new Scanner(System.in);
		String linha = new String();
		KNN knn = new KNN();

		String path = "..\\data.txt";
		String path2 = "..\\iris.data";

		// leitura.leitor(path);

		/*
		 * for(String[] s : leitura.leitor(path2)) { leitura.testaFloat(s); }
		 */

		System.out.print("Entre com valores em float (?,?,?,? ...): ");
		linha = scan.nextLine();
		String valores[] = linha.split(Pattern.quote(","));

		leitura.testaFloat(valores);

		/*
		 * System.out.println(valores.length);
		 * System.out.println(leitura.leitor(path2).get(1).length);
		 */

		String classe = knn.classify(leitura.leitor(path2), 5, valores);

		System.out.println(classe);

	}

}

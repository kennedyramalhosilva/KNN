import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class LerArquivo {

	public static LinkedList<String[]> leitor(String path) {
		FileReader file;
		LinkedList<String[]> dataset = new LinkedList<>();
		try {
			file = new FileReader(path);

			BufferedReader reader = new BufferedReader(file);

			String line = reader.readLine();

			String atributos[] = line.split(Pattern.quote(","));
			line = reader.readLine();
			
			while (true) {
				if (line != null) {

					String dados[] = line.split(Pattern.quote(","));
					//dados[dados.length - 1] = null;
					
					dataset.add(dados);

				} else
					break;
				line = reader.readLine();
			}

			/*for (int i = 0; i < dataset.size() - 1; i++) {
				for (int j = 0; j < dataset.get(i).length; j++) {
					System.out.print(dataset.get(i)[j] + ",");
				}
				System.out.println("\n");
			}*/

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataset;
	}

	public static void testaFloat(String[] dados) {

		try {

			for (int i = 0; i < dados.length - 1; i++) {

				Float.parseFloat(dados[i]);
			}

			System.out.println("Todos dados desta linha podem ser convertidos para float.\n");

		} catch (NumberFormatException e) {

			System.out.println("Algum dado não pode ser convertido pra float.\n");

		}

	}

}

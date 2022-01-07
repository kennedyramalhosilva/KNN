import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class KNN {
	
	/*public static float euclidianDistance(String[] currentReg, String[] target) {

		float distancia = 0;

		for (int i = 0; i < target.length; i++) {
			distancia += Math.pow(Float.parseFloat(currentReg[i]) - Float.parseFloat(target[i]), 2);
		}

		distancia = (float) Math.pow(distancia, 0.5);

		return distancia;

	}*/
	
	public static double euclidianDistance (String [] currentReg, String [] target) {
        return euclidianDistance(currentReg, target, 0, 0);
    }
	
	public static double euclidianDistance(String[] currentReg, String[] target, int indice, double soma) {

		if (!currentReg[indice].isEmpty() && !target[indice].isEmpty()) {

			soma += Math.pow(Float.parseFloat(currentReg[indice]) - Float.parseFloat(target[indice]), 2);

			indice++;

			if (indice < target.length) {
				return euclidianDistance(currentReg, target, indice, soma);
			}

			return Math.pow(soma, 0.5);

		}
		return 0;

	}
	
	public static String classify (LinkedList<String[]> dataSet, int k, String [] target) {
		
		MapaLista dict = new MapaLista();
		ShellSort ordenar = new ShellSort();
		String [] strings = new String[k];
		
		if(k<=0) k = 1;
		
		if(dataSet.size() == 0) return null;
		
		for(String[] s : dataSet) {
			dict.adicionar(dataSet.indexOf(s), euclidianDistance(s, target));
		}
		
		ordenar.sort(dict);
		
		int v[] = new int[k];
		
		for(int i = 0; i < dict.getAssociacoes().size(); i++) {
			if(i < k) {
				v[i] = dict.getAssociacoes().get(i).getIndiceDataSet();
				//strings.add(i, dataSet.get(v[i]));
				strings[i] = dataSet.get(v[i])[dataSet.get(v[i]).length - 1];
			}
		}
		
		MapaClasses mapa = new MapaClasses();
		//LinkedList<String> listaClasses = selecionaClasses(dataSet); 
		
		/*for(String[] s : strings) {
			
			if(listaClasses.contains(s[s.length-1])) {
				mapa.adicionar(listaClasses.indexOf(s[s.length-1]));
			} 	
		}*/
		
		for(int i = 0; i < strings.length; i++) {
			if(mapa.verificaChave(strings[i])) {
				mapa.criarClasse(strings[i]);
			} else {
				mapa.adicionar(strings[i]);
			}
		}
		
		return mapa.verificaQtde();
	}
	
	/*public static LinkedList<String> selecionaClasses (LinkedList<String[]> dataSet) {
		LinkedList<String> classes = new LinkedList<String>();
		String classe = new String();
		boolean x = false;
		
		for(String[] s : dataSet) {
			classe = s[s.length-1];
			if(!classes.contains(classe)) classes.add(classe);
		}
		return classes;
	}*/
	
	
	/*public static void main(String [] args) {
		
		KNN k = new KNN();
		
		String current = "3,4,5";
		String target = "1,2,3";
		
		String currentReg[] = current.split(Pattern.quote(","));
		String target1[] = target.split(Pattern.quote(","));
		
		System.out.println(k.classify(currentReg, target1));
	}*/
		
}

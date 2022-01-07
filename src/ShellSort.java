public class ShellSort {

	public static void sort(MapaLista dict) {
		int intervalo = dict.getTamanho() / 2;
		while (intervalo > 0) {
			for (int proximaPos = intervalo; proximaPos < dict.getTamanho(); proximaPos++)
				insert(dict, proximaPos, intervalo);
			intervalo = (int) (intervalo / 2);
		}
	}

	private static void insert(MapaLista dict, int proximaPos, int intervalo) {
		double proximoVal = dict.getAssociacoes().get(proximaPos).getDistancia();
		int proximoInd = dict.getAssociacoes().get(proximaPos).getIndiceDataSet();
		
		while ((proximaPos > intervalo - 1) && (proximoVal < dict.getAssociacoes().get(proximaPos - intervalo).getDistancia())) {
			
			dict.getAssociacoes().get(proximaPos).setDistancia(dict.getAssociacoes().get(proximaPos-intervalo).getDistancia());
			dict.getAssociacoes().get(proximaPos).setIndiceDataSet(dict.getAssociacoes().get(proximaPos-intervalo).getIndiceDataSet());
			
			proximaPos -= intervalo;
		}
		dict.getAssociacoes().get(proximaPos).setDistancia(proximoVal);
		dict.getAssociacoes().get(proximaPos).setIndiceDataSet(proximoInd);
	}
}

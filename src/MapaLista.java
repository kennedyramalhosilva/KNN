import java.util.ArrayList;
import java.util.List;

public class MapaLista {
	
	private List<Associacao> associacoes = new ArrayList<Associacao>();
	
	private int tamanho = 0;
	
	public void adicionar( int indiceDataSet, double distancia){
		Associacao a = new Associacao();
		a.setIndiceDataSet(indiceDataSet);
		a.setDistancia(distancia);
		associacoes.add(a);
		this.setTamanho(this.getTamanho() + 1);
	}
	public void remover(int indiceDataSet){
		for(Associacao a: associacoes) {
			if(a.getIndiceDataSet() == indiceDataSet) associacoes.remove(a);
		}
	}
	public List<Associacao> getAssociacoes() {
		return associacoes;
	}
	public void setAssociacoes(List<Associacao> associacoes) {
		this.associacoes = associacoes;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}

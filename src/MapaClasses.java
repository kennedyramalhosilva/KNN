import java.util.ArrayList;
import java.util.List;

public class MapaClasses {
	
	private List<AssociacaoClasse> associacoes = new ArrayList<AssociacaoClasse>();
	
	private int tamanho = 0;
	
	public void criarClasse(String classe){
		AssociacaoClasse a = new AssociacaoClasse();
		a.setClasse(classe);
		a.setQtde(1);
		associacoes.add(a);
		this.setTamanho(this.getTamanho() + 1);
	}
	
	public void adicionar(String classe){
		for(AssociacaoClasse a : this.associacoes) {
			if(a.getClasse().equals(classe)) a.setQtde(a.getQtde()+1);;
		}
	}
	
	public void remover(String classe){
		for(AssociacaoClasse a: associacoes) {
			if(a.getClasse() == classe) associacoes.remove(a);
		}
	}
	
	public List<AssociacaoClasse> getAssociacoes() {
		return associacoes;
	}
	public void setAssociacoes(List<AssociacaoClasse> associacoes) {
		this.associacoes = associacoes;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public boolean verificaChave (String s) {
		
		for(AssociacaoClasse a : this.associacoes) {
			if(a.getClasse().equals(s)) return false;
		}
		
		return true;
	}
	
	public String verificaQtde () {
		int qtde = 0;
		String classe = null;
		for(AssociacaoClasse a : this.associacoes) {
			if(a.getQtde() > qtde) {
				qtde = a.getQtde();
				classe = a.getClasse();
			} 
		}
		return classe;
	}
	
}

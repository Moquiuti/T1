package projetoFinal.Util;

import java.util.ArrayList;
import java.util.List;
import projetoFinal.Classes.Produto;

public class GerenciadorProduto {
	static List<Produto> produtos =  new ArrayList<Produto>(); 
	
	public void salvar(Produto produto) {
		produtos.add(produto);
	}
	
	public void excluir (int posicao){
		produtos.remove(posicao);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
}

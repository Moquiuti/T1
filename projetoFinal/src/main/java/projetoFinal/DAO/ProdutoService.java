package projetoFinal.DAO;

import java.util.List;

import projetoFinal.Classes.Produto;
import projetoFinal.Util.ServiceException;

public class ProdutoService {
	private ProdutoDAO produtoDAO;
	
	public ProdutoService() {
		produtoDAO = new ProdutoDAO();
	}
	
	public void salvar(Produto produto) throws ServiceException{
		if (produto.getDescricao().isEmpty()){
			throw new ServiceException("Verifique o campo Descrição!");
		}
		
		if (produto.getValor().isEmpty()){
			throw new ServiceException("Verifique o campo Valor!");
		}
		
		produtoDAO.salvar(produto);
		
	}
	
	public void excluir(Integer id) {
		produtoDAO.excluir(id);
	}
	
	public Produto buscarPorId(Integer id) {
		return produtoDAO.buscarPorId(id);
	}
	
	public List<Produto> buscarTodos() {
		return produtoDAO.buscarTodos();
	}
}

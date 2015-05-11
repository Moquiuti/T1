package projetoFinal.DAO;

import java.util.List;

import projetoFinal.Classes.Pedido;
import projetoFinal.Util.ServiceException;

public class PedidoService {
private PedidoDAO pedidoDAO;
	
	public PedidoService() {
		pedidoDAO = new PedidoDAO();
	}
	
	public void salvar(Pedido pedido) throws ServiceException{
		if (pedido.getCeriominal().isEmpty()){
			throw new ServiceException("Verifique o campo Cerimonial!");
		}
		if (pedido.getEnderecoEvento().isEmpty()){
			throw new ServiceException("Verifique o campo Evento!");
		}
		if (pedido.getHoraEvento().isEmpty()){
			throw new ServiceException("Verifique o campo Pedido!");
		}
		if (pedido.getIndicacao().isEmpty()){
			throw new ServiceException("Verifique o campo Indicação!");
		}
		if (pedido.getLocalEvento().isEmpty()){
			throw new ServiceException("Verifique o campo Local Evento!");
		}
		if (pedido.getObs().isEmpty()){
			throw new ServiceException("Verifique o campo Observação!");
		}
		if (pedido.getOrigemPedido().isEmpty()){
			throw new ServiceException("Verifique o campo Origem Pedido!");
		}
		pedidoDAO.salvar(pedido);
		
	}
	
	public void excluir(Integer id) {
		pedidoDAO.excluir(id);
	}
	
	public Pedido buscarPorId(Integer id) {
		return pedidoDAO.buscarPorId(id);
	}
	
	public List<Pedido> buscarTodos() {
		return pedidoDAO.buscarTodos();
	}
}

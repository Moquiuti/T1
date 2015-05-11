package projetoFinal.DAO;

import java.util.List;

import projetoFinal.Classes.Evento;
import projetoFinal.Util.ServiceException;

public class EventoService {
private EventoDAO eventoDAO;
	
	public EventoService() {
		eventoDAO = new EventoDAO();
	}
	
	public void salvar(Evento evento) throws ServiceException{
		System.out.println("antes do if na classe salvar"+evento.getDescricao());
		if (evento.getDescricao().isEmpty()){
			System.out.println("depois do if na classe salvar"+evento.getDescricao());
			throw new ServiceException("Verifique o campo Descrição!");
		}
		
		eventoDAO.salvar(evento);
		
	}
	
	public void excluir(Integer id) {
		eventoDAO.excluir(id);
	}
	
	public Evento buscarPorId(Integer id) {
		return eventoDAO.buscarPorId(id);
	}
	
	public List<Evento> buscarTodos() {
		return eventoDAO.buscarTodos();
	}

}

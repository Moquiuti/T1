package projetoFinal.DAO;

import java.util.List;

import projetoFinal.Classes.Cliente;
import projetoFinal.Util.ServiceException;



public class ClienteService {
	private ClienteDAO clienteDAO;

    public ClienteService() {
        clienteDAO = new ClienteDAO();
    }

    public void salvar(Cliente cliente) throws ServiceException {

        if (cliente.getNome().isEmpty()) {
            throw new ServiceException("Verifique o campo nome!");
        }
        
        if(cliente.getEmail().isEmpty()){
        	throw new ServiceException("Verifique o campo email!");
        }
        if (cliente.getTelefone().isEmpty()) {
            throw new ServiceException("Verifique o campo telefone!");
        }

        clienteDAO.salvar(cliente);

    }

    public void excluir(Integer id) {
        clienteDAO.excluir(id);
    }

    public Cliente buscarPorId(Integer id) {
        return clienteDAO.buscarPorId(id);
    }

    public List<Cliente> buscarTodos() {
            return clienteDAO.buscarTodos();
    }
}


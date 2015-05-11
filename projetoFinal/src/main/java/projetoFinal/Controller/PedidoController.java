package projetoFinal.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetoFinal.Classes.Cliente;
import projetoFinal.Classes.Evento;
import projetoFinal.Classes.Pedido;
import projetoFinal.DAO.ClienteService;
import projetoFinal.DAO.EventoService;
import projetoFinal.DAO.PedidoService;
import projetoFinal.Util.ServiceException;

@WebServlet("/PedidoController")
public class PedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PedidoService pedidoService = new PedidoService();
	EventoService eventoService = new EventoService();
	ClienteService clienteService = new ClienteService();
	Cliente cliente = new Cliente();
	Evento evento = new Evento();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		System.out.println(acao);
		
		if (acao==null || acao==""){
			Pedido cliente = new Pedido();
			cliente.setId(0);
			cliente.setCeriominal("");
			cliente.setCliente(new Cliente());
			cliente.setDataEvento("");
			cliente.setDataPedido("");
			cliente.setEnderecoEvento("");
			cliente.setHoraEvento("");
			cliente.setIndicacao("");
			cliente.setLocalEvento("");
			cliente.setObs("");
			cliente.setOrigemPedido("");
			cliente.setTipoEvento(new Evento());
			
			req.setAttribute("pdo", cliente);
			req.getRequestDispatcher("TelaPedidoTeste.jsp").forward(req, resp);
			
		}else if (acao.equals("lis")) {
			// Pegar a lista

			List<Pedido> pedidos = pedidoService.buscarTodos();

			// Adiciona a lista no request como atributo

			req.setAttribute("pdo", pedidos);

			// Levar para o JSP
			RequestDispatcher view = req.getRequestDispatcher("pedidos.jsp");
			view.forward(req, resp);
		} else if (acao.equals("exc")) {
			String id = req.getParameter("id");
			pedidoService.excluir(Integer.parseInt(id));
			resp.getWriter()
					.print("<script> window.alert('Excluido Sucesso!'); location.href='PedidoController?acao=lis'; </script>");

		} else if (acao.equals("edit")) {
			String id = req.getParameter("id");
			Pedido clienteBuscado = pedidoService.buscarPorId(Integer
					.parseInt(id));

			req.setAttribute("pdo", clienteBuscado);
			req.getRequestDispatcher("TelaPedidoTeste.jsp").forward(req, resp);
		}	else if(acao.equals("prepara")){
			
			List<Pedido> pedidos = pedidoService.buscarTodos();
			List<Evento> eventos = eventoService.buscarTodos();
			List<Cliente> clientes = clienteService.buscarTodos();
			
			Pedido pedido = new Pedido();
			
			req.setAttribute("pdo", pedido);			
			req.setAttribute("listacli", clientes);
			req.setAttribute("listaeto", eventos);
			req.setAttribute("listapdo", pedidos);
			req.getRequestDispatcher("TelaPedidoTeste.jsp").forward(req, resp);
		}
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		
		
		String id = req.getParameter("id");
		String cerimonial = req.getParameter("cerimonial");
		String idcliente = req.getParameter("cliente");
		cliente = clienteService.buscarPorId(Integer.parseInt(idcliente));
		String dataEvento = req.getParameter("dataevento");	
		String dataPedido = req.getParameter("datapedido");
		String enderecoEvento = req.getParameter("enderecoevento");
		String horaEvento = req.getParameter("horaevento");
		String indicacao = req.getParameter("indicacao");
		String localEvento = req.getParameter("localevento");
		String obs = req.getParameter("obs");
		String origemPedido = req.getParameter("origempedido");
		int tipoEvento = Integer.parseInt(req.getParameter("evento"));
		evento = eventoService.buscarPorId(tipoEvento);
		
		Pedido pedido = new Pedido();
		
		if (id != null && id != "" && id != "0") {
			pedido.setId(Integer.parseInt(id));
		}
		pedido.setCeriominal(cerimonial);
		pedido.setCliente(cliente);
		pedido.setDataEvento(dataEvento);
		pedido.setDataPedido(dataPedido);
		pedido.setEnderecoEvento(enderecoEvento);
		pedido.setHoraEvento(horaEvento);
		pedido.setIndicacao(indicacao);
		pedido.setLocalEvento(localEvento);
		pedido.setObs(obs);
		pedido.setOrigemPedido(origemPedido);
		pedido.setTipoEvento(evento);
		
		try {
			pedidoService.salvar(pedido);

			resp.getWriter()
					.print("<script> window.alert('Salvo Sucesso!'); location.href='PedidoController?acao=lis'; </script>");

		} catch (Exception e) {

			resp.getWriter()
					.print("<script> window.alert('"
							+ e.getMessage()
							+ "'); location.href='menuprincipal.jsp'; </script>");

			e.printStackTrace();
		}

	}
}
	


package projetoFinal.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetoFinal.Classes.Cliente;
import projetoFinal.DAO.ClienteService;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet({ "/ClienteController", "/ClienteController.do", "/ClienteServlet",
		"/ClienteControlador", "/ClienteControle" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClienteService clienteService = new ClienteService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = req.getParameter("acao");
		System.out.println(acao);

		if (acao == null || acao == "") {
			Cliente cliente = new Cliente();
			cliente.setTelefone("");
			cliente.setNome("");
			cliente.setEmail("");
			cliente.setId(0);
			req.setAttribute("cli", cliente);
			req.getRequestDispatcher("clientes.jsp").forward(req, resp);
		}
		if (acao.equals("lis")) {
			// Pegar a lista
			List<Cliente> clientes = clienteService.buscarTodos();
//			for (Cliente c : clientes) {
//				System.out.println("chegou aqui");
//				c.getNome();
//			}
			// Adiciona a lista no request como atributo

			req.setAttribute("cli", clientes);

			// Levar para o JSP
			RequestDispatcher view = req.getRequestDispatcher("clientes.jsp");
			view.forward(req, resp);
		} else if (acao.equals("exc")) {
			String id = req.getParameter("id");
			clienteService.excluir(Integer.parseInt(id));
			resp.getWriter()
					.print("<script> window.alert('Excluido Sucesso!'); location.href='ClienteController?acao=lis'; </script>");

		} else if (acao.equals("edit")) {
			String id = req.getParameter("id");
			Cliente clienteBuscado = clienteService.buscarPorId(Integer
					.parseInt(id));

			req.setAttribute("cli", clienteBuscado);
			req.getRequestDispatcher("cliente.jsp").forward(req, resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");

		// instanciando uma classe cliente
		Cliente cliente = new Cliente();

		// recebendo os valores da tela para variaveis comuns
		String id = req.getParameter("id");

		// esse if foi criado para atribuir valor 0 ao id, cambiarra feita para
		// funcionar
		if (id.equals("")) {
			id = "0";
		}

		// recebendo os valor da tela para variaveis comuns
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");

		// ele sempre vai entrar nesse if quando o cliente for a cadastrar
		// pois se os valores vierem preenchidos que no caso sempre virao e o id
		// vier vazio ele tera o valor 0 por padrão do codigo feito por mim para
		// que posso funcionar
		// temporariamente ficara assim até a busca da solução
		if (id != null && id != "" && id == "0") {
			// cliente.setId(Integer.parseInt(id));
			// }

			// Atibruindo as variaveis comuns aos valores da classe criada
			cliente.setNome(nome);
			cliente.setEmail(email);
			cliente.setTelefone(telefone);
		} else if (id != null && id != "" && id != "0") {
			int temp = Integer.parseInt(id);
			System.out.println(temp);
			clienteService.excluir(Integer.parseInt(id));
			cliente.setId(temp);
			cliente.setNome(nome);
			cliente.setEmail(email);
			cliente.setTelefone(telefone);
		}

		try {
			// Chama-se o metodo salvar da classe de serviços do cliente
			// passando a classe cliente
			clienteService.salvar(cliente);

			// caso tudo corra corretamente é disparada esse alert na tela como
			// operação realizada com sucesso
			resp.getWriter()
					.print("<script> window.alert('Salvo Sucesso!'); location.href='ClienteController?acao=lis'; </script>");

		} catch (Exception e) {
			// TODO: handle exception
			// caso não é disparado essa exceção na tela configurado com o nome
			// da mesma
			resp.getWriter()
					.print("<script> window.alert('"
							+ e.getMessage()
							+ "'); location.href='menuprincipal.jsp'; </script>");

			e.printStackTrace();
		}
	}
}

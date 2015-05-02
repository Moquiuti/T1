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
import projetoFinal.Classes.Produto;
import projetoFinal.DAO.ProdutoService;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProdutoService produtoService = new ProdutoService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String acao = req.getParameter("acao");
		System.out.println(acao);

		if (acao == null || acao == "") {
			Produto produto = new Produto();
			produto.setId(0);
			produto.setDescricao("");
			produto.setValor("");
			req.setAttribute("pro", produto);
			req.getRequestDispatcher("produtos.jsp").forward(req, resp);
		}
		if (acao.equals("lis")) {
			// Pegar a lista
			List<Produto> produtos = produtoService.buscarTodos();
			// for (Cliente c : clientes) {
			// System.out.println("chegou aqui");
			// c.getNome();
			// }
			// Adiciona a lista no request como atributo

			req.setAttribute("pro", produtos);

			// Levar para o JSP
			RequestDispatcher view = req.getRequestDispatcher("produtos.jsp");
			view.forward(req, resp);
		} else if (acao.equals("exc")) {
			String id = req.getParameter("id");
			produtoService.excluir(Integer.parseInt(id));
			resp.getWriter()
					.print("<script> window.alert('Excluido Sucesso!'); location.href='ProdutoController?acao=lis'; </script>");

		} else if (acao.equals("edit")) {
			String id = req.getParameter("id");
			Produto produtoBuscado = produtoService.buscarPorId(Integer.parseInt(id));
			req.setAttribute("pro", produtoBuscado);
			req.getRequestDispatcher("produto.jsp").forward(req, resp);
			
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		// instanciando uma classe cliente
		Produto produto = new Produto();

		// recebendo os valores da tela para variaveis comuns
		String id = req.getParameter("id");

		// esse if foi criado para atribuir valor 0 ao id, cambiarra feita para
		// funcionar
		if (id.equals("")) {
			id = "0";
		}

		// recebendo os valor da tela para variaveis comuns
		String descricao = req.getParameter("descricao");
		String valor = req.getParameter("valor");

		// ele sempre vai entrar nesse if quando o cliente for a cadastrar
		// pois se os valores vierem preenchidos que no caso sempre virao e o id
		// vier vazio ele tera o valor 0 por padrão do codigo feito por mim para
		// que posso funcionar
		// temporariamente ficara assim até a busca da solução
		if (id != null && id != "" && id == "0") {
			// cliente.setId(Integer.parseInt(id));
			// }

			// Atibruindo as variaveis comuns aos valores da classe criada
			produto.setDescricao(descricao);
			produto.setValor(valor);

		} else if (id != null && id != "" && id != "0") {
			int temp = Integer.parseInt(id);
			System.out.println(temp);
			produtoService.excluir(temp);
			produto.setId(temp);
			produto.setDescricao(descricao);
			produto.setValor(valor);
		}

		try {
			// Chama-se o metodo salvar da classe de serviços do produto
			// passando a classe produto
			produtoService.salvar(produto);

			// caso tudo corra corretamente é disparada esse alert na tela como
			// operação realizada com sucesso
			resp.getWriter()
					.print("<script> window.alert('Salvo Sucesso!'); location.href='ProdutoController?acao=lis'; </script>");

		} catch (Exception e) {
			// TODO: handle exception
			// caso não é disparado essa exceção na tela configurado com o nome
			// da mesma
			resp.getWriter()
					.print("<script> window.alert('"
							+ e.getMessage()
							+ "'); location.href='menuprincipal.html'; </script>");
			e.printStackTrace();
		}

	}

}

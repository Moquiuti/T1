package projetoFinal.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetoFinal.Classes.Evento;
import projetoFinal.DAO.EventoService;

@WebServlet({ "/EventoController", "/EventoServlet", "/EventoController.do" })
public class EventoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EventoService eventoService = new EventoService();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		String acao = req.getParameter("acao");
		System.out.println(acao);

		if (acao == null || acao == "") {
			Evento evento = new Evento();
			evento.setId(0);
			evento.setDescricao("");
			req.setAttribute("eto", evento);
			req.getRequestDispatcher("eventos.jsp").forward(req, resp);
		}
		if (acao.equals("lis")) {
			// Pegar a lista
			List<Evento> eventos = eventoService.buscarTodos();
			 for (Evento e : eventos) {
//			 System.out.println("chegou aqui");
			 e.getDescricao();
			 }
//			 Adiciona a lista no request como atributo

			req.setAttribute("eto", eventos);

			// Levar para o JSP
			RequestDispatcher view = req.getRequestDispatcher("eventos.jsp");
			view.forward(req, resp);
		} else if (acao.equals("exc")) {
			String id = req.getParameter("id");
			eventoService.excluir(Integer.parseInt(id));
			resp.getWriter()
					.print("<script> window.alert('Excluido Sucesso!'); location.href='EventoController?acao=lis'; </script>");

		} else if (acao.equals("edit")) {
			String id = req.getParameter("id");
			System.out.println(id);
			Evento eventoBuscado = eventoService.buscarPorId(Integer
					.parseInt(id));
			System.out.println(eventoBuscado.getDescricao());
			req.setAttribute("eto", eventoBuscado);
			req.getRequestDispatcher("evento.jsp").forward(req, resp);

		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		// instanciando uma classe cliente
		Evento evento = new Evento();
		// recebendo os valores da tela para variaveis comuns
		String id = req.getParameter("id");

		// esse if foi criado para atribuir valor 0 ao id, cambiarra feita para
		// funcionar
		if (id.equals("")) {
			id = "0";
		}

		// recebendo os valor da tela para variaveis comuns
		String descricao = req.getParameter("descricao");

		// ele sempre vai entrar nesse if quando o cliente for a cadastrar
		// pois se os valores vierem preenchidos que no caso sempre virao e o id
		// vier vazio ele tera o valor 0 por padrão do codigo feito por mim para
		// que posso funcionar
		// temporariamente ficara assim até a busca da solução
		if (id != null && id != "" && id == "0") {
			// cliente.setId(Integer.parseInt(id));
			// }

			// Atibruindo as variaveis comuns aos valores da classe criada
			evento.setDescricao(descricao);

		} else if (id != null && id != "" && id != "0") {
			int temp = Integer.parseInt(id);
			System.out.println(temp);
			eventoService.excluir(temp);
			evento.setId(temp);
			evento.setDescricao(descricao);
		}

		try {
			// Chama-se o metodo salvar da classe de serviços do produto
			// passando a classe produto
			System.out.println("dentro do try classe evento controller"+evento.getDescricao());
			eventoService.salvar(evento);

			// caso tudo corra corretamente é disparada esse alert na tela como
			// operação realizada com sucesso
			resp.getWriter()
					.print("<script> window.alert('Salvo Sucesso!'); location.href='EventoController?acao=lis'; </script>");

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

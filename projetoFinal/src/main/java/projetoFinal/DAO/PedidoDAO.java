package projetoFinal.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import projetoFinal.Classes.Cliente;
import projetoFinal.Classes.Evento;
import projetoFinal.Classes.Pedido;
import projetoFinal.Util.ConexaoUtil;

public class PedidoDAO {
Connection conexao;
ClienteService clienteService = new ClienteService();
EventoService eventoService = new EventoService();
	
	public PedidoDAO(){
	conexao = ConexaoUtil.getConnection();
	}

	public Pedido buscarPorId(Integer id) {
		String sql = "select * from pedido where idpedido=?";
		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setInt(1, id);
			//Armazenamento Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();
			if (resultado.next()) {
				//Instancia do Produto
				Pedido pdo = new Pedido();
				
				//Atribuindo dados do resultado no Pedido
				pdo.setId(id);
				Cliente cliente =clienteService.buscarPorId(Integer.parseInt(resultado.getString("idcliente")));
				pdo.setCliente(cliente);			
				pdo.setOrigemPedido(resultado.getString("origempedido"));
				pdo.setDataPedido(resultado.getString("datapedido"));
				pdo.setCeriominal(resultado.getString("cerimonial"));
				pdo.setDataEvento(resultado.getString("dataevento"));
				pdo.setHoraEvento(resultado.getString("horaevento"));
				pdo.setIndicacao(resultado.getString("indicacao"));
				pdo.setLocalEvento(resultado.getString("localevento"));
				pdo.setLocalEvento(resultado.getString("enderecoevento"));
				pdo.setObs(resultado.getString("obs"));
				Evento evento = eventoService.buscarPorId(Integer.parseInt(resultado.getString("idtipoevento")));
				pdo.setTipoEvento(evento);		
				preparadorSQL.close();
				return pdo;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			
			Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public List<Pedido> buscarTodos() {
		  String sql = "select * from pedido order by idpedido";
	        try {
	            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
	            //Armazenando Resultado da consulta
	            ResultSet resultado = preparadorSQL.executeQuery();
	            List<Pedido> lista = new ArrayList<>();
	            
	            while (resultado.next()) {
	                //Instancia de cliente
	                Pedido pdo = new Pedido();

	                //Atribuindo dados do resultado no objeto cliente
	                pdo.setId(Integer.parseInt(resultado.getString("idpedido")));
	                Cliente cliente =clienteService.buscarPorId(Integer.parseInt(resultado.getString("idcliente")));
					pdo.setCliente(cliente);
					pdo.setOrigemPedido(resultado.getString("origempedido"));
					pdo.setDataPedido(resultado.getString("datapedido"));
					pdo.setCeriominal(resultado.getString("cerimonial"));
					pdo.setDataEvento(resultado.getString("dataevento"));
					pdo.setHoraEvento(resultado.getString("horaevento"));
					pdo.setIndicacao(resultado.getString("indicacao"));
					pdo.setLocalEvento(resultado.getString("localevento"));
					pdo.setLocalEvento(resultado.getString("enderecoevento"));
					pdo.setObs(resultado.getString("obs"));
					Evento evento = eventoService.buscarPorId(Integer.parseInt(resultado.getString("idtipoevento")));
					pdo.setTipoEvento(evento);
	                //Adicionando cliente na lista
	                lista.add(pdo);
	            }
	            
	            preparadorSQL.close();
	            return lista;
	        } catch (SQLException ex) {
//	        	System.out.println("Chegou aqui");
	        	Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }

	}

	public void salvar(Pedido pedido) {
		cadastrar(pedido);
		// TODO Auto-generated method stub
		
	}

	private void cadastrar(Pedido pedido) {
		// TODO Auto-generated method stub
		String sql = "insert  into pedido (idcliente,origempedido,datapedido,cerimonial,dataevento,horaevento,indicacao,localevento,enderecoevento,obs,idtipoevento) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setObject(1, pedido.getCliente());
            preparadorSQL.setString(2, pedido.getOrigemPedido());
            preparadorSQL.setString(3, pedido.getDataPedido());
            preparadorSQL.setString(4, pedido.getCeriominal());
            preparadorSQL.setString(5, pedido.getDataEvento());
            preparadorSQL.setString(6, pedido.getHoraEvento());
            preparadorSQL.setString(7, pedido.getIndicacao());
            preparadorSQL.setString(8, pedido.getLocalEvento());
            preparadorSQL.setString(9, pedido.getEnderecoEvento());
            preparadorSQL.setString(10,pedido.getObs());
            preparadorSQL.setObject(11,pedido.getTipoEvento());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
    public void alterar(Pedido pedido) {
    	
        String sql = "update pedido set idpedido=?, idcliente=?, origempedido=?, datapedido=?, cerimonial=?, dataevento=?, horaevento=?, indicacao=?, localevento=?, enderecoevento=?, obs=?, idtipoevento=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, pedido.getId());
            preparadorSQL.setObject(2, pedido.getCliente());
            preparadorSQL.setString(3, pedido.getOrigemPedido());
            preparadorSQL.setString(4,pedido.getDataPedido());
            preparadorSQL.setString(5, pedido.getCeriominal());
            preparadorSQL.setString(6, pedido.getDataEvento());
            preparadorSQL.setString(7, pedido.getHoraEvento());
            preparadorSQL.setString(8, pedido.getIndicacao());
            preparadorSQL.setString(9, pedido.getLocalEvento());
            preparadorSQL.setString(10, pedido.getEnderecoEvento());
            preparadorSQL.setString(11,pedido.getObs());
            preparadorSQL.setObject(12,pedido.getTipoEvento());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
	public void excluir(Integer id) {
        String sql = "delete from pedido where idpedido=?";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
}

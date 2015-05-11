package projetoFinal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import projetoFinal.Classes.Evento;
import projetoFinal.Classes.Produto;
import projetoFinal.Util.ConexaoUtil;

public class EventoDAO {
	Connection conexao;
	
	public EventoDAO(){
		conexao = ConexaoUtil.getConnection();
		}
	
	public Evento buscarPorId(Integer id) {
		String sql = "select * from tipoevento where idtipoevento=?";
		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setInt(1, id);
			//Armazenamento Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();
			if (resultado.next()) {
				//Instancia do Produto
				Evento eto = new Evento();
				
				//Atribuindo dados do resultado no Produto
				eto.setId(id);
				eto.setDescricao(resultado.getString("descricao"));
				preparadorSQL.close();
				System.out.println("Dentro do if no try no metodo bucar por id "+ eto.getDescricao());
				return eto;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public List<Evento> buscarTodos() {
		  String sql = "select * from tipoevento order by idtipoevento";
	        try {
	            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
	            //Armazenando Resultado da consulta
	            ResultSet resultado = preparadorSQL.executeQuery();
	            List<Evento> lista = new ArrayList<>();
	            while (resultado.next()) {
	                //Instancia de cliente
	                Evento eto = new Evento();

	                //Atribuindo dados do resultado no objeto cliente
	                eto.setId(resultado.getInt("idtipoevento"));
	                eto.setDescricao(resultado.getString("descricao"));
	                //Adicionando cliente na lista
	                lista.add(eto);
	            }
	            
	            preparadorSQL.close();
	            return lista;
	        } catch (SQLException ex) {
//	        	System.out.println("Chegou aqui");
	        	Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }

	}

	public void salvar(Evento evento) {
		cadastrar(evento);
		// TODO Auto-generated method stub
		
	}

	private void cadastrar(Evento evento) {
		// TODO Auto-generated method stub
		String sql = "insert  into tipoevento (descricao) values (?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, evento.getDescricao());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
    public void alterar(Evento evento) {
        String sql = "update tipoevento set descricao=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, evento.getId());
            preparadorSQL.setString(2, evento.getDescricao());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
	public void excluir(Integer id) {
        String sql = "delete from tipoevento where idtipoevento=?";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
	
	
}

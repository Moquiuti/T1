package projetoFinal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import projetoFinal.Classes.Produto;
import projetoFinal.Util.ConexaoUtil;

public class ProdutoDAO {
	Connection conexao;
	
	public ProdutoDAO(){
	conexao = ConexaoUtil.getConnection();
	}

	public Produto buscarPorId(Integer id) {
		String sql = "select * from produto where idproduto=?";
		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setInt(1, id);
			//Armazenamento Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();
			if (resultado.next()) {
				//Instancia do Produto
				Produto pro = new Produto();
				
				//Atribuindo dados do resultado no Produto
				pro.setId(id);
				pro.setDescricao(resultado.getString("descricao"));
				pro.setValor(resultado.getString("valor"));
				preparadorSQL.close();
				return pro;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public List<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Produto produto) {
		cadastrar(produto);
		// TODO Auto-generated method stub
		
	}

	private void cadastrar(Produto produto) {
		// TODO Auto-generated method stub
		String sql = "insert  into produto (descricao,valor) values (?,?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, produto.getDescricao());
            preparadorSQL.setString(2, produto.getValor());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void alterar(Produto produto) {
        String sql = "update produto set descricao=?, valor=? ";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, produto.getId());
            preparadorSQL.setString(2, produto.getDescricao());
            preparadorSQL.setString(3, produto.getValor());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

	public void excluir(Integer id) {

        String sql = "delete from cliente where idcliente=?";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
		
	}
	
	
}
	
	

package projetoFinal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import projetoFinal.Classes.Cliente;
import projetoFinal.Util.ConexaoUtil;


public class ClienteDAO {
	Connection conexao;

    public ClienteDAO() {
        conexao = ConexaoUtil.getConnection();
    }

    public Cliente buscarPorId(Integer id) {
        String sql = "select * from cliente where idcliente=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            if (resultado.next()) {
                //Instancia de cliente
                Cliente cli = new Cliente();

                //Atribuindo dados do resultado no objeto cliente
                cli.setId(id);
                cli.setNome(resultado.getString("nome"));
                cli.setEmail(resultado.getString("email"));
                cli.setTelefone(resultado.getString("telefone"));
                preparadorSQL.close();
                return cli;
            } else {
                return null;
            }
        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List<Cliente> buscarTodos() {

        String sql = "select * from cliente order by idcliente";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Cliente> lista = new ArrayList<>();
            while (resultado.next()) {
                //Instancia de cliente
                Cliente cli = new Cliente();

                //Atribuindo dados do resultado no objeto cliente
                cli.setId(resultado.getInt("idcliente"));
                cli.setNome(resultado.getString("nome"));
                cli.setEmail(resultado.getString("email"));
                cli.setTelefone(resultado.getString("telefone"));
                //Adicionando cliente na lista
                lista.add(cli);
            }
            
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {
//        	System.out.println("Chegou aqui");
        	Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void salvar(Cliente cliente) {
//        if (cliente.getId() == null) {
            cadastrar(cliente);
//        } else {
//            alterar(cliente);
//        }
    }

    public void cadastrar(Cliente cliente) {
        String sql = "insert  into cliente (nome,email,telefone) values (?,?,?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, cliente.getNome());
            preparadorSQL.setString(2, cliente.getEmail());
            preparadorSQL.setString(3, cliente.getTelefone());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar(Cliente cliente) {
        String sql = "update cliente set nome=?, email=?, telefone=? where idcliente=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, cliente.getNome());
            preparadorSQL.setString(2, cliente.getEmail());
            preparadorSQL.setString(3, cliente.getTelefone());
            preparadorSQL.setInt(4, cliente.getId());
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

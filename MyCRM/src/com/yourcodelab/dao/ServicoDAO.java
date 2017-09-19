package com.yourcodelab.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yourcodelab.model.Servico;

public class ServicoDAO extends GenericDAO{
	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO TBCLIENTE(serial,data,hora, "
			+ "descricaodefeito,"+ "valroconserto,status) VALUES (?, ?, ? , ?, ? , ? );";
	private String SQL_SELECT = "SELECT id, serial,data,hora, "
			+ "descricaodefeito,"+ "valroconserto,status FROM TBSERVICO;";
	public void inserir(Servico s){
		try {
			// Abrir conexão
			openConnection();
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, s.getSerial());
			ps.setString(2, s.getData());
			ps.setString(3, s.getHora());
			ps.setString(4, s.getDescricaodefeito());
			ps.setFloat(5, s.getValorconserto());
			ps.setString(6 , s.getStatus());
			// Executar o comando de INSERT, logo não se espera retorno
			ps.executeUpdate();
			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting");
		}
	}
	public List<Servico> listarTodos(){
		List<Servico> lista = new ArrayList<Servico>();
		try {
			// Abrir conexão
			openConnection();
			// Preparar comando de SELECT
			ps = connect.prepareStatement(SQL_SELECT);
			// Retorno da consulta com os dados no ResultSet
			ResultSet rs = ps.executeQuery();
			// Se houve retorno
			if(rs != null){
				while(rs.next()){
					// Para cada registro do ResultSet, instanciar um objeto Cliente
					Servico s = new Servico(rs.getInt("id"), rs.getString("serial"), 
							rs.getString("data"), rs.getString("hora"),
							rs.getString("descricaodefeito"),rs.getFloat("valorconserto"),
							rs.getString("status"));
					// Adicionar na lista de Clientes
					lista.add(s);
				}
			}
			
			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting");
		}
		// Se por acado não houve retorno do banco de dados, retorna
		return lista;
	}
}

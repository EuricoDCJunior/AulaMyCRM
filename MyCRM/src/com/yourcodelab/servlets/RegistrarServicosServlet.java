package com.yourcodelab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.asn1.isismtt.ocsp.RequestedCertificate;

import com.yourcodelab.controller.ClienteController;
import com.yourcodelab.controller.ServicoController;
import com.yourcodelab.model.Cliente;
import com.yourcodelab.model.Servico;

/**
 * Servlet implementation class InserirClienteServlet
 */
@WebServlet("/InserirClienteServlet")
public class RegistrarServicosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ServicoController control = new ServicoController();
		
		//Obter parãmetros do formulário
		String serial = request.getParameter("serial");
		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		String descricaodefeito = request.getParameter("descricaodefeito");
		String valorconserto = request.getParameter("valorconserto");
		String status = request.getParameter("status");
		
		
		//Instanciar objeto cliente, o limite precisa ser convertido de String para float
		Servico s = new Servico(new Integer(0), serial, data, hora, descricaodefeito , 
				Float.parseFloat(valorconserto) , status);
		
		//Invocar a camada de negócio
		control.inserirServico(s);
		
		//Obter a lista atualizada de Clientes
		List<Servico> lista = control.listarTodos();
		
		if(lista == null)
			lista = new ArrayList<Servico>();
		
		request.setAttribute("listaServicos", lista);
		
		String nextJSP = "/cliente/listarServico.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
	}

}

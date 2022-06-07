package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		usuario.setMatricula(Integer.parseInt(request.getParameter("matricula")));	
		usuario.setNome(request.getParameter("nome"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setModalidade(request.getParameter("modalidade"));
		
		try {
			usuariodao.update(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		response.getWriter().print("Usuário "+usuario.getNome()+" atualizado com sucesso!");
		response.sendRedirect("Consultar.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Usuario usuario = new Usuario();
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setModalidade(request.getParameter("modalidade"));
		
		try {
			usuariodao.create(usuario);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

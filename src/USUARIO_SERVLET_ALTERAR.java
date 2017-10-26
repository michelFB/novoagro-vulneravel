import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.USUARIODAO;
import projeto.USUARIOMODEL;

@WebServlet("/alteraUsuario")
public class USUARIO_SERVLET_ALTERAR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
								HttpServletResponse response)	throws IOException, ServletException {
		String msg;
			
		// pegando os par�metros do request
		String IDusuario = request.getParameter("IDusuario");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String login = request.getParameter("login");
		String tipo = request.getParameter("tipo");
		
		// monta um objeto Usuario
		USUARIOMODEL usuario = new USUARIOMODEL();
		usuario.setIDusuario(IDusuario);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setLogin(login);
		usuario.setTipo(tipo);
		System.out.println(IDusuario);
		
		// salva o contato
		USUARIODAO dao = new USUARIODAO();
		boolean res = dao.altera(usuario);
		if(res==true){
	 		msg = "Usu�rio " + IDusuario + " alterado com sucesso!";
	 	 }else{
	 		msg = "N�o foi possivel alterar registro!";
	 	 }	
		// Define parametros para a sess�o
        request.setAttribute("msg", msg);
		// Chama pagina de resposta
        getServletContext().getRequestDispatcher("/UsuarioListar.jsp").forward(request, response); 
        
		
		}
}
		



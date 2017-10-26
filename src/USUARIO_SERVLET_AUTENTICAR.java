import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.FormWriter;
import projeto.USUARIODAO;
import projeto.USUARIOMODEL;


@WebServlet("/autenticacao")
public class USUARIO_SERVLET_AUTENTICAR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(HttpServletRequest request,
								HttpServletResponse response)	throws IOException, ServletException {
		String msg;
		String senha = request.getParameter("senha");
		String login = request.getParameter("login");	 
		
		//tratamento de erros de entreada		
		if(senha== ""&login== ""){
		 	msg = "Preencha o campo senha e o campo login!";
	        request.setAttribute("msg", msg);
	 		getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);} 
		if(senha== ""){
			 	msg = "Preencha o campo senha!";
		        request.setAttribute("msg", msg);
		 		getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);}
		 if(login== ""){
			 	msg = "Preencha o campo login!";
		        request.setAttribute("msg", msg);
		 		getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);}
		// monta um objeto Usuario
		USUARIOMODEL usuario = new USUARIOMODEL();
		USUARIOMODEL usuario1 = new USUARIOMODEL();
		usuario.setSenha(senha);
		usuario.setLogin(login);
		
		USUARIODAO dao = new USUARIODAO();
		boolean test = dao.Loga(usuario);
		if(test==true){
        	usuario1 = dao.Obter(login,senha);	
        	HttpSession session = request.getSession();
    		if(session.isNew()== false )
    		{	session.invalidate();
    			session = request.getSession(true);
    		}
    		if(session.isNew())
    		{
    			String HASH;
        		HASH = FormWriter.getHash(usuario1.getNome());  
    			session.setAttribute("contAcessos", HASH);
    			session.setAttribute("tipo", usuario1.getTipo());
    			session.setAttribute("nome", usuario1.getNome());
    		
    			System.out.println("Criando uma nova sess�o!!!");
    			System.out.println("JSESSION: " + session.getId());
    			System.out.println("TIPO DE USUARIO: " + usuario1.getTipo());
    			System.out.println("CONTA ACESSO: " + HASH);
    		}
       
	        getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);         
        }
        else{
	 		msg = "Dados Incorretos ao tentar Acessar o Sistema!";
	        request.setAttribute("msg", msg);
	 		getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);	 			 		
	 		}
		}
}
		



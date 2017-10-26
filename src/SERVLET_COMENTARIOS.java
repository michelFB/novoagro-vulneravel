import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.FormWriter;



@WebServlet("/comentarios")
public class SERVLET_COMENTARIOS extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
		protected void service(HttpServletRequest request,
								HttpServletResponse response)	throws IOException, ServletException {
		// pegando os par�metros do request
		String conteudo = request.getParameter("conteudo");
		FormWriter.writeOnFile(conteudo);
		String valor = FormWriter.readOnFile();
		//retornando atributo para p�gina p�blica
		request.setAttribute("conteudo",valor );
        // Chama pagina de resposta
        getServletContext().getRequestDispatcher("/publico.jsp").forward(request, response); 
		}
}
		



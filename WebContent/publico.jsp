<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>   
<%@ page import="java.io.*" %>
<%@ page import="projeto.FormWriter" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="publica/header.jspf" />
<body>
 <jsp:include page="publica/barra_superior_publica.jspf" />
 <div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav"> 
    		   <form class="form-horizontal" action="comentarios" method="get">
                       <div class="form-group">
                            <label for="email" class="col-sm-10 control-label">Poste um coment�rio</label>    
                        </div>
                       <div class="col-sm-5">
                                <textarea name="conteudo" rows="8" cols="20"></textarea>
                       </div>
                       <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-5">
                                 <button type="submit" class="btn btn-default">Enviar</button>
                        	</div>
                        </div>
 				</form>
       <%String conteudo =  FormWriter.readOnFile(); out.print(conteudo);%> 
    </div>
    <div class="col-sm-7 text-left"> 
      <h1>NOVOAGRO WEB - Facilitando a vida do homem do campo.</h1>  
      <p/>
   	  <jsp:include page="publica/propaganda.jspf" />
    	<h3>�LTIMAS NOT�CIAS</h3>
		  <table class="table table-bordered">
		      <tr>
		        <td >21/01/2017 |A Empresa Brasileira de Pesquisa Agropecu�ria (Embrapa) vai 
		        lan�ar a variedade Isis, que passar� a ser o quinto tipo de uva sem sementes criada 
		        a partir de pesquisas do �rg�o; as outras s�o Clara, Linda e Morena, lan�adas em 2003,
		         e a variedade Vit�ria, que chegou ao mercado em 2012; todas as variedades foram desenvolvidas 
		         em Petrolina, no Sert�o de Pernambuco</td>  
		        <td>15/01/2017 | cidade de Petrolina se desenvolveu muito com a agricultura irrigada 
		        e a cidade reflete esse desenvolvimento. � bem cuidada e possui algumas boas universidades
		        , ao contr�rio de Juazeiro, que � um pouco degradada. Da� deve, ou talvez tamb�m por outros 
		        fatores da hist�ria que desconhe�o, existe uma rivalidade entre ambas. Apesar de apenas um 
		        rio as separar, Juazeiro e Petrolina s�o muito diferentes entre si at� mesmo no sentido 
		        de pertencimento por seus moradores. .</td>
		        </tr><tr>    
		      <td >11/01/2017 | O crescimento da venda de sucos de uva integral vem aumentando
		        rapidamente no �ltimo ano e ajudando o setor. De 2014 para 2015, a venda de vinhos
		         de mesa aumentou apenas 2%, mas a de suco integral cresceu 31% no mesmo per�odo.</td>  
		        <td>21/09/2016 | Este ano, a safra foi prejudicada pela seca que afeta algumas regi�es
		         do pa�s, mas o Minist�rio projeta uma recupera��o das videiras para a safra do pr�ximo 
		         ano com recupera��o do faturamento, que deve chegar novamente ao patamar dos R$ 4 bilh�es..</td>  
		      </tr>
		  
		  </table>
   </div> 
  <jsp:include page="publica/barra_lateral_direita.jspf" />
  </div>
</div>
<jsp:include page="publica/barra_inferior.jspf" />
</body>
</html>
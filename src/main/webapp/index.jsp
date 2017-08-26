<%@page import="com.sv.udb.controladores.TiposCtrl"%>
<%@page import="com.sv.udb.modelos.Tipos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
  <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <h4>Guía 04 - POO2</h4>
                    <h1>${mensAler}</h1>
                    <form method="POST" action="TipoServ">
                        <input type="hidden" id="codi" name="codi" value="${codi}"/>
                        <div class="form-group">
                            <label for="nomb" class="contro-label">Nombre:</label>
                            <div class="input-group">
                                <span class="input-group-addon"> 1 </span>
                                <input class="form-control" id="nomb" name="nomb" value="${nomb}"/>
                            </div>
                        </div>
                        <input type="submit" name="TipoBton" value="Guardar" class="btn btn-sm btn-success" />
                        <input type="submit" name="TipoBton" value="Modificar" class="btn btn-sm btn-success" />
                        <input type="submit" name="TipoBton" value="Eliminar" class="btn btn-sm btn-success" />
                        <input type="submit" name="TipoBton" value="Nuevo" class="btn btn-sm btn-success" />
                    </form>
                </div>
            </div>
      <br/> 
      <div class="row">
          <form method="POST" action="TipoServ" name="TABLA">
              <table class="table table-striped table-bordered">
                  <thead>
                      <tr>
                          <th>#</th>
                          <th>Tipo</th>
                      </tr>
                  </thead>
                  <tbody>
                      <%
                         for (Tipos temp : new TiposCtrl().cons())
            {
                      %>
                      <tr>
                          <td><p><input name="codiTipoRadi" type="radio" id="<%=temp.getCodiTipo()%>" value="<%=temp.getCodiTipo()%>" />
                        <label for="<%=temp.getCodiTipo()%>"></label></p></td>
                <td><%= temp.getNombTipo()%></td>
                <%
            }
                %>
                      </tr>
                  </tbody>
              </table>
              <input type="submit" name="TipoBton" value="Consultar" class="btn btn-sm btn-success" />
          </form>
      </div>
        </div>
    </body>
</html>

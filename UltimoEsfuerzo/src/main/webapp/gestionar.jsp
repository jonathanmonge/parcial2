<html>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script type="text/javascript" 
src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$('#cargar').click(function(event){
		
	
	  var btn =$('#cargar').val();
		$.post('ServeletConsulta',{

		}, function (respose) {
			var datos = JSON.parse(respose);
var tabladato=document.getElementById('tablaDatos');
for(let item of datos){
	tabladato.innerHTML += `
	
<tr>
<td>${item.apellido}</td>
<td>${item.nombre}</td>
<td>${item.id}</td>

<td>
<a href="ServeletConsulta?btn=ELIMINAR&Id=${item.id}" class="btn btn-warning">ELIMINAR</a>
<a href="funciones.jsp?idBus=${item.id}&No=${item.nombre}&A=${item.apellido}" class="btn btn-danger">Actualizar</a>

</td>
</tr>
`	
}
		});
});
});
</script>
<%

HttpSession s = (HttpSession) request.getSession();
String usuario = (String)s.getAttribute("usuario");
if(usuario==null){
response.sendRedirect("index.jsp");
}
%>
<body Style ="background:url('https://us.123rf.com/450wm/ledinka/ledinka1706/ledinka170600002/79421985-modelo-poligonal-incons%C3%BAtil-azul-de-ne%C3%B3n-fondo-oscuro-con-ne%C3%B3n-azul-tecnolog%C3%ADa-moderna-rejilla-triangular-.jpg?ver=6')">
<form action="ServeletUsuario"method ="post">
<h1 align="center"class="text-secondary">Gestion de Clientes</h1>
	
				<input type="submit" value="IniciarSecion" class="btn btn-success"name ="btn">
			
				
		</form>		
		<a href="funciones.jsp" class="btn btn-info">Agregar Registro</a>
		<input type="submit" value="mostrar"class="btn btn-success" name="btn" id="cargar">
<table class="table table-dark" id="tablaDatos">
	<thead>
		
		<th>apellido</th>
		<th>nombre</th>
		<th>id</th>
		
	</thead>
	<tbody>
		
	</tbody>
</table>
		
			
</body>
</html>

// Call the dataTables jQuery plugin
$(document).ready(function() {
	
	cargarUsuarios();
	
  $('#usuarios').DataTable();
});


async function cargarUsuarios(){
		
  const rawResponse = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  
  const usuarios = await rawResponse.json();
  let listadorHtml= '';		
  for (let usuario of usuarios) {
      let botonEliminar = '<a href="#" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i> </a>';
      let usuariosHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + '</td><td>' + usuario.apellido + '</td><td>' 
          + usuario.email + '</td><td>' + usuario.telefono + '</td><td>' + botonEliminar + '</td></tr>';
      listadorHtml += usuariosHtml;
  }
  document.querySelector('#tbodyUsuarios').outerHTML = listadorHtml; 	
}
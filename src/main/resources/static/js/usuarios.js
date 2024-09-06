// Call the dataTables jQuery plugin
$(document).ready(function() {
	
	cargarUsuarios
	
  $('#usuarios').DataTable();
});


async function cargarUsuarios(){
		
  const rawResponse = await fetch('api/usuario', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  
  const usuarios = await rawResponse.json();
  let listadorHtml= '';		
  for (let usuario of usuarios){
	    let botonEliminar = <a href="#" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i> </a>;
		let usuariosHtmal = '<tr><td>' + usuario.id + '<tr><td>' + usuario.nombre + ' ' + '<tr><td>' + usuario.apellido + '<tr><td>' 
		+ usuario.email + '<tr><td>' +  usuario.telefono + '<tr><td>' + botonEliminar + '</tr></td>';
		listadorHtml+= usuariosHtmal;
  }
  document.querySelector('#usuarios tbody').outerHTML = listadorHtml; 	
}
package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Usuario;

public class UsuarioService {
	
	private Stream<Usuario> getUsuarios(){
		String ruta="c:\\temp\\usuarios.json";
		Gson gson=new Gson();
		try(FileReader reader=new FileReader(ruta);){
			Usuario[] usuarios=gson.fromJson(reader, Usuario[].class);//creamos un array de Empleado
			return Arrays.stream(usuarios);//devuelve un Stream<Usuario[]> 
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	public boolean autenticar(Usuario usuario) {
		return getUsuarios()//Stream<Usuario>
				.anyMatch(u->u.getUsuario().equals(usuario.getUsuario())&&u.getPassword().equals(usuario.getPassword()));			
	}

}

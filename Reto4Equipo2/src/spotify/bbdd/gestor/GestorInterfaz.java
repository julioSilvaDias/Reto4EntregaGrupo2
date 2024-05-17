package spotify.bbdd.gestor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GestorInterfaz<T> {
	
	public void anaidir(T t);

	public void borrar(T t);

	public void modificar(T t);

	public ArrayList<T> obtener() throws SQLException;

	public T obtenerById(int id);
}

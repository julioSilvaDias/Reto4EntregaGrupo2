package spotify.logica;

public class Sesion {

	private static Sesion instance = null;

	private String nombreCancion = null;
	private String nombreDisco = null;
	private String nombreGrupo = null;
	private String nombreSerie = null;
	private String login = null;
	private String nombrePodcast = null;

	private Sesion() {

	}

	public static Sesion getInstance() {
		if (null == instance) {
			instance = new Sesion();
		}
		return instance;
	}

	public String getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public String getNombreDisco() {
		return nombreDisco;
	}

	public void setNombreDisco(String nombreDisco) {
		this.nombreDisco = nombreDisco;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombreSerie() {
		return nombreSerie;
	}

	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}

	public String getNombrePodcast() {
		return nombrePodcast;
	}

	public void setNombrePodcast(String nombrePodcast) {
		this.nombrePodcast = nombrePodcast;
	}

}

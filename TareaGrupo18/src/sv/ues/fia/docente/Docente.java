package sv.ues.fia.docente;

public class Docente 
{
	private String idDocente;
	private String nombreDocente;
	private String apellidoDocente;
	
	public Docente() {
		
	}
	public Docente(String idDocente, String nombreDocente, String apellidoDocente) {
		super();
		this.idDocente = idDocente;
		this.nombreDocente = nombreDocente;
		this.apellidoDocente = apellidoDocente;
	}
	public String getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(String idDocente) {
		this.idDocente = idDocente;
	}
	public String getNombreDocente() {
		return nombreDocente;
	}
	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}
	public String getApellidoDocente() {
		return apellidoDocente;
	}
	public void setApellidoDocente(String apellidoDocente) {
		this.apellidoDocente = apellidoDocente;
	}

}

package sv.ues.fia.tipoespecialidad;

public class TipoEspecialidad 
{
	String IDespecialidad;
	String NombreEspecialidad;
	public TipoEspecialidad(String iDespecialidad, String nombreEspecialidad) {
		IDespecialidad = iDespecialidad;
		NombreEspecialidad = nombreEspecialidad;
	}
	public String getIDespecialidad() {
		return IDespecialidad;
	}
	public void setIDespecialidad(String iDespecialidad) {
		IDespecialidad = iDespecialidad;
	}
	public String getNombreEspecialidad() {
		return NombreEspecialidad;
	}
	public void setNombreEspecialidad(String nombreEspecialidad) {
		NombreEspecialidad = nombreEspecialidad;
	}

}

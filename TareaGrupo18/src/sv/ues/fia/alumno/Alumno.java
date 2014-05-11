package sv.ues.fia.alumno;

public class Alumno 
{

	private String carnet;
	private String nombreAlumno;
	private String apellidoAlumno;
	private String sexo;
	private int ngrupo;
	private int idcarrera;


	public Alumno() {

	}
	
	public Alumno(String carnet, String nombreAlumno, String apellidoAlumno,
			String sexo, int ngrupo, int idcarrera) {
		super();
		this.carnet = carnet;
		this.nombreAlumno = nombreAlumno;
		this.apellidoAlumno = apellidoAlumno;
		this.sexo = sexo;
		this.ngrupo = ngrupo;
		this.idcarrera = idcarrera;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoAlumno() {
		return apellidoAlumno;
	}

	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getNgrupo() {
		return ngrupo;
	}

	public void setNgrupo(int ngrupo) {
		this.ngrupo = ngrupo;
	}

	public int getIdcarrera() {
		return idcarrera;
	}

	public void setIdcarrera(int idcarrera) {
		this.idcarrera = idcarrera;
	}

	
		
	
}

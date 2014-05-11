package sv.ues.fia.institucion;

public class Institucion 
{
	private int idindtitucion=0;
	private String nombreinstitucion="";
	
		
	public Institucion() {
		
	}
	public Institucion(int idindtitucion, String nombreinstitucion) {
		super();
		this.idindtitucion = idindtitucion;
		this.nombreinstitucion = nombreinstitucion;
	}
	public int getIdindtitucion() 
	{
		return idindtitucion;
	}
	public void setIdindtitucion(int idindtitucion) 
	{
		this.idindtitucion = idindtitucion;
	}
	public String getNombreinstitucion() 
	{
		return nombreinstitucion;
	}
	public void setNombreinstitucion(String nombreinstitucion) 
	{
		this.nombreinstitucion = nombreinstitucion;
	}

}

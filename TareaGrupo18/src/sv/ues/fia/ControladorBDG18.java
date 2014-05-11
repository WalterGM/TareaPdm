package sv.ues.fia;


import sv.ues.fia.institucion.Institucion;
import sv.ues.fia.especialidad.Especialidad;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControladorBDG18 
{	
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	private static final String[]camposInstitucion = new String []
			{"IDISTITUCION","NOMBREINSTITUCION"};

	public ControladorBDG18(Context ctx) 
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	private static class DatabaseHelper extends SQLiteOpenHelper 
	{
		private static final String BASE_DATOS = "tesis.s3db";
		private static final int VERSION = 1;
		public DatabaseHelper(Context context) 
		{
			super(context, BASE_DATOS, null, VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) 
		{
			try
			{
				db.execSQL("create table INSTITUCION" +
				"("+
				   "IDISTITUCION         NUMBER(6)            not null PRIMARY KEY,"+
				   "NOMBREINSTITUCION    VARCHAR2(50)         not null"+
				");");
				
				db.execSQL("create table ESPECIALIDAD"+ 
				"("+
				   "IDESPECIALIDAD       INTEGER              not null PRIMARY KEY,"+
				   "IDDOCENTE            VARCHAR2(20)         not null"+
				");");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
		{
		// TODO Auto-generated method stub
		}
	}
	public void abrir() throws SQLException
	{
		db = DBHelper.getWritableDatabase();
		return;
	}
	public void cerrar()
	{
		DBHelper.close();
	}
	
	public String insertar(Institucion institucion)
	{
		String regInsertados="Registro Insertado Nº= ";
		long contador=0;
		ContentValues insti = new ContentValues();
		insti.put("IDISTITUCION", institucion.getIdindtitucion());
		insti.put("NOMBREINSTITUCION", institucion.getNombreinstitucion());
		contador=db.insert("INSTITUCION", null, insti);
		if(contador==-1 || contador==0)
		{
			regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
		}
		else 
		{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	

	public String insertar(Especialidad especialidad)
	{
		String regInsertados="Registro Insertado Nº= ";
		long contador=0;
		ContentValues esp = new ContentValues();
		esp.put("IDESPECIALIDAD", especialidad.getIdEspecialidad());
		esp.put("IDDOCENTE", especialidad.getIdmaestro());
		contador=db.insert("ESPECIALIDAD", null, esp);
		if(contador==-1 || contador==0)
		{
			regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
		}
		else 
		{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	
	public Institucion consultarInstitucion(String codigoinst)
	{
		String[] id = {codigoinst};
		Cursor cursor = db.query("INSTITUCION", camposInstitucion, "IDISTITUCION = ?", id,
		null, null, null);
		if(cursor.moveToFirst())
		{
			Institucion institucion = new Institucion();
			institucion.setIdindtitucion(cursor.getInt(0));
			institucion.setNombreinstitucion(cursor.getString(1));
			return institucion;
		}
		else
		{
			return null;
		}
	}

	public String eliminar(Institucion institucion)
	{
		String regAfectados="filas afectadas= ";
		int contador=0;
		if (verificarIntegridad(institucion,1)) 
		{
			regAfectados="0";
			//aplica para cascada
			//borrar registros de notas
			//contador+=db.delete("nota","carnet='"+alumno.getCarnet()+"'", null); ¨
		}
		else
		{
			//borrar los registros de alumno
			contador+=db.delete("INSTITUCION", "IDISTITUCION='"+institucion.getIdindtitucion()+"'",
			null);
			regAfectados+=contador;
		}
		return regAfectados;
	}
	public String actualizar(Institucion institucion)
	{
		if(verificarIntegridad(institucion, 2))
		{
			String[] id = {institucion.getIdindtitucion()+""};
			ContentValues cv = new ContentValues();
			cv.put("NOMBREINSTITUCION",institucion.getNombreinstitucion());
			db.update("INSTITUCION", cv, "IDISTITUCION = ?", id);
			return "Registro Actualizado Correctamente";
		}
		else
		{
			return "Registro con el codigo " + institucion.getIdindtitucion() + " no existe";
		}
	}

	private boolean verificarIntegridad(Object dato, int relacion) throws SQLException
	{
		switch(relacion)
		{
			case 1:
			{
				/*Institucion institucion = (Institucion)dato;
				Cursor c=db.query(true, "nota", new String[] 
						{"IDISTITUCION" }, "IDISTITUCION='"+institucion.getIdindtitucion()+"'",null,
				null, null, null, null);
				if(c.moveToFirst())
					return true;
				else
					return false;*/
				return false;
			}

			case 2:
			{
				//verificar que exista alumno
				Institucion institucion2 = (Institucion)dato;
				String[] id = {institucion2.getIdindtitucion()+""};
				abrir();
				Cursor c2 = db.query("INSTITUCION", null, "IDISTITUCION = ?", id, null, null,
				null);
				if(c2.moveToFirst())
				{
					//Se encontro Alumno
					return true;
				}
				return false;
			}
			default:
			return false;
		}
	}

}

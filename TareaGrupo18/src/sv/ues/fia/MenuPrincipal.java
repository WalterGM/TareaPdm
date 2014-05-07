package sv.ues.fia;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuPrincipal extends ListActivity{

	String[] menu={"Tabla Alumno","Tabla Grupo","Tabla Docente","Tabla Perfil","Trabajo de Graduacion","Tabla de Especialidad","Tabla de Institucion"};
			String[]
			activities={"alumno.AlumnoMenu","grupo.GrupoMenu","docente.DocenteMenu","perfil.PerfilMenu","trabajograduacion.TrabajoGraduacionMenu","especialidad.EspecialidadMenu","institucion.InstitucionMenu"};
			ControladorBDG18 BDhelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, menu));
		BDhelper=new ControladorBDG18(this);
	}

	@Override
	protected void onListItemClick(ListView l,View v,int position,long id)
	{
		super.onListItemClick(l, v, position, id);
		String nombreValue=activities[position];
		try
		{
			Class<?>
			clase=Class.forName("sv.ues.fia."+nombreValue);
			Intent inte = new Intent(this,clase);
			this.startActivity(inte);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}

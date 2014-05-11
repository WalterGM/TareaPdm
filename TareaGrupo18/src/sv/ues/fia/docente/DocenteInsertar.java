package sv.ues.fia.docente;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import sv.ues.fia.R.layout;
import sv.ues.fia.R.menu;
import sv.ues.fia.alumno.Alumno;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocenteInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editIdDocente;
	EditText editNombreDocente;
	EditText editApellidoDocente;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_docente_insertar);
		helper = new ControladorBDG18(this);
		editIdDocente = (EditText) findViewById(R.id.editIdDocente);
		editNombreDocente = (EditText) findViewById(R.id.editNombreDocente);
		editApellidoDocente = (EditText) findViewById(R.id.editApellidoDocente);
		
	}

	public void insertarAlumno(View v) 
	{
		
		String idInsetarDocente = editIdDocente.getText().toString();
		String nombreInsertarDocente = editNombreDocente.getText().toString();
		String apellidoInsertarDocente = editApellidoDocente.getText().toString();
		String regInsertados;
		Docente docente = new Docente();
		docente.setIdDocente(idInsetarDocente);
		docente.setNombreDocente(nombreInsertarDocente);
		docente.setApellidoDocente(apellidoInsertarDocente);
		helper.abrir();
		//regInsertados=helper.insertar(docente);
		helper.cerrar();
		//Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
		
	
	}
	public void limpiarTexto(View v) 
	{
		editIdDocente.setText("");
		editNombreDocente.setText("");
		editApellidoDocente.setText("");
		
	}

}

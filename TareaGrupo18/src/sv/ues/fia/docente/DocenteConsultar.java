package sv.ues.fia.docente;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import sv.ues.fia.R.layout;
import sv.ues.fia.R.menu;
import sv.ues.fia.institucion.Institucion;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocenteConsultar extends Activity {

	ControladorBDG18 helper;
	EditText editIdDocente;
	EditText editNombreDocente;
	EditText editApellidoDocente;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_docente_consultar);
		helper = new ControladorBDG18(this);
		editIdDocente = (EditText) findViewById(R.id.editConsultarIdDocente);
		editNombreDocente = (EditText) findViewById(R.id.editConsultarNombreDocente);
		editApellidoDocente = (EditText) findViewById(R.id.editConsultarApellidoDocente);
	}

	public void consultarInstitucion(View v) 
	{
		helper.abrir();
		Docente docente = helper.consultarInstitucion(editConsultarDocente.getText().toString());
		helper.cerrar();
		if(docente == null)
		Toast.makeText(this, "El Docente con identificador " +
				editIdDocente.getText().toString() +
		" no encontrado", Toast.LENGTH_LONG).show();
		else
		{
			editConsultarNombreDocente.setText(docente.getNombreDocente().toString());
			editConsultarApellidoDocente.setText(docente.getApellidoDocente().toString());
			
		}
	}
	public void limpiarTexto(View v)
	{
		
		editIdDocente.setText("");
		editNombreDocente.setText("");
		editApellidoDocente.setText("");
		
		
	}

}

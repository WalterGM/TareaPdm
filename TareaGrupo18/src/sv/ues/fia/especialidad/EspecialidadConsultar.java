package sv.ues.fia.especialidad;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EspecialidadConsultar extends Activity {

	EditText editCInst;
	EditText editNInst;
	ControladorBDG18 helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidad_consultar);
		helper = new ControladorBDG18(this);
		editCInst = (EditText) findViewById(R.id.editCCInts);
		editNInst = (EditText) findViewById(R.id.editCNInst);
	}

	

}

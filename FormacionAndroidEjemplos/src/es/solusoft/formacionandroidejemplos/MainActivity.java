package es.solusoft.formacionandroidejemplos;

import java.util.Calendar;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	public void onClick(final View view) {
		Intent intent;
		switch (view.getId()) {
		case R.id.btnLista:
			// Abrimos la pantalla de la lista
			//intent = new Intent(this, ListaActivity.class);
			//this.startActivity(intent);
			Toast.makeText(this, "No implementado", Toast.LENGTH_LONG).show();
			break;
		case R.id.btnPrefs:
			// Abrimos la pantalla de preferencias
			//intent = new Intent(this, PrefsActivity.class);
			//this.startActivity(intent);
			Toast.makeText(this, "No implementado", Toast.LENGTH_LONG).show();
			break;
		case R.id.btnPrefsShow:
			// Mostramos las preferencias
			//mostrarPreferences();
			Toast.makeText(this, "No implementado", Toast.LENGTH_LONG).show();
			break;
		case R.id.btnWeb:
			// Abrimos la pantalla del webview
			//intent = new Intent(this, WebActivity.class);
			//this.startActivity(intent);
			Toast.makeText(this, "No implementado", Toast.LENGTH_LONG).show();
			break;
		case R.id.btnAlarm:
			// Registramos la alarma dentro de 5 sec
			//establecerAlarma(5);
			Toast.makeText(this, "No implementado", Toast.LENGTH_LONG).show();
			break;
		case R.id.btnThread:
			// Abrimos la actividad donde probaremos los hilos
			//intent = new Intent(this, ThreadActivity.class);
			//this.startActivity(intent);
			Toast.makeText(this, "No implementado", Toast.LENGTH_LONG).show();
			break;
		}
	}

	private void mostrarToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	private void mostrarAlert(String title, String msg) {
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(msg);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// aqui puedes hacer cosas
			}
		});
		alertDialog.setIcon(android.R.drawable.btn_dialog);
		alertDialog.show();
	}

}

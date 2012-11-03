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
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.MenuOption1:
			mostrarToast(getString(R.string.msgBody));
			return true;
		case R.id.MenuOption2:
			mostrarAlert(getString(R.string.msgTitle),
					getString(R.string.msgBody));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}



	public void onClick(final View view) {
		Intent intent;
		switch (view.getId()) {
		case R.id.btnLista:
			// Abrimos la pantalla de la lista
			intent = new Intent(this, ListaActivity.class);
			this.startActivity(intent);
			break;
		case R.id.btnPrefs:
			// Abrimos la pantalla de preferencias
			intent = new Intent(this, PrefsActivity.class);
			this.startActivity(intent);
			break;
		case R.id.btnPrefsShow:
			// Mostramos las preferencias
			mostrarPreferences();
			break;
		case R.id.btnWeb:
			// Abrimos la pantalla del webview
			intent = new Intent(this, WebActivity.class);
			this.startActivity(intent);
			break;
		case R.id.btnAlarm:
			// Registramos la alarma dentro de 5 sec
			establecerAlarma(5);
			break;
		case R.id.btnThread:
			// Abrimos la actividad donde probaremos los hilos
			intent = new Intent(this, ThreadActivity.class);
			this.startActivity(intent);
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
	

	private void mostrarPreferences() {

		// Preferencias manejadas por la aplicacion, no se ven en el XML
		// Y podemos usarlas para lo que queramos... por ejemplo para contar
		// cuantas veces hemos mostrado las preferencias!
		
		//Asi leemos
		SharedPreferences leerMisPrefs = MainActivity.this.getSharedPreferences(
				"MISPREFS", Activity.MODE_PRIVATE);
		
		int cuantasVeces = leerMisPrefs.getInt("CUANTASVECES", 0);

		//Asi escribimos
		SharedPreferences escribirMisPrefs = MainActivity.this.getSharedPreferences(
				"MISPREFS", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = escribirMisPrefs.edit();
		
		cuantasVeces++; //Lo acabamos de leer una vez mas
		
		editor.putInt("CUANTASVECES", cuantasVeces); //Guardamos el nuevo valor
		editor.commit();


		// Ahora un ejemplo de lectura de preferencias 
		// manejadas en el XML
		SharedPreferences prefs = 
			PreferenceManager
			.getDefaultSharedPreferences(MainActivity.this);

		String username = prefs.getString("username", "vacio");
		String passw = prefs.getString("password", "vacio");
		boolean checkBox = prefs.getBoolean("checkBox", false);

		StringBuilder builder = new StringBuilder();
		builder.append("Username: " + username + "\n");
		builder.append("Contraseña: " + passw + "\n");
		builder.append("Recordar: " + String.valueOf(checkBox) + "\n");
		builder.append("Hemos leido esto " + cuantasVeces + " veces");

		mostrarAlert(getString(R.string.msgTitle), builder.toString());

	}
	
	
    /** 
     * se ejecutara despues de los segundos especificados
     * @param when Numero de segundos  
     */  
    private void establecerAlarma(int sec){   
  
           Intent        intent  = new Intent(MainActivity.this, AlarmService.class);  
           PendingIntent pIntent = PendingIntent.getService(MainActivity.this, 0, intent,  0);
  
           AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE); 
           
           manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + sec * 1000, pIntent);       
           // Tambien es interesante el metodo que permitiria alarmas periodicas
           // manager.setRepeating(...)
    }  

	

}

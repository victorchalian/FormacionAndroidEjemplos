package es.solusoft.formacionandroidejemplos;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ThreadActivity extends Activity {
	
	public final int MENSAJE_ERROR = -1;
	public final int MENSAJE_OK = 1;

	int mTiempoTarea = 5; //5 segundos
	
	private Handler handler = new Handler(new ResultMessageCallback());
	
	private ProgressDialog progressDialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thread);
		
		//Abrimos la pantalla que bloquea la pantalla mientras dura la tarea
		progressDialog = ProgressDialog.show(this, "Espera", "Espera " + mTiempoTarea + "segundos por favor");
		
		//Iniciamos la tarea en segundo plano
		Thread thread = new Thread(new MiTareaBackground());
		thread.start();

	}
	
	private class ResultMessageCallback implements Callback {

		public boolean handleMessage(Message arg0) {
			

			//Cerramos la pantalla de progreso
			progressDialog.dismiss();
			
			switch(arg0.what)
			{
			case MENSAJE_ERROR:
				Toast.makeText(ThreadActivity.this, "Error", Toast.LENGTH_LONG).show();
				break;
			case MENSAJE_OK:
				Toast.makeText(ThreadActivity.this, "Terminado", Toast.LENGTH_LONG).show();
				break;
			}
			
			
			return true; //lo marcamos como procesado
		}
	}

	/**
	 * Implementamos Runnable para una tarea en segundo plano
	 * @author mjgs
	 *
	 */
	private class MiTareaBackground implements Runnable {
		
		public void run(){
			
			int mensajeDevuelto = MENSAJE_OK;
			
			//Aqui realizamos la tarea en segundo plano que no sera instantanea
			//lo simulamos con un sleep
			try {
				Thread.sleep(mTiempoTarea * 1000);
			} catch (InterruptedException e) {
				
				mensajeDevuelto = MENSAJE_ERROR;
				
				e.printStackTrace();
			}
			
			//devolvemos un mensaje al hilo principal
			handler.sendEmptyMessage(mensajeDevuelto);
		}
	}
}

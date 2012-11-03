package es.solusoft.formacionandroidejemplos;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class AlarmService extends Service {
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "ServiceClass.onStart()", Toast.LENGTH_LONG).show();
        Log.d("AlarmService", "Inicio del servicio");
    }
	
	@Override
    public void onCreate() {
        super.onCreate();
        Log.d("AlarmService", "Service got created");
        Toast.makeText(this, "ServiceClass.onCreate()", Toast.LENGTH_LONG).show();
    }
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}
}

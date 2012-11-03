package es.solusoft.formacionandroidejemplos;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Codigo de ejemplo de implementacion y comportamiento de una pantalla de preferencias
 * @author findemor
 *
 */
public class PrefsActivity extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
	}

}

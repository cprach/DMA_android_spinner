package com.cp.dma.dma_android_spinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);




	}

	public void populateSpinners() {
		Spinner countries_spinner = (Spinner)findViewById(R.id.countries_spinner);
		countries_spinner.setOnItemSelectedListener(this);
		ArrayAdapter <CharSequence> countriesAdapter = ArrayAdapter.createFromResource(this, 
				R.array.countries_list, android.R.layout.simple_spinner_item);
		countriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		countries_spinner.setAdapter(countriesAdapter);


		Spinner airlines_spinner = (Spinner)findViewById(R.id.airlines_spinner);
		airlines_spinner.setOnItemSelectedListener(this);
		ArrayAdapter <CharSequence> airlinesAdapter = ArrayAdapter.createFromResource(this, 
				R.array.airlines_list, android.R.layout.simple_spinner_item);
		airlinesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		airlines_spinner.setAdapter(airlinesAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		if (arg2 > 0) { 

			String selection = (String)arg0.getItemAtPosition(arg2);

			if (arg0.getId() == R.id.countries_spinner) {
				TextView txtCurrentCityName = (TextView)findViewById(R.id.txtCurrentCityName);
				txtCurrentCityName.setText(selection);
			}

			if (arg0.getId() == R.id.airlines_spinner) {
				TextView txtCurrentAirlineName = (TextView)findViewById(R.id.txtCurrentAirlineName);
				txtCurrentAirlineName.setText(selection);
			}

		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
}

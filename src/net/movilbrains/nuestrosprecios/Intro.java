package net.movilbrains.nuestrosprecios;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Intro extends Activity implements OnClickListener {

	Spinner spnr_cities;
	ImageView handler;
	ImageButton ibtn_logo_app;
	Button btn_log_in;
	Button btn_register;
	Button view_finder_changer;
	TextView np_font;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
        ibtn_logo_app = (ImageButton) findViewById(R.id.ibtn_logo_app);
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_log_in = (Button) findViewById(R.id.btn_log_in);
		view_finder_changer = (Button)findViewById(R.id.view_finder_change);
		spnr_cities = (Spinner) findViewById(R.id.spnr_cities);
		np_font = (TextView)findViewById(R.id.intro_title);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "berlin-sans-fb-demi-bold.ttf");
		np_font.setTypeface(font);
		ibtn_logo_app.setOnClickListener(this);
		btn_register.setOnClickListener(this);
		btn_log_in.setOnClickListener(this);
		view_finder_changer.setOnClickListener(this);
		// Creamos el adaptador
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.ciudades, android.R.layout.simple_spinner_item);
		// Añadimos el layout para el menú
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Le indicamos al spinner el adaptador a usar
		spnr_cities.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_intro, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_register:
			intent = new Intent(Intro.this, Sing_in.class);
			startActivity(intent);

			break;
		case R.id.btn_log_in:
			intent = new Intent(Intro.this, Log_in.class);
			startActivity(intent);

			break;
		case R.id.ibtn_logo_app:
			intent = new Intent(Intro.this, FinderMozaicActivity.class);
			startActivity(intent);
			break;
			
		case R.id.view_finder_change:
			intent = new Intent(Intro.this, Finder.class);
			startActivity(intent);

			break;

			
			
		default:
			break;
		}

	}

}

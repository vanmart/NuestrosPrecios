package net.movilbrains.nuestrosprecios;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class Intro extends Activity implements OnClickListener,OnItemClickListener {

	//Spinner spnr_cities;
	ImageView handler;
	ImageButton ibtn_logo_app;
	//GridView gv_main_menu_buttons;
	Button btn_log_in;
	Button btn_register;
	Button view_finder_changer;
	TextView np_font;
	SlideMenuIconsAdapter menu_icons_adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
        ibtn_logo_app = (ImageButton) findViewById(R.id.ibtn_logo_app);
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_log_in = (Button) findViewById(R.id.btn_log_in);
		view_finder_changer = (Button)findViewById(R.id.view_finder_change);
		//spnr_cities = (Spinner) findViewById(R.id.spnr_cities);
		np_font = (TextView)findViewById(R.id.intro_title);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "berlin-sans-fb-demi-bold.ttf");
		np_font.setTypeface(font);
		ibtn_logo_app.setOnClickListener(this);
		btn_register.setOnClickListener(this);
		btn_log_in.setOnClickListener(this);
		view_finder_changer.setOnClickListener(this);
		// Creamos el adaptador
		//ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		//		this, R.array.ciudades, android.R.layout.simple_spinner_item);
		// A�adimos el layout para el men�
		//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Le indicamos al spinner el adaptador a usar
		//spnr_cities.setAdapter(adapter);
		//gv_main_menu_buttons = (GridView) findViewById(R.id.gv_btn_mozaic);
        //gv_main_menu_buttons.setOnItemClickListener(this);		
        //menu_icons_adapter = new SlideMenuIconsAdapter();
        //gv_main_menu_buttons.setAdapter(menu_icons_adapter);	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_intro, menu);
		return true;
	}
	
	// create a new ImageView for each item referenced by the Adapter 
	public View getView(int position, View convertView, ViewGroup parent) {
		 ImageView imageView; if (convertView == null) { 
			 // if it's not recycled,initialize some
			 // attributes 
	      imageView = new ImageView(this);
		  imageView.setLayoutParams(new GridView.LayoutParams(150, 100));
		  imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		 imageView.setPadding(4, 4, 4, 4); } else { imageView = (ImageView)
		 convertView; }
		  
		  imageView.setImageResource(menu_icons_adapter.bussines_array[position]);
		  
		  return imageView;
		  
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

	@Override
	public void onItemClick(AdapterView parentView, View childView, int position, long id) {
		Toast.makeText(Intro.this,"tocas"+position,Toast.LENGTH_LONG).show();
		Intent intent;
		switch (childView.getId()) {
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

package net.movilbrains.nuestrosprecios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;

import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FinderMozaicActivity extends Activity implements
		OnItemClickListener {

	TextView title;
	GridView gridv;
	ImageButton find;
	public static JSONArray info;
	final static String URL = "http://nuestrosprecios.herokuapp.com/companies.json";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finder_mozaic);
		Typeface font = Typeface.createFromAsset(getAssets(),
				"berlin-sans-fb-demi-bold.ttf");
		title = (TextView) findViewById(R.id.tv_np_title);
		title.setTypeface(font);
		find = (ImageButton) findViewById(R.id.ibtn_lupa);
		gridv = (GridView) findViewById(R.id.gv_mozaic);
		
		gridv.setOnItemClickListener(this);

		new DownloadJSONFile().execute();
	}
	
	public String getStringFromURL(String url) {
		Log.d("URL", url);
		StringBuilder strb = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url.toString());
		try {
			HttpResponse response = client.execute(httpGet);
			StatusLine status = response.getStatusLine();
			int statusCode = status.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content), 1);
				String line;
				while ((line = reader.readLine())!= null) {
					strb.append(line);
				}
			}
			else{
				Log.e("JSON","Error: failed downloading file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return strb.toString();
		
	}


	public class DownloadJSONFile extends AsyncTask<String, Float, Integer> {

		@Override
		protected Integer doInBackground(String... url) {
			String text = getStringFromURL(URL);
			Log.d("info", text);
			try {
				info = new JSONArray(text);
			} catch (JSONException e) {
				info = null;
				e.printStackTrace();
				Log.e("JSON","Error: Failed parsing String to JSON file.");
			}
			return 0;
		}
		
		@Override
		protected void onPostExecute(Integer bytes){
			CompaniesAdapter companiesList = new CompaniesAdapter(info);
			gridv.setAdapter(companiesList);
		}  

	}

	
	/*
	 * // references to our images private Integer[] bussines_array = {
	 * R.drawable.juanvaldez, R.drawable.perros, R.drawable.arturocalle,
	 * R.drawable.biohazard, R.drawable.cinecolombia, R.drawable.macdonalds,
	 * R.drawable.qbano, R.drawable.arturocalle, R.drawable.biohazard,
	 * R.drawable.cinecolombia, R.drawable.perros, R.drawable.arturocalle,
	 * R.drawable.biohazard, R.drawable.cinecolombia, R.drawable.macdonalds,
	 * R.drawable.qbano };
	 * 
	 * }
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_finder_mozaic, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView parentView, View childView,
			int position, long id) {
		Toast.makeText(FinderMozaicActivity.this, "tocaste: " + position,
				Toast.LENGTH_LONG).show();
	}

}

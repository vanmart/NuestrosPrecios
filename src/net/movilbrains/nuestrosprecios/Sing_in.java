package net.movilbrains.nuestrosprecios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.support.v4.app.NavUtils;

public class Sing_in extends Activity implements OnClickListener {
	
	private final String LOG_TAG = "LOG";
	EditText name;
	EditText email;
	EditText password;
	EditText password_confirmation;
	Button create_acount;
	//private ProgressBar pb_sing_in;
	private Handler handler = new Handler();
	private static int progress;
	private int progress_status = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        name = (EditText)findViewById(R.id.et_name);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);
        password_confirmation = (EditText)findViewById(R.id.et_password_confirmation);
      //  pb_sing_in = (ProgressBar)findViewById(R.id.pb_sing_in); 
        create_acount = (Button)findViewById(R.id.btn_create_account);
        create_acount.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sing_in, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_create_account:
		//	         pb_sing_in.setVisibility(0);
			//         hold();
			         postData(); 
			         Intent intent = new Intent(Sing_in.this,Log_in.class);
			         //pb_sing_in.setVisibility(8);
			         startActivity(intent);
			break;

		default:
			break;
		}	
			
		
	}
	
public void hold(){
    	
    	new Thread(new Runnable() {
    		@Override
    		public void run() {
    			while(progress_status < 10){
    				progress_status = do_some_job();
    			     }
    			handler.post(new Runnable() {
    				@Override
    				public void run() {
    					// TODO ---0 VISIBLE; 4 - INVISIBLE; 8 -GONE ---
              //         pb_sing_in.setVisibility(8);					
    				}
    			});
    			progress_status = 0;
    			
    		}
    		
    		
    		
    	}).start();
    	

    }

    private int do_some_job(){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ++progress_status;
		
	}

	
	public void postData() {
		// Create a new HttpClient and Post Header
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(
				"https://nuestrosprecios.herokuapp.com/api/users/new");
				//"http://192.168.1.9:8080/api/users/new");
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("Accept", "application/json");

		try {
			JSONObject params = new JSONObject();
			try {
				params.put("name", name.getText().toString());
				params.put("email", email.getText().toString());
				params.put("password", password.getText().toString());
				params.put("password_confirmation", password_confirmation.getText().toString());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}

			System.out.println("Params: " + params.toString());

			StringEntity entity = new StringEntity(params.toString());
			httppost.setEntity(entity);

			// Execute HTTP Post Request
			HttpResponse response = httpclient.execute(httppost);

			int status = response.getStatusLine().getStatusCode();

			System.out.println("Status: " + status);

			if (status == 200) {

				HttpEntity e = response.getEntity();

				StringBuilder sb = new StringBuilder();
				try {
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(e.getContent()), 65728);
					String line = null;

					while ((line = reader.readLine()) != null) {
						sb.append(line);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				System.out.println("finalResult " + sb.toString());

			}

		} catch (ClientProtocolException e) {
			Log.v(LOG_TAG, e.toString());
		} catch (IOException e) {
			Log.v(LOG_TAG, e.toString());
		}
	}

    
}

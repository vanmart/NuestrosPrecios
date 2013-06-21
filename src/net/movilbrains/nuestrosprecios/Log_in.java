package net.movilbrains.nuestrosprecios;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Log_in extends Activity implements OnClickListener{
	
	TextView login_title;
	Button send;
	Button cancel;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        
        send = (Button)findViewById(R.id.btn_send);
        cancel = (Button)findViewById(R.id.btn_cancel);
        login_title = (TextView)findViewById(R.id.tv_login_title);
        Typeface font = Typeface.createFromAsset(getAssets(),
				"berlin-sans-fb-demi-bold.ttf");
        login_title.setTypeface(font);
        send.setOnClickListener(this);
        cancel.setOnClickListener(this);
        
    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_send:
			               Intent intent = new Intent(Log_in.this,Intro.class);
			               startActivity(intent);
			
			break;

		default:
			break;
		}
		
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_log_in, menu);
        return true;
    }



    
}

package net.movilbrains.nuestrosprecios;




import android.R.color;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ViewSwitcher.ViewFactory;
import android.support.v4.app.NavUtils;

public class Finder extends Activity implements OnClickListener,ViewFactory {

	private ProgressBar pb;
	private Handler handler = new Handler();
	private static int progress;
	private int progress_status = 0;
	EditText search;
	TextView title;
	ImageButton btn_search;
	private ImageSwitcher imageSwitcher;
	Integer[] bussines_array = {R.drawable.juanvaldez,
	        R.drawable.perros,
	        R.drawable.arturocalle,
	        R.drawable.biohazard,
	        R.drawable.cinecolombia,
	        R.drawable.macdonalds,
	        R.drawable.qbano,
	        R.drawable.cinecolombia,
	        R.drawable.biohazard,
	        R.drawable.arturocalle
	        };
	
	
	
   @Override
   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_finder);
	        search = (EditText)findViewById(R.id.et_search_bar);
	        Typeface font = Typeface.createFromAsset(getAssets(), "berlin-sans-fb-demi-bold.ttf");
	        title = (TextView)findViewById(R.id.tv_np_title);
	        title.setTypeface(font);
	        btn_search =(ImageButton)findViewById(R.id.ibtn_lupa);
	        btn_search.setOnClickListener(this);
	        imageSwitcher = (ImageSwitcher)findViewById(R.id.is_show);
	        imageSwitcher.setFactory(this);
	        imageSwitcher.setAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
	        imageSwitcher.setAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
	        /*
	         * imageSwitcher.setAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
	         * imageSwitcher.setAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
	         * */
	        
	        
	        pb =(ProgressBar)findViewById(R.id.pb_progress_bar);
	        Gallery gallery = (Gallery) findViewById(R.id.gallery);
	        gallery.setAdapter(new ImageAdapter(this));
	        gallery.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View v, int position,
						long id) {
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(), "imagen"+(position+1)+"seleccionada", Toast.LENGTH_LONG).show();
					//mostrar imagen seleccionada
					/*ImageView imageView = (ImageView)findViewById(R.id.show);
					imageView.setImageResource(bussines_array[position]);
					*/
					makeView();
					imageSwitcher.setImageResource(bussines_array[position]);
				}
			});
	    }
   
   public class ImageAdapter extends BaseAdapter{
       private Context context;
       private int itemBackground;
   	
       public ImageAdapter(Context c){
       	context = c;
       	//configura estilo
       	TypedArray a = obtainStyledAttributes(R.styleable.styl_Gallery);
           itemBackground = a.getResourceId(R.styleable.styl_Gallery_android_galleryItemBackground,0);
           a.recycle();
       }
       
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return bussines_array.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageView = new ImageView(context);
           imageView.setImageResource(bussines_array[position]);
           imageView.setScaleType(ImageView.ScaleType.FIT_XY);
           imageView.setLayoutParams(new Gallery.LayoutParams(150,120));
           imageView.setBackgroundResource(itemBackground);
			return imageView;
		}
   	
   	
   }
	           
	    
    	
    	
    	
   
    

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.activity_finder, menu);
       return true;
   }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ibtn_lupa:
			   pb.setVisibility(0);
			   hold();
			   Intent intent;
			   intent = new Intent(Finder.this, Intro.class);
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
                       pb.setVisibility(8);					
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

	@Override
	public View makeView() {
		ImageView imageView = new ImageView(this);
		imageView.setBackgroundColor(0xff000000);
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
		        LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		// TODO Auto-generated method stub
		return imageView;
	}
	
}

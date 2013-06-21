package net.movilbrains.nuestrosprecios;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class GalleryView extends Activity {
    //imagenes a mostrar
	Integer[] bussines_array = {R.drawable.juanvaldez,
	        R.drawable.perros,
	        R.drawable.arturocalle,
	        R.drawable.biohazard,
	        R.drawable.cinecolombia,
	        R.drawable.macdonalds,
	        R.drawable.qbano
	        };
	
	//llamado una sola vez al crear la activity (como un Constructor)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_view);
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {

        	@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "imagen"+(position+1)+"seleccionada", Toast.LENGTH_LONG).show();
				//mostrar imagen seleccionada
				ImageView imageView = (ImageView)findViewById(R.id.show);
				imageView.setImageResource(bussines_array[position]);
				
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
        getMenuInflater().inflate(R.menu.activity_gallery_view, menu);
        return true;
    }

    
}

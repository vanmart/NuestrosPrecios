package net.movilbrains.nuestrosprecios;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.content.res.TypedArray;

public class SlideMenuIconsAdapter extends BaseAdapter {
	 private Context context;
     private int itemBackground;
     Integer[] bussines_array = {R.drawable.juanvaldez,
 	        R.drawable.perros,
 	        R.drawable.arturocalle,
 	        R.drawable.biohazard,
 	        R.drawable.cinecolombia,
 	        R.drawable.macdonalds,
 	        R.drawable.qbano
 	        };
 	
     public SlideMenuIconsAdapter(){
     	//context = c;
     	//configura estilo
     	//TypedArray a = obtainStyledAttributes(R.styleable.styl_Gallery);
         //itemBackground = a.getResourceId(R.styleable.styl_Gallery_android_galleryItemBackground,0);
         //a.recycle();
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

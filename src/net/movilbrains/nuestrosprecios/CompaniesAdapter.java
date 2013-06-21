package net.movilbrains.nuestrosprecios;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class CompaniesAdapter extends BaseAdapter {
	private JSONArray products;

	public CompaniesAdapter(JSONArray products) {
		this.products = products;
	}

	public int getCount() {
		return this.products.length();
	}

	@Override
	public Object getItem(int position) {
		JSONObject item = null;
		try {
			item = this.products.getJSONObject(position);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.single_list_item, parent,
					false);
		}
		JSONObject obj = null;
		try {
			obj = this.products.getJSONObject(position);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		ImageView iv_company_image = (ImageView) convertView
				.findViewById(R.id.iv_company_image);
		TextView txt_item_name = (TextView) convertView
				.findViewById(R.id.txt_item_name);

		try {
			Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(
					obj.getJSONObject("image").getJSONObject("thumb")
							.getString("url")).getContent());
			iv_company_image.setImageBitmap(bitmap);
			txt_item_name.setText(obj.getString("name"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		/*
		 * ImageView imageView = new ImageView(parent.getContext());
		 * imageView.setImageResource(obj.getsbussines_array[position]);
		 * imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		 * imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
		 * imgeView.setBackgroundResource(itemBackground);
		 */
		return convertView;

	}
	/*
	 * // create a new ImageView for each item referenced by the Adapter public
	 * View getView(int position, View convertView, ViewGroup parent) {
	 * ImageView imageView; if (convertView == null) { // if it's not recycled,
	 * initialize some // attributes imageView = new ImageView(mContext);
	 * imageView.setLayoutParams(new GridView.LayoutParams(150, 100));
	 * imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	 * imageView.setPadding(4, 4, 4, 4); } else { imageView = (ImageView)
	 * convertView; }
	 * 
	 * imageView.setImageResource(bussines_array[position]);
	 * 
	 * return imageView; }
	 */
}

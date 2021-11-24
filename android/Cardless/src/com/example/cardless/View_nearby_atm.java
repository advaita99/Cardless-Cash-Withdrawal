package com.example.cardless;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class View_nearby_atm extends Activity {
	ListView l1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_nearby_atm);
		 l1=(ListView)findViewById(R.id.listView1);
			
			new getjson().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_nearby_atm, menu);
		return true;
	}
	private class getjson extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = Login.url+"atmreg/android/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
							String atm_id = c.getString("atm_id");
		                    String b_id = c.getString("b_id");	                    
		                    String longitude = c.getString("longitude");
		                    String latitude = c.getString("latitude");
		                    String location = c.getString("location");
		                    String status = c.getString("status");
		                 

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("atm_id", atm_id);
		                    contact.put("b_id", b_id);
		                    contact.put("longitude", longitude);
		                    contact.put("latitude", latitude);
		                    contact.put("location", location);
		                    contact.put("status", status);
		                    

		                    

		                 
		                    
		                    
		                    
		                   	     
		                    	
		                    	al.add(contact);
		                    
		                }
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Toast.makeText(getApplicationContext(), "No data yet...", 3).show();
						}
					}
					else
					{
						Toast.makeText(getApplicationContext(), "No data yet...", 3).show();
					}
					return null;
				}
				
				@Override
			      protected void onPostExecute(Void result) {
			         super.onPostExecute(result);
			         
//			         Toast.makeText(getApplicationContext(), Login.uid, 3).show();
			         
			         ListAdapter adapter = new SimpleAdapter(View_nearby_atm.this, al,
			            R.layout.nearby_atm, new String[]{ "location","longitude","latitude","status"}, 
			               new int[]{R.id.textView2,R.id.textView4,R.id.textView3,R.id.textView5});
			         l1.setAdapter(adapter);
			      }
			}

}

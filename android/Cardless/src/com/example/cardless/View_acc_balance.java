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

public class View_acc_balance extends Activity {
	ListView l1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_acc_balance);
		 l1=(ListView)findViewById(R.id.listView1);
			
			new getjson().execute();
	}
	private class getjson extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = Login.url+"userac/android/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
							String ua_id = c.getString("ua_id");
		                    String u_id = c.getString("u_id");	                    
		                    String account_number = c.getString("account_number");
		                    String balance = c.getString("balance");
		                 

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("ua_id", ua_id);
		                    contact.put("u_id", u_id);
		                    contact.put("account_number", account_number);
		                    contact.put("balance", balance);
		                    

		                    
		                    
		                    
		                   	     
		                    	
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
			         
			         ListAdapter adapter = new SimpleAdapter(View_acc_balance.this, al,
			            R.layout.balance, new String[]{ "account_number","balance"}, 
			               new int[]{R.id.textView2,R.id.textView4});
			         l1.setAdapter(adapter);
			      }
			}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_acc_balance, menu);
		return true;
	}

}

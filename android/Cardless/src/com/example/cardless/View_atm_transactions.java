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

public class View_atm_transactions extends Activity {
	ListView l1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_atm_transactions);
		 l1=(ListView)findViewById(R.id.listView1);
			
			new getjson().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_atm_transactions, menu);
		return true;
	}
	private class getjson extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = Login.url+"atm_transaction/android/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
							String atmtr_id = c.getString("atmtr_id");
		                    String u_id = c.getString("u_id");	                    
		                    String account_number = c.getString("account_number");
		                    String date = c.getString("date");
		                    String time = c.getString("time");	                    
		                    String amount = c.getString("amount");
		                    String status = c.getString("status");
		                 

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("atmtr_id", atmtr_id);
		                    contact.put("u_id", u_id);
		                    contact.put("account_number", account_number);
		                    contact.put("date", date);
		                    contact.put("time", time);
		                    contact.put("amount", amount);
		                    contact.put("status", status);
		                  
		                    
		                    
		                    
		                   	     if(u_id.equals(Login.uid)){
		                    	
		                    	al.add(contact);
		                   	     }
		                    
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
			         
			         ListAdapter adapter = new SimpleAdapter(View_atm_transactions.this, al,
			            R.layout.atm_transaction, new String[]{ "date","time","amount","status"}, 
			               new int[]{R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8});
			         l1.setAdapter(adapter);
			      }
			}

}

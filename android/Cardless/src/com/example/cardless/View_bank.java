package com.example.cardless;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class View_bank extends Activity {
	ListView l1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_bank);
		 l1=(ListView)findViewById(R.id.listView1);
			
			new getjson().execute();
			l1.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					  Intent i=new Intent(getApplicationContext(),Request_for_verification.class);
						
						HashMap<String, String>hmap=(HashMap<String, String>)arg0.getItemAtPosition(arg2);				
						
						i.putExtra("b_id", hmap.get("b_id"));
						startActivity(i);
				}
           });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_bank, menu);
		return true;
	}
	private class getjson extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = Login.url+"bank/android/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
							String b_id = c.getString("b_id");
		                    String bank_name = c.getString("bank_name");	                    
		                    String address = c.getString("address");
		                    String status = c.getString("status");
		                  

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("b_id", b_id);
		                    contact.put("bank_name", bank_name);
		                    contact.put("address", address);
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
			         
			         ListAdapter adapter = new SimpleAdapter(View_bank.this, al,
			            R.layout.bank, new String[]{ "bank_name","address", "b_id"}, 
			               new int[]{R.id.textView2,R.id.textView4,R.id.textView6});
			         l1.setAdapter(adapter);
			      }
			}

}
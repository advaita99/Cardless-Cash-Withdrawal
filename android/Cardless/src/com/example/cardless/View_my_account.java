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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class View_my_account extends Activity {
	ListView l1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_my_account);
		 l1=(ListView)findViewById(R.id.listView1);
			
			new getjson().execute();
			
			l1.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					  Intent i=new Intent(getApplicationContext(),Set_pin.class);
						
						HashMap<String, String>hmap=(HashMap<String, String>)arg0.getItemAtPosition(arg2);				
						
						i.putExtra("account_number", hmap.get("account_number"));
						startActivity(i);
				}
           });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_my_account, menu);
		return true;
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
		                    String ifsc_code = c.getString("ifsc_code");
		                    String type_of_account = c.getString("type_of_account");
		                    String account_number = c.getString("account_number");
		                    String balance = c.getString("balance");
		                 

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("ua_id", ua_id);
		                    contact.put("u_id", u_id);
		                    contact.put("ifsc_code", ifsc_code);
		                    contact.put("type_of_account", type_of_account);
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
			         
			         ListAdapter adapter = new SimpleAdapter(View_my_account.this, al,
			            R.layout.account, new String[]{ "account_number","type_of_account", "ifsc_code","balance"}, 
			               new int[]{R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8});
			         l1.setAdapter(adapter);
			      }
			}

}

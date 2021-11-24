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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Post_complaint_reply extends Activity {
	EditText com;
	Button post,reply;
	ListView li;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_complaint_reply);
		com=(EditText)findViewById(R.id.editText1);
		post=(Button)findViewById(R.id.button1);
		reply=(Button)findViewById(R.id.button2);
		li=(ListView)findViewById(R.id.listView1);
		
		post.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!com.getText().toString().equals(""))
				{
				new savejson().execute();
				}
				Toast.makeText(getApplicationContext(), "FILL", 3).show();
			}
		});
		
         reply.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new getjson().execute();
			}
		});
	}
	public class savejson extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url = Login.url+"complaint/android/";
			JSONObject jobj= new JSONObject();
	        try {
	   
	        
				jobj.put("u_id",Login.uid);
				jobj.put("complaint", com.getText().toString());
				
				
				
				
			
				
				
				JsonHandler.Postjson(url, jobj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null; 
		}
		
		@Override
	      protected void onPostExecute(Void result) {
	         super.onPostExecute(result);
	    
	         
	        	 Toast.makeText(getApplicationContext(), "success", 3).show();
	        	 com.setText("");

	     
	      }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post_complaint_reply, menu);
		return true;
	}
	private class getjson extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = Login.url+"reply/android/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
		                    
		                    String r_id = c.getString("r_id");                   
		                    String c_id = c.getString("c_id");
		                    String date = c.getString("date");
		                    String time = c.getString("time");
		                    String reply = c.getString("reply");
		                 

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                  
		                    contact.put("c_id", c_id);
		                    contact.put("date", date);
		                    contact.put("time", time);
		                    contact.put("reply", reply);
		                    
		                    	
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
			         
			         ListAdapter adapter = new SimpleAdapter(Post_complaint_reply.this, al,
			            R.layout.complaint, new String[]{ "c_id","reply"}, 
			               new int[]{R.id.textView2,R.id.textView4});
			         li.setAdapter(adapter);
			      
			}}
}

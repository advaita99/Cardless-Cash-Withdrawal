package com.example.cardless;



import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Scan_QR extends Activity {
	Button b1,b2;
	EditText t1,t2;
	String s,out="";
	Spinner s1;
	String gm;
	
	String sidd="";
String []stid;
String []stn;

String outp;
ArrayList<HashMap<String, String>> itlist;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan__qr);
		t1=(EditText)findViewById(R.id.editText1);

		t2=(EditText)findViewById(R.id.editText2);
		
		
		s1=(Spinner)findViewById(R.id.spinner1);
		
		
		
		 b2=(Button)findViewById(R.id.button2);
		 
		 
		 new savejson2().execute();
		 
		 
		 b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub				
				try {

				    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
				    intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes

				    startActivityForResult(intent, 0);

				} catch (Exception e) {

				    Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
				    Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
				    startActivity(marketIntent);

				}
				
				
			}
		});
	        b1=(Button)findViewById(R.id.button1);
			b1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					if(!t1.getText().toString().equals("")&&!t2.getText().toString().equals("")&&!out.equals("")&&!sidd.equals(""))
					{
						new savejson().execute();	
					}
					else
					{
						Toast.makeText(getApplicationContext(), "Have to scan QR and Enter PIN and Amount...", 3).show();
					}		
					
				}
			});	
			
			
			
			
			
			
			s1.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					sidd=stid[arg2];
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scan__qr, menu);
		return true;
	}

	public class savejson extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url = Login.url+"userac/android11/";
			
			JSONObject jobj= new JSONObject();
	        try {
//			
				jobj.put("amt",t1.getText().toString());
				jobj.put("pin",t2.getText().toString());
				jobj.put("uid",Login.uid);
				jobj.put("aid",out);
				jobj.put("acc",sidd);
			
//				jobj.put("status","sold" );


				gm=JsonHandler.Postjson(url, jobj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null; 
		}
		
		@Override
	      protected void onPostExecute(Void result) {
	         super.onPostExecute(result);
	         Toast.makeText(getApplicationContext(), gm, 3).show();
	         
	         t1.setText("");
	         t2.setText("");
	         
	        	   
	      }
	
	}
	
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {           
	    super.onActivityResult(requestCode, resultCode, data);
	    if (requestCode == 0) {

	        if (resultCode == RESULT_OK) {
	            out = data.getStringExtra("SCAN_RESULT");
	            Toast.makeText(getApplicationContext(), out, 3).show();
    
	                 
	        }
	        if(resultCode == RESULT_CANCELED){
	            //handle cancel
	        }
	    }
	}
	
	
	
	
	
	
	
	
	

	
	
	private class savejson2 extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			String url =Login.url+"userac/android1/";
			JSONObject jobj= new JSONObject();
	        try {
	        	jobj.put("uid", Login.uid);
	        
				outp= JsonHandler.Postjson(url, jobj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null; 
		}
		
		@Override
	      protected void onPostExecute(Void result) {
	         super.onPostExecute(result);
       
	         itlist=new ArrayList<HashMap<String,String>>();
	         JSONArray jdata;
			try {
				jdata = new JSONArray(outp);
				
				stid=new String[jdata.length()];
				 stn=new String[jdata.length()];
				 
				if(jdata!=null)
				{
				 
				 try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
							String id=c.getString("ua_id");
							String nm =c.getString("account_number");
							 stid[i]=id;
							 stn[i]=nm;
//							 
							 
							 
							 }
							 
							 
						}  catch (JSONException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//				 spinner
				 ArrayAdapter<String> ad=new ArrayAdapter<String>(Scan_QR.this, android.R.layout.simple_spinner_item,stn);
				 s1.setAdapter(ad);
				 
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No Data", 5).show();
				}
	        
				
				
				
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	         
	      }
		
	}
	
	
	
	
	
	
	
	
	
}

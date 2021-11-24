package com.example.cardless;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.cardless.Request_for_verification.savejson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Set_pin extends Activity {
	EditText e1,e2,e3;
    Button b1;
    String pinn;
    String ac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_pin);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		
	
		b1=(Button)findViewById(R.id.button1);
		 ac=getIntent().getStringExtra("account_number");
			e3.setText(ac);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pinn=e2.getText().toString();
				if(e1.getText().toString().equals(pinn))
				{
					pinn=e2.getText().toString();
					new savejson().execute();
				}
				else{
					Toast.makeText(getApplicationContext(), "Pin not matching", 3).show();
				}
				
			}
		});
	
		
	}
	public class savejson extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url = Login.url+"pin/android/";
			JSONObject jobj= new JSONObject();
	        try {
	   
	        
			
				
				jobj.put("pin", e2.getText().toString());
				jobj.put("u_id",Login.uid);
				jobj.put("account_number",ac);
		
				
				
				
			
				
				
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
	        	 Intent i=new Intent(getApplicationContext(), Homepage.class);
	        	 startActivity(i);
	        	
	        	

	     
	      }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set_pin, menu);
		return true;
	}

}

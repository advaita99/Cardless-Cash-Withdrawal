package com.example.cardless;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.cardless.Post_feedback.savejson;

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

public class Register extends Activity {
	EditText e1,e2,e6,e8,e5;
    Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e5=(EditText)findViewById(R.id.editText5);
		e6=(EditText)findViewById(R.id.editText6);
		e8=(EditText)findViewById(R.id.editText8);
	
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new savejson().execute();
			}
		});
	
		
	}
	public class savejson extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url = Login.url+"user/android/";
			JSONObject jobj= new JSONObject();
	        try {
	   
	        
			
				jobj.put("name", e1.getText().toString());
				jobj.put("dob", e2.getText().toString());
				jobj.put("email", e5.getText().toString());
				jobj.put("phone", e6.getText().toString());
				jobj.put("password", e8.getText().toString());
				
				
				
				
			
				
				
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
	        	 Intent i=new Intent(getApplicationContext(), Login.class);
	        	 startActivity(i);
	        	

	     
	      }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}

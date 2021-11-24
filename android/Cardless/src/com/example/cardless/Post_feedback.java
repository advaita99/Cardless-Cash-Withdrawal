package com.example.cardless;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.cardless.Post_complaint_reply.savejson;

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

public class Post_feedback extends Activity {
	EditText fd;
	Button post;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_feedback);
		fd=(EditText)findViewById(R.id.editText1);
		post=(Button)findViewById(R.id.button1);
		
		
           post.setOnClickListener(new OnClickListener() {
			
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
			String url = Login.url+"feedback/android/";
			JSONObject jobj= new JSONObject();
	        try {
	   
	        
				jobj.put("u_id",Login.uid);
				jobj.put("feedback", fd.getText().toString());
				
				
				
				
			
				
				
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
	        	 fd.setText("");

	     
	      }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post_feedback, menu);
		return true;
	}

}

package com.example.cardless;


import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class Rating extends Activity {
	private RatingBar ratingBar;
	  private TextView txtRatingValue;
	  private Button btnSubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		
		
		addListenerOnRatingBar();
		addListenerOnButton();
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rating, menu);
		return true;
	}

	

	
	 public void addListenerOnRatingBar() {

		    ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		    txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

		    //if rating value is changed,
		    //display the current rating value in the result (textview) automatically
		    ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
		        public void onRatingChanged(RatingBar ratingBar, float rating,
		            boolean fromUser) {

		            txtRatingValue.setText(String.valueOf(rating));

		        }
		    });
		  }
	 
	 
	 
	 public void addListenerOnButton() {
		 //
//		 		    ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		 		    btnSubmit = (Button) findViewById(R.id.btnSubmit);
		 //
//		 		    //if click on me, then display the current rating value.
		 		    btnSubmit.setOnClickListener(new OnClickListener() {
		 //
		 		        @Override
		 		        public void onClick(View v) {
		 
		 		            
		 		        	new savejson().execute();
		 		        	
		 //
		 		        }
		 //
		 		    });
		 //	
		 		  }
	 
	 
	 
	 public class savejson extends AsyncTask<Void, Void, Void>{
			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
				String url = Login.url+"rating/android/";
				JSONObject jobj= new JSONObject();
		        try {
		   
		        
					jobj.put("u_id",Login.uid);
					jobj.put("ra", txtRatingValue.getText().toString());
					
					
					
					
				
					
					
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
		    
		         
		        	 Toast.makeText(getApplicationContext(), "Success", 3).show();
		        	 Intent i=new Intent(getApplicationContext(), Homepage.class);
		        	 startActivity(i);
		        	 

		     
		      }
		}
		 
		 
}

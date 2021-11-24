package com.example.cardless;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpHandler {

	
	
//	When we develop an Android app, usually we have to connect to a remote server to get information. 
//	The connection usually is based on HTTP protocol because it provides a simple mechanism to transport information.

	
   private static final String TAG = HttpHandler.class.getSimpleName();

   public HttpHandler() {
   }

   public String makeServiceCall(String reqUrl) {
      String response = null;
      try {
         URL url = new URL(reqUrl);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         // read the response
         InputStream in = new BufferedInputStream(conn.getInputStream());
         response = convertStreamToString(in);
      } catch (MalformedURLException e) {
         Log.e(TAG, "MalformedURLException: " + e.getMessage());
      } catch (ProtocolException e) {
         Log.e(TAG, "ProtocolException: " + e.getMessage());
      } catch (IOException e) {
         Log.e(TAG, "IOException: " + e.getMessage());
      } catch (Exception e) {
         Log.e(TAG, "Exception: " + e.getMessage());
      }
      return response;
   }

   private String convertStreamToString(InputStream is) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      StringBuilder sb = new StringBuilder();

      String line;
      try {
         while ((line = reader.readLine()) != null) {
            sb.append(line).append('\n');
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            is.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
        
      return sb.toString();
   }
}

package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Results extends AppCompatActivity {



    private ArrayList<Crawl.Product> results;
    private TextView resultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        resultView = findViewById(R.id.textView7);
    }

    @Override
    public void onResume(){
        super.onResume();


        resultView.setMovementMethod(new ScrollingMovementMethod());

        Intent in = getIntent();
        String keyword = in.getStringExtra("KEYWORD");
        String searchTerm = CarSettingActivity.year + " " + CarSettingActivity.make + " " + CarSettingActivity.model + " " + keyword;

        resultView.setText("Loading...");
        new DoCrawl().execute(searchTerm);



    }

    private class DoCrawl extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... searchTermASync) {

            //Kiran: put your code here to implement your script and output to the Arraylist below

            //partSearcher psearch = new partSearcher(searchTermASync);
            //ArrayList<String> urlList = psearch.getFinalList();
            ArrayList<String> urlList = new ArrayList<>();
            urlList.add("https://www.walmart.com/search/?query=acura%20rsx%20brake%20pads");
            urlList.add("https://www.carparts.com/results/?Ntt=acura+rsx+brake+pad&searchType=global&N=0&uts=true&shopId=1&searchType=global&N=0");
            //urlList.add("https://www.carid.com/search/acura+rsx+brake+pads/code-0f686e0cd7d00ac950d65108f3c9b244/queryId-fc5dcd3d510cb5a415e0a3119351a192/ymm-0%7CAcura%7CRSX");
            urlList.add("https://www.usautoparts.net/catalog?Ntt=acura+rsx+brake+pads&searchType=global&N=0&uts=true&shopId=1&searchType=global&N=0");
            Crawl crawler = new Crawl();
            results = crawler.crawlSites(urlList);
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Collections.sort(results);

            String resOutput;

            if (results != null){

                resultView.setTextColor(Color.BLACK);
                int numProducts = results.size();


                StringBuilder resBuild = new StringBuilder();
                for(int i = 0; i<numProducts; i++){
                    resBuild.append(i+1);
                    resBuild.append(":\n");
                    resBuild.append("Name:\n");
                    resBuild.append(results.get(i).prodName);
                    resBuild.append("\nPrice:\n");
                    resBuild.append(results.get(i).prodPrice);
                    resBuild.append("\nLink:\n");
                    resBuild.append(results.get(i).prodLink);
                    resBuild.append("\n\n");


                }
                resOutput = resBuild.toString();
            }
            else{

                resultView.setTextColor(Color.RED);
                resOutput = "No Results Found" + "\n\n" + "Please verify that your Car Information and Keyword are accurate";
            }


            resultView.setText(resOutput);

        }


    }
}

package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Kalman Muller
 */
public class Results extends AppCompatActivity {



    private ArrayList<Crawl.Product> results;
    private TextView resultView;
    private String searchTerm;
    private String key;
    private int choice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setTitle(getResources().getString(R.string.AppTitle));

        resultView = findViewById(R.id.textView7);
//creates the String search term used to get the url ArrayList<String>
        Intent in = getIntent();
        key = in.getStringExtra("KEYWORD");
        searchTerm = CarSettingActivity.year + " " + CarSettingActivity.make + " " + CarSettingActivity.model + " " + key;

//sets the placeholder loading text
        resultView.setText("Searching for " + searchTerm + "...");
        //calls the nested AsyncTask class to execute its code in a separate thread
        new DoCrawl().execute(searchTerm);

    }

    private class DoCrawl extends AsyncTask<String, Void, Void> {
//method where the network operations are executed
        @Override
        protected Void doInBackground(String... searchTermASync) {


//initializes partSearcher and gets the ArrayList<String> of the urls to be crawled from the searchTerm String
            //partSearcher is not functional currently
            //partSearcher psearch = new partSearcher(searchTerm);
            //ArrayList<String> urlList = psearch.getFinalList();
            System.out.println(searchTerm);

            if (key.equals(getResources().getString(R.string.bPad))){
                choice = 1;
            }
            ArrayList<String> padUrlList = new ArrayList<>();
            padUrlList.add("https://www.walmart.com/search/?query=acura%20rsx%20brake%20pads");
            padUrlList.add("https://www.carparts.com/results/?Ntt=acura+rsx+brake+pad&searchType=global&N=0&uts=true&shopId=1&searchType=global&N=0");
            padUrlList.add("https://www.carid.com/search/acura+rsx+brake+pads/code-0f686e0cd7d00ac950d65108f3c9b244/queryId-fc5dcd3d510cb5a415e0a3119351a192/ymm-0%7CAcura%7CRSX");
            padUrlList.add("https://www.usautoparts.net/catalog?Ntt=acura+rsx+brake+pads&searchType=global&N=0&uts=true&shopId=1&searchType=global&N=0");

            if (key.equals(getResources().getString(R.string.oFilt))){
                choice = 2;
            }
            ArrayList<String> oFiltUrlList = new ArrayList<>();
            oFiltUrlList.add("https://www.usautoparts.net/catalog?Ntt=2002+Acura+RSX+Oil+Filter&searchType=global&N=0&uts=true&shopId=1&searchType=global&N=0");
            oFiltUrlList.add("https://www.carid.com/search/2002+Acura+RSX+Oil+Filter/code-caf6614fe8d6ce507345698f6ac8f181/queryId-2ecaa9390da2eb9dd84bf8c7eae72a13/ymm-2002%7CAcura%7CRSX");
            oFiltUrlList.add("https://www.carparts.com/results/?Ntt=2002+Acura+RSX+Oil+Filter&searchType=global&N=0&uts=true&shopId=1&searchType=global&N=0");
            oFiltUrlList.add("https://www.walmart.com/search/?query=2002%20Acura%20RSX%20Oil%20Filter");

            if (key.equals(getResources().getString(R.string.plug))){
                choice = 3;
            }
            ArrayList<String> plugUrlList = new ArrayList<>();
            plugUrlList.add("https://www.usautoparts.net/catalog?Ntt=2002+Acura+RSX+Spark+Plug&searchType=global&N=&shopId=1&searchType=global&N=0");
            plugUrlList.add("https://www.carid.com/search/2002+Acura+RSX+Spark+Plug/code-e7add726caf3424415271316725c0d05/queryId-060c7582d7cc1232013d97d2d62b8093/ymm-2002%7CAcura%7CRSX");
            plugUrlList.add("https://www.carparts.com/results/?Ntt=2002+Acura+RSX+Spark+Plug&searchType=global&N=&shopId=1&searchType=global&N=0");
            plugUrlList.add("https://www.walmart.com/search/?query=2002%20Acura%20RSX%20Spark%20Plug");



            ArrayList<String> urlList = new ArrayList<>();
            switch (choice){
                case 1:
                    urlList = padUrlList;
                    break;
                case 2:
                    urlList = oFiltUrlList;
                    break;
                case 3:
                    urlList = plugUrlList;
                    break;
                default :
                    break;
            }

//initializes Crawl uses the ArrayList<String> of urls to get and ArrayList<Product> of product objects
            Crawl crawler = new Crawl();
            if (urlList.size() > 0){
                results = crawler.crawlSites(urlList);
            }
            else {
                results = new ArrayList<>();
            }
            return null;
        }
//called after doInBackground has finished
        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            //sorts the list
            Collections.sort(results);

            String resOutput;
//checks that the list is not empty
            if (results.size() != 0){
//
                resultView.setTextColor(Color.BLACK);
                int numProducts = results.size();


                SpannableStringBuilder resBuild = new SpannableStringBuilder();
                for(int i = 0; i<numProducts; i++){
//adds the name, price, and web address for the Product at index i to the string


                        resBuild.append(Integer.toString(i+1));
                        resBuild.append(":\n");

                        resBuild.append("Name:\n");
                        resBuild.append(results.get(i).prodName);

                        resBuild.append("\nPrice:\n");
                        resBuild.append(results.get(i).prodPrice);

                    resBuild.append("\nLink:\n");
                    resBuild.append(results.get(i).prodLink);

                    int finalI = i;
                    //sets the span for the text of the product address then creates an onClick method that opens the part url in the phone browser on click
                    resBuild.setSpan(new ClickableSpan() {
                        @Override
                        public void onClick(View widget) {
                            Uri link = Uri.parse(results.get(finalI).prodLink);
                            Intent intent = new Intent(Intent.ACTION_VIEW,link);
                            startActivity(intent);
                            //span start and end indexes
                        }
                    }, resBuild.length() - results.get(i).prodLink.length(), resBuild.length(), 0);
                    resBuild.append("\n\n");


                }
                //makes the textView clickable for links
                resultView.setMovementMethod(LinkMovementMethod.getInstance());
                //sets resBuild as the spannable text of resultView
                resultView.setText(resBuild, TextView.BufferType.SPANNABLE);
            }
            //Product Arraylist is empty
            else{
                //sets the text color red and sets the text to a default no results message
                resultView.setTextColor(Color.RED);
                resOutput = "No Results Found" + "\n\n" + "Please verify that your Car Information and Keyword are accurate";
                resultView.setText(resOutput);
            }

        }

    }
}

package com.gmu.kam.cs321partapp;

import java.io.IOException;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawl
{
    ArrayList<String> urls;

    public Crawl()
    {

    }

    public static ArrayList<Product> crawlSites(ArrayList<String> urlList)
    {
        ArrayList<Product> walmartProducts = new ArrayList<>(0); //initial array for products from walmart.com
        ArrayList<Product> carIdProducts = new ArrayList<>(0);  //initial array for products from carid.com
        ArrayList<Product> CarPartsProducts = new ArrayList<>(0);   //initial array for products from carparts.com
        ArrayList<Product> USAutoPartsProducts = new ArrayList<>(0);   //initial array for products from usautoparts.net
        for(int i=0; i< urlList.size(); i++) //iterate through list of URLs
        {

            if (urlList.get(i).contains("walmart")) //if link is from walmart, run walmart crawler
            {
                try
                {
                    walmartProducts = productListWalmart(urlList.get(i));
                } catch (IOException e)
                {
                    System.out.println("Webpage not found");
                }
            }

            if (urlList.get(i).contains("carid"))  //if link is from carID, run carID crawler
            {
                try
                {
                    carIdProducts = productListCarId(urlList.get(i));
                } catch (IOException e)
                {
                    System.out.println("Webpage not found");
                }
            }

            if (urlList.get(i).contains("carparts"))  //if link is from CarParts, run CarParts crawler
            {
                try
                {
                    CarPartsProducts = productListCarParts(urlList.get(i));
                } catch (IOException e)
                {
                    System.out.println("Webpage not found");
                }
            }

            if (urlList.get(i).contains("usautoparts"))  //if link is from USAutoParts, run USAutoParts crawler
            {
                try
                {
                    USAutoPartsProducts = productListUSAutoParts(urlList.get(i));
                } catch (IOException e)
                {
                    System.out.println("Webpage not found");
                }
            }
        }
        ArrayList<Product> allProducts=new ArrayList<>(); //initial arraylist of all products
        walmartProducts.addAll(CarPartsProducts); //combine all product arraylists
        walmartProducts.addAll(carIdProducts);
        walmartProducts.addAll(USAutoPartsProducts);
        allProducts=walmartProducts;
        return allProducts; //return arraylist of all products
    }

    public static ArrayList<Product> productListCarId(String url) throws IOException
    {
        org.jsoup.Connection connection = Jsoup.connect(url); //create connection with website
        Document document = connection.get(); //retrieve HTML document from site
        System.out.println("Document received from webpage at " + url);

        ArrayList<Element> prodElements = document.select("li[class=js-product-list-item]"); //retrieve all elements that fit CSSQuery

        ArrayList<Product> products=new ArrayList<>(); //initial list of products
        for (int i = 0; i < 15; i++) //iterate through 15 products
        {
            Product temp = new Product(); //create new Product object
            temp.prodName=prodElements.get(i).attr("data-name"); //set product name
            temp.prodPrice=prodElements.get(i).attr("data-wl-price"); //set product price
            temp.prodLink="https://www.carid.com" + prodElements.get(i).attr("data-url"); //set link to product page
            temp.prodImg="https://www.carid.com" + prodElements.get(i).attr("data-src");  //set link to product image
            products.add(temp); //add Product to arraylist
        }
        return products; //return arraylist of all products
    }
    public static ArrayList<Product> productListCarParts(String url) throws IOException
    {
        org.jsoup.Connection connection = Jsoup.connect(url); //establish connection with website
        Document document = connection.get(); //retrieve HTML document from site

        System.out.println("Document received from webpage at " + url);

        ArrayList<Element> prodLinks; //retrieve elements that contain link to product page
        prodLinks = document.getElementsByAttributeValueStarting("data-elemname", "item_name_link");

        ArrayList<Element> prodPrices; //retrieve elements that contain product price
        prodPrices = document.getElementsByAttributeValueStarting("data-elemname", "item_price_text");

        ArrayList<Element> prodImgs; //retrieve elements that contain product image link
        prodImgs = document.getElementsByAttributeValueStarting("data-elemname", "item_image_link");

        ArrayList<Product> products=new ArrayList<>();  //initial list of products
        for (int i = 0; i < 10; i++)
        {
            Product temp = new Product();   //create new Product object
            temp.prodName=prodLinks.get(i).childNode(1).outerHtml().replaceAll("<h1>", ""); //set product name and modify string to omit HTML tags
            temp.prodName=prodLinks.get(i).childNode(1).outerHtml().replaceAll("</h1>", "");
            temp.prodPrice=prodPrices.get(i).text(); //set product price
            temp.prodLink="https://www.carparts.com" + prodLinks.get(i).attr("href");   //set link to product page
            temp.prodImg=prodImgs.get(i).attr("src");   //set link to product image
            products.add(temp); //add Product to arraylist
        }

        return products;    //return arraylist of all products
    }
    public static ArrayList<Product> productListUSAutoParts(String url) throws IOException
    {
        org.jsoup.Connection connection = Jsoup.connect(url);   //establish connection with website
        Document document = connection.get();   //retrieve HTML document from site

        System.out.println("Document received from webpage at " + url);

        ArrayList<Element> prodNames; //retrieve elements that contain product names
        prodNames = document.getElementsByAttributeValue("class","productName");

        ArrayList<Element> prodPrices; //retrieve elements that contain product price
        prodPrices = document.getElementsByAttributeValueStarting("class", "formValue ourPrice");

        ArrayList<Element> prodImgs;  //retrieve elements that contain product image links
        prodImgs = document.getElementsByAttributeValueStarting("class", "zoomViewer");

        ArrayList<Product> products=new ArrayList<>();  //initial list of products
        for (int i = 0; i < 10; i++)
        {
            Product temp = new Product();
            temp.prodName = prodNames.get(i).text();    //set product name
            temp.prodPrice = prodPrices.get(i).text();  //set product price
            temp.prodLink = "https://www.usautoparts.net" + prodNames.get(i*2).child(0).attr("href");   //set link to product page
            temp.prodImg=prodImgs.get(i).child(0).attr("src");  //set link to product image
            products.add(temp); //add Product to arraylist
        }

        return products;    //return arraylist of all products

    }
    public static ArrayList<Product> productListWalmart(String url) throws IOException
    {
        org.jsoup.Connection connection = Jsoup.connect(url);   //establish connection with website
        Document document = connection.maxBodySize(0).timeout(0).get(); //retrieve HTML document from site

        System.out.println("Document received from webpage at " + url);

        ArrayList<Element> prodImgLinks_Name;   //retrieve elements that contain product image link and name
        prodImgLinks_Name = document.getElementsByAttributeValueStarting("data-pnodetype", "item-pimg");

        ArrayList<Element> prodPrices;  //retrieve elements that contain product price
        prodPrices = document.getElementsByAttributeValueStarting("class", "price-group");

        ArrayList<Product> products = new ArrayList<>();    //initial list of products
        for(int i = 0; i<prodImgLinks_Name.size(); i++)
        {
            Product temp = new Product();
            temp.prodName=prodImgLinks_Name.get(i).attr("alt"); //set product name
            temp.prodImg=prodImgLinks_Name.get(i).attr("data-image-src");   //set link to product image
            temp.prodLink="https://www.walmart.com" + prodImgLinks_Name.get(i).parent().attr("href");   //set link to product page
            temp.prodPrice=prodPrices.get(i).attr("aria-label"); //set product price
            products.add(temp); //add Product to arraylist
        }

      return products;  //return arraylist of all products
    }

    public static class Product implements Comparable<Product>
    {
        String prodName;
        String prodPrice;
        String prodImg;
        String prodLink;

        Product()
        {
            this.prodName="";
            this.prodPrice="";
            this.prodImg="";
            this.prodLink="";
        }

        @Override
        public int compareTo(Product o) {
            //parse string as float value and compare to another value
            int res;
            float t = Float.parseFloat(this.prodPrice.substring(this.prodPrice.lastIndexOf('$') + 1));
            float fo = Float.parseFloat(o.prodPrice.substring(o.prodPrice.lastIndexOf('$') + 1));
            float eps = (float) 0.001;
            if(Math.abs(t - fo) < eps){
                res = 0;
            }
            else if (t < fo){
                res = -1;
            }
            else{
                res = 1;
            }
            return res;
        }
    }
}


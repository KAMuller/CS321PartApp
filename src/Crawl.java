import java.io.IOException;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * Created by Ishmam on 11/7/2018.
 */
public class Crawl
{
    public static void main(String[] args)
    {
        /*ArrayList<String> links = new ArrayList<>();
        links.add("https://www.walmart.com/search/?query=acura%20rsx%20brake%20pads");
        links.add("https://www.carparts.com/results/?Ntt=acura+rsx+brake+pad&searchType=global&N=0&uts=true&shopId=1&searchType=global&N=0");
        links.add("https://www.carid.com/search/acura+rsx+brake+pads/code-0f686e0cd7d00ac950d65108f3c9b244/queryId-fc5dcd3d510cb5a415e0a3119351a192/ymm-0%7CAcura%7CRSX");
        links.add("https://www.usautoparts.net/catalog?Ntt=acura+rsx+brake+pads&searchType=global&N=0&uts=true&shopId=1&searchType=global&N=0");
        crawlSites(links);*/

    }

    public static ArrayList<Product> crawlSites(ArrayList<String> urlList)
    {
        ArrayList<Product> walmartProducts = new ArrayList<>(0);
        ArrayList<Product> carIdProducts = new ArrayList<>(0);
        ArrayList<Product> CarPartsProducts = new ArrayList<>(0);
        ArrayList<Product> USAutoPartsProducts = new ArrayList<>(0);
        for(int i=0; i< urlList.size(); i++)
        {

            if (urlList.get(i).contains("walmart"))
            {
                try
                {
                    walmartProducts = productListWalmart(urlList.get(i));
                } catch (IOException e)
                {
                    System.out.println("Webpage not found");
                }
            }

            if (urlList.get(i).contains("carid"))
            {
                try
                {
                    carIdProducts = productListCarId(urlList.get(i));
                } catch (IOException e)
                {
                    System.out.println("Webpage not found");
                }
            }

            if (urlList.get(i).contains("carparts"))
            {
                try
                {
                    CarPartsProducts = productListCarParts(urlList.get(i));
                } catch (IOException e)
                {
                    System.out.println("Webpage not found");
                }
            }

            if (urlList.get(i).contains("usautoparts"))
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
        ArrayList<Product> allProducts=new ArrayList<>();
        walmartProducts.addAll(CarPartsProducts);
        walmartProducts.addAll(carIdProducts);
        walmartProducts.addAll(USAutoPartsProducts);
        allProducts=walmartProducts;
        System.out.println(allProducts.size());
        return allProducts;
    }

    public static ArrayList<Product> productListCarId(String url) throws IOException
    {
        org.jsoup.Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        System.out.println("Document received from webpage at " + url);

        ArrayList<Element> prodElements = document.select("li[class=js-product-list-item]");

        ArrayList<Product> products=new ArrayList<>();
        for (int i = 0; i < 15; i++)
        {
            Product temp = new Product();
            temp.prodName=prodElements.get(i).attr("data-name");
            temp.prodPrice=prodElements.get(i).attr("data-wl-price");
            temp.prodLink="https://www.carid.com" + prodElements.get(i).attr("data-url");
            temp.prodImg="https://www.carid.com" + prodElements.get(i).attr("data-src");
            products.add(temp);
        }

        return products;
    }
    public static ArrayList<Product> productListCarParts(String url) throws IOException
    {
        org.jsoup.Connection connection = Jsoup.connect(url);
        Document document = connection.get();

        System.out.println("Document received from webpage at " + url);

        ArrayList<Element> prodLinks;
        prodLinks = document.getElementsByAttributeValueStarting("data-elemname", "item_name_link");

        ArrayList<Element> prodPrices;
        prodPrices = document.getElementsByAttributeValueStarting("data-elemname", "item_price_text");

        ArrayList<Element> prodImgs;
        prodImgs = document.getElementsByAttributeValueStarting("data-elemname", "item_image_link");

        ArrayList<Product> products=new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            Product temp = new Product();
            temp.prodName=prodLinks.get(i).childNode(1).outerHtml().replaceAll("<h1>", "");
            temp.prodPrice=prodPrices.get(i).text();
            temp.prodLink="https://www.carparts.com" + prodLinks.get(i).attr("href");
            temp.prodImg=prodImgs.get(i).attr("src");
            products.add(temp);
        }

/*
        System.out.println(products.get(0).prodName);
        System.out.println(products.get(0).prodPrice);
        System.out.println(products.get(0).prodLink);
        System.out.println(products.get(0).prodImg);
        System.out.println();
*/

        return products;

    }
    public static ArrayList<Product> productListUSAutoParts(String url) throws IOException
    {
        org.jsoup.Connection connection = Jsoup.connect(url);
        Document document = connection.get();

        System.out.println("Document received from webpage at " + url);

        ArrayList<Element> prodNames;
        prodNames = document.getElementsByClass("productName");

        ArrayList<Element> prodPrices;
        prodPrices = document.getElementsByAttributeValueStarting("class", "formValue ourPrice");

        ArrayList<Element> prodImgs;
        prodImgs = document.getElementsByAttributeValueStarting("class", "zoomViewer");

        ArrayList<Product> products=new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            Product temp = new Product();
            temp.prodName = prodNames.get(i).text();
            temp.prodPrice = prodPrices.get(i).text();
            temp.prodLink = "https://www.usautoparts.net" + prodNames.get(i).child(0).attr("href");
            temp.prodImg=prodImgs.get(i).child(0).attr("src");
            products.add(temp);
        }
/*
        System.out.println(products.get(0).prodName);
        System.out.println(products.get(0).prodPrice);
        System.out.println(products.get(0).prodLink);
        System.out.println(products.get(0).prodImg);
*/
        return products;

    }
    public static ArrayList<Product> productListWalmart(String url) throws IOException
    {
        org.jsoup.Connection connection = Jsoup.connect(url);
        Document document = connection.maxBodySize(0).timeout(0).get();

        System.out.println("Document received from webpage at " + url);

        ArrayList<Element> prodImgLinks_Name;
        prodImgLinks_Name = document.getElementsByAttributeValueStarting("data-pnodetype", "item-pimg");

        ArrayList<Element> prodPrices;
        prodPrices = document.getElementsByAttributeValueStarting("class", "price-group");

        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i<prodImgLinks_Name.size(); i++)
        {
            Product temp = new Product();
            temp.prodName=prodImgLinks_Name.get(i).attr("alt");
            temp.prodImg=prodImgLinks_Name.get(i).attr("data-image-src");
            temp.prodName=prodImgLinks_Name.get(i).attr("alt");
            temp.prodLink="https://www.walmart.com" + prodImgLinks_Name.get(i).parent().attr("href");
            temp.prodPrice=prodPrices.get(i).attr("aria-label");
            products.add(temp);
        }
/*        System.out.println(products.get(0).prodName);
        System.out.println(products.get(0).prodPrice);
        System.out.println(products.get(0).prodLink);
        System.out.println(products.get(0).prodImg);
*/      return products;
    }

    public static class Product
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
    }
}


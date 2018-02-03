import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Scrape {
	public static void main(String[] args) throws IOException {
	        String FILEPATH1= "C:\Users\nugo\Documents\GitHub\Web-scraper-jsoup\src\output.txt";
	        String FILEPATH= "C:\Users\nugo\Documents\GitHub\Web-scraper-jsoup\src\test.txt"
			PrintWriter out = new PrintWriter(new FileWriter( "C:\\Users\\USER-pc\\Desktop\\11.txt"));
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Penguin").get();
			Elements media = doc.select("[src]");
			Elements links = doc.getElementsByTag("a");
			String L ="";
			String M="";
		    String BURL= "https://en.wikipedia.org";
		    Set<String> linesl = new LinkedHashSet();
		    Set<String> linesi = new LinkedHashSet();
		    int count=1;int count2=1;
		    String temp="";
		    if ( FILEPATH.equals("")) {
		    	System.out.println("enter file path");
		    }
		    String HTTP = "https://";
			//PrintWriter out1 = new PrintWriter(new FileWriter( "C:\\Users\\USER-pc\\Desktop\\111.txt"));
			//out1.println("Link");
			for (Element L  : links ) {
				
				 L= l.attr("href");
				 L=L.toLowerCase();
				
				if(L.length() >0 )
				
				{   if(L.substring(L.length()-4).equals(".gif")||
						L.substring(L.length()-4).equals(".png")||
						L.substring(L.length()-4).equals(".jpg")||
						L.substring(L.length()-4).equals(".ogv"))
				{
					
					continue;
					
				}
					if(L.substring(0,2).equals("//"))
					{   
						temp=HTTP + L.substring(2);
						linesl.add(temp);
						//out1.println(HTTP + L.substring(2));
						continue;
						
					}
					
					if(L.substring(0,1).equals("#"))
					{
						
						continue;
						
					}
					if(L.substring(0,4).equals("http"))
					{   linesl.add(L);
						//out1.println(L);  continue;
						
					}
					if(!L.substring(0,4).equals("http"))
					{   temp=BURL+L.substring(0);
						linesl.add(temp);
						//out1.println(BURL+L.substring(0)); 
						continue;
					
					}
			}
		}
			//out1.println("IMAGES");
			for(Element i : media) {
			if(i.tagName().equals("img"));
			{
					linesi.add(i.attr("abs:src"));
			//out1.println("N-"+count2+"-"+i.attr("abs:src"));	
			}
		}
			
			//out1.println();
			//out1.close();
			out.println("###");
			out.println("Links");
			out.println("###");
		 for (String unique : linesl) {
			 	
			 	out.println("N-"+count+"-"+unique);
		        out.println();
		        count++;
		    }
		 out.println("###");
		 out.println("Images");
		 out.println("###");
		 for (String unique : linesi) {
			 	
			 	out.println("N-"+count2+"-"+unique);
		        out.println();
		        count2++;
		    }
		 out.close();
	
	}}


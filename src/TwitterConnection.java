
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

public class TwitterConnection  {
	
	public static void main(String[] args)  {
	
		ConfigurationBuilder cf = new ConfigurationBuilder();

		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("cdOyeIK55Y8FglRC4aGK3iBqK")
		.setOAuthConsumerSecret("4W3Ca2q65T5EtIqFLA2dlSNNrFDNeAU1hoOttlcTpQx5Wo4P8a")
		.setOAuthAccessToken("113387734-yyaHwxQzB1wotWZvRhtY7WeflBZwG2Xx0lPqAIPt")
		.setOAuthAccessTokenSecret("VulUb2tSe4RnOa97leJDdZx7QZQHDnLXwKy4bkLaTwjyD")
		.setJSONStoreEnabled(true);
		
		
		
		
		
		
		TwitterFactory tf = new TwitterFactory(cf.build());
		Twitter twitter = tf.getInstance();
		
	        try {
	            Query query = new Query("#ModiInMalaysia");
	            QueryResult result;
	            PrintWriter out = new PrintWriter("c:\\Hadoop\\TwitterJson_ModiInMalaysia3.json");
	            do {
	                result = twitter.search(query);
	                
	                List<Status> tweets = result.getTweets();
	                for (Status tweet : tweets) {
	                    //System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
	                	
	                	/*System.out.println("-----------------------------");
	                	System.out.println(tweets.size());
	                    System.out.println(tweet.getText());
	                    System.out.println(TwitterObjectFactory.getRawJSON(tweet)); */
	                	out.println(TwitterObjectFactory.getRawJSON(tweet));
	                } 
	                Thread.sleep(60000);
	            } while ((query = result.nextQuery()) != null);
	            out.close();
	            System.exit(0);
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to search tweets: " + te.getMessage());
	            System.exit(-1);
	        } catch (Exception e){
	        	e.printStackTrace();
	        		        	
	        }
		

		}
		
	}
	
	



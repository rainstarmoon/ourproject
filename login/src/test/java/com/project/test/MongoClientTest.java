package com.project.test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoClientTest {

	@Test
	public void clientTest() {
		try {
            ServerAddress serverAddress = new ServerAddress("192.168.1.111",27017);  
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
            addrs.add(serverAddress);  
              
            MongoCredential credential = MongoCredential.createMongoCRCredential("root", "admin", "root".toCharArray());  
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
            credentials.add(credential);  
              
            MongoClient mongoClient = new MongoClient(addrs,credentials);  
              
            MongoDatabase database = mongoClient.getDatabase("ourproject");  
            
			MongoCollection<Document> collection = database.getCollection("t_user");
			
			FindIterable<Document> find = collection.find();
			MongoCursor<Document> iterator = find.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

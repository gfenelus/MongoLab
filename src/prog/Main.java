package prog;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.io.BsonOutput;

import java.util.ArrayList;
import java.util.List;;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");
        connectDB();

    }
    public static void connectDB(){
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        MongoDatabase test = mongo.getDatabase("test");
        MongoCollection<Document> people = test.getCollection("people");

        System.out.println(people.find().first());

        //TODO make database and collection class variables before implementing CRUD methods
    }



}

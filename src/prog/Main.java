package prog;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.FindIterable;
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

    public static MongoClient mongo;
    public static MongoDatabase test;
    public static MongoCollection<Document> people;
    public static String document;
    public static String fName;
    public static String lName;


    public static void main(String[] args) {
        connectDB();
//        document = CIO.promptForString("Enter document");
//        insert(document);
//        delete();
//        updateName();
        findByName("Obama", "West");


    }
    public static void connectDB(){
        System.out.println("connecting to DB...");
        mongo = new MongoClient( "localhost" , 27017 );
        test = mongo.getDatabase("test");
        people = test.getCollection("people");

        System.out.println("First record");
        System.out.println(people.find().first());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    public static void insert(String document){

        people.insertOne(Document.parse(document));

        System.out.println("Document inserted");

    }
    public static void delete(String fName){

        String query = "{'person.first_name': '"+fName+"'}";
        people.findOneAndDelete(Document.parse(query));


    }
    public static void updateName(String fName){
        String query = "{'person.first_name': '"+fName+"'}";
        String updateName = "{$set:{'person.first_name':'Obama'}}";
        people.findOneAndUpdate(Document.parse(query), Document.parse(updateName));
    }
    public static void findByName(String fName,String lName){
        FindIterable p = null;
        //search by first name value
        System.out.println("Searching for: "+ lName +", "+fName+". ");
        String searchQuery = "{ $or: [ { 'person.first_name': '"+fName+"' }, {  'person.last_name': '"+lName+"' }]}";

        p = people.find(Document.parse(searchQuery));

        //sout first match
        System.out.println(people.find(Document.parse(searchQuery)).first());

    }

}

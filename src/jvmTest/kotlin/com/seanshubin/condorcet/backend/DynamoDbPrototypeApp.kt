package com.seanshubin.condorcet.backend

import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.model.*
import java.util.HashMap
import com.amazonaws.services.dynamodbv2.model.ListTablesResult
import com.amazonaws.services.dynamodbv2.document.TableCollection




class DynamoDbPrototype(private val client:AmazonDynamoDB){
    fun createTable(){
        val nameSchema = KeySchemaElement("name", KeyType.HASH)
        val nameAttribute = AttributeDefinition("name", ScalarAttributeType.S)
        val readCapacityUnits = 1L
        val writeCapacityUnits = 1L
        val provisionedThroughput = ProvisionedThroughput(readCapacityUnits, writeCapacityUnits)
        val createTableRequest = CreateTableRequest().
            withTableName("foo").
            withKeySchema(nameSchema).
            withAttributeDefinitions(nameAttribute).
            withProvisionedThroughput(provisionedThroughput)
        val createTableResult = client.createTable(createTableRequest)
        println(createTableResult)
    }
    fun tableExists(name:String):Boolean {
        val tables = client.listTables()
        return tables.tableNames.any{it == name}
    }
    fun deleteTable(name:String){
        client.deleteTable(name)
    }
    fun putValue(key:String, value:String){
        val attributeValue = AttributeValue(value)
        val item = mutableMapOf(Pair(key, attributeValue))
        val putItemRequest = PutItemRequest().withItem(item)
        client.putItem(putItemRequest)
    }
    fun getValue(value:String):Map<String, AttributeValue> {
        val getItemRequest = GetItemRequest().withAttributesToGet("key")
        val result = client.getItem(getItemRequest)
        return result.item
    }
    companion object {
        fun create():DynamoDbPrototype {
            val client = AmazonDynamoDBClientBuilder.
                standard().
                withRegion(Regions.US_WEST_1).
                build()
            val dynamoDbPrototype = DynamoDbPrototype(client)
            return dynamoDbPrototype
        }
    }
}

fun main(args: Array<String>) {

    val client = AmazonDynamoDBClientBuilder.
        standard().
        withRegion(Regions.US_WEST_1).
        build()
    val tableName = "my-name"
    if(!client.listTables().tableNames.contains(tableName)){
        val keySchema = arrayOf(
            KeySchemaElement("what", KeyType.HASH),
            KeySchemaElement("when", KeyType.RANGE))
        val attributeDefinitions = arrayOf(
            AttributeDefinition("what", ScalarAttributeType.S),
            AttributeDefinition("when", ScalarAttributeType.S)
        )
        val readCapacityUnits = 1L
        val writeCapacityUnits = 1L
        val provisionedThroughput = ProvisionedThroughput(readCapacityUnits, writeCapacityUnits)
        val createTableRequest = CreateTableRequest().
            withTableName(tableName).
            withKeySchema(*keySchema).
            withAttributeDefinitions(*attributeDefinitions).
            withProvisionedThroughput(provisionedThroughput)
        client.createTable(createTableRequest)
    }

    val item = mutableMapOf(
        Pair("what", AttributeValue("what-value")),
        Pair("when", AttributeValue("when-value")),
        Pair("who", AttributeValue("me")))

    val putItemRequest = PutItemRequest().withTableName(tableName).withItem(item)
    client.putItem(putItemRequest)



//    val prototype = DynamoDbPrototype.create()
//    prototype.createTable()
//    prototype.putValue("aaa", "bbb")
//    println(prototype.getValue("aaa"))
//
//    println(prototype.tableExists("foo"))
//    prototype.deleteTable("foo")
//    println(prototype.tableExists("foo"))


//    val key = HashMap<String, AttributeValue>()
//    key["Artist"] = AttributeValue().withS("No One You Know")
//    key["SongTitle"] = AttributeValue().withS("Call Me Today")
//
//    val request = GetItemRequest()
//        .withTableName("Music")
//        .withKey(key)
//
//    try {
//        val result = client.getItem(request)
//        if (result.item != null) {
//            val year = result.item["Year"]
//            println("The song was released in " + year!!.getN())
//        } else {
//            println("No matching song was found")
//        }
//    } catch (e: Exception) {
//        System.err.println("Unable to retrieve data: ")
//        System.err.println(e.message)
//    }
//
}

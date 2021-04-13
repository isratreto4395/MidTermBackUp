package databases;

import org.junit.Test;

public class UnitTestConnectDB {
    public static void main(String[] args) {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

    }

    @Test
    public void connectDatabaseTesting(){
        try{
            ConnectToSqlDB.connectToSqlDatabase();
            System.out.println("Database connected successfully");
        }catch(Exception e){
            System.out.println("Database could not connect successfully");
        }

    }

}

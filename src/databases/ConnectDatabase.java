package databases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectDatabase {

    // Secret.properties file
    // jdbc drive
    // jdbc url
    // config jdbc
    // mySqL Queries

    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;

    // Load Properties File
    public static Properties loadProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    public static Connection connectToSqlDatabase() throws IOException, ClassNotFoundException, SQLException {
        Properties prop = ConnectDatabase.loadProperties("ExtLibrary/Properties/secret.properties");
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connection = DriverManager.getConnection(url, userName, password);
        statement = connection.createStatement();
        System.out.println("Database is Connected successfully");
        return connection;
    }

    public static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection not close");
        }
    }

    private static List<String> getResultSetData(ResultSet resultSet, String columnName) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while (resultSet.next()) {
            String itemName = resultSet.getString(columnName);
            dataList.add(itemName);
        }
        return dataList;
    }

    private static List<String> getResultSetData(ResultSet resultSet, String columnName1, String columnName2) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while (resultSet.next()) {
            String itemName1 = resultSet.getString(columnName1);
            String itemName2 = resultSet.getString(columnName2);
            dataList.add(itemName1);
            dataList.add(itemName2);
        }
        return dataList;
    }

    public static List<String> readDataBase(String tableName, String columnName) throws Exception {
        List<String> data = new ArrayList<>();
        try {
            connectToSqlDatabase();// it will connect with Database
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName);
            // System.out.println(data);
            for (String dt : data) {
                System.out.println(dt);
            }
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            ConnectDatabase.close();
        }
        return data;
    }

    public static List<String> readDataBase(String tableName, String columnName1, String columnName2) throws Exception {
        List<String> data = new ArrayList<String>();
        try {
            connectToSqlDatabase();// it will connect with Database
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName1, columnName2);
            System.out.println(data);
            for (String dt : data) {
                System.out.print(dt + " ");
            }
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }

    public static void insertDataFromArrayToSqlTable(int[] arrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            preparedStatement.executeUpdate();

            for (int n = 0; n < arrayData.length; n++) {
                // Insert into tableName (columnName) values()
                preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                preparedStatement.setInt(1, arrayData[n]);
                preparedStatement.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertDataFromStringToSqlTable(String ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
            preparedStatement.setString(1, ArrayData);
            preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertProfileToSqlTable(String tableName, String columnName1, String columnName2, String name, int num) {
        try {
            connectToSqlDatabase();
            preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, num);
            preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> directDatabaseQueryExecute(String passQuery, String dataColumn) throws Exception {
        List<String> data = new ArrayList<>();
        try {
            connectToSqlDatabase();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, dataColumn);
            for (String st : data) {
                System.out.println(st);
            }
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            ConnectDatabase.close();
        }
        return data;
    }

    public static void insertDataFromArrayListToSqlTable2(List<Student1> list, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            preparedStatement.executeUpdate();
            for (Student1 st : list) {
                preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                preparedStatement.setObject(1, st);
                preparedStatement.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertDataFromArrayListToSqlTable3(List<String> list, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` varchar (200) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            preparedStatement.executeUpdate();
            for (String st : list) {
                preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                preparedStatement.setObject(1, st);
                preparedStatement.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertDataFromArrayListToSqlTable(List<String> stNameList, List<String> emailList, String tableName, String columnName, String columnName1) {
        try {
            // ALTER TABLE Customers
            //ADD Email varchar(255);
            connectToSqlDatabase();
            preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` varchar (20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            preparedStatement.executeUpdate();
            for (String st : stNameList) {
                preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                preparedStatement.setObject(1, st);
                preparedStatement.executeUpdate();
            }
            preparedStatement = connection.prepareStatement("   ALTER TABLE " + tableName + " ADD `" + columnName1 + "`varchar (200) DEFAULT NULL ");
            preparedStatement.executeUpdate();
            for (String std : emailList) {
                preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " ( " + columnName1 + " ) VALUES(?)");
                preparedStatement.setObject(1, std);
                preparedStatement.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromArrayListToSqlTable(List<Student> list, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            preparedStatement.executeUpdate();
            //ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            preparedStatement = connection.prepareStatement("CREATE TABLE `" + tableName + "` (" + columnName + " int(50) );");
            preparedStatement.executeUpdate();
            for (Student st : list) {
                preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                preparedStatement.setObject(1, st);
                preparedStatement.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static List<Movie> readUserProfileFromSqlTable1(String tableName){
        List<Movie> list= new ArrayList<>();
        Movie movie= null;
        try {
            Connection con= connectToSqlDatabase();
            String query="Select * from "+tableName+"";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int id= rs.getInt("id");
                String title= rs.getString("title");
                int releaseYear= rs.getInt("releaseYear");
                String genre= rs.getString("genre");
                String rating= rs.getString("mpaRating");
                String producer= rs.getString("producer");
                System.out.format("%s,%s,%s,%s,%s,%s\n",id,title,releaseYear,genre,rating);
                movie=new Movie(id,title,releaseYear,genre,rating);
                list.add(movie);
            }
            st.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<User> readUserProfileFromSqlTable(String tableName) throws IOException, SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        User user = null;
        try {
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM " + tableName + "";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultSet
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultSet
            while (rs.next()) {
                String name = rs.getString("title");
                String id = rs.getString("release_year");
                String dob = rs.getString("genre");
                System.out.format("%s, %s,%s\n", name, id,dob);
                user = new User(name, id, dob);
                list.add(user);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }


    public static List<User> readUserProfileFromSqlTable() throws IOException, SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        User user = null;
        try {
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM Students";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                String name = rs.getString("stName");
                String id = rs.getString("stID");
                String dob = rs.getString("stDOB");
                //System.out.format("%s, %s,%s\n", name, id, dob);
                user = new User(name, id, dob);
                list.add(user);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        //ConnectDatabase.readDataBase("movie", "title");
        // ConnectDatabase.readDataBase("movie","id","title"); // Not working as expected

        int[] number = {201, 202, 203, 204, 205, 206, 207};

        //ConnectDatabase.insertDataFromArrayToSqlTable(number,"stInfo","stNumber");

        //ConnectDatabase.readDataBase("stInfo", "stNumber");
        // ConnectDatabase.insertDataFromStringToSqlTable("Pakistan","countries","countryName");
        // ConnectDatabase.insertProfileToSqlTable("countries","countryName","countryCode","Bangladesh",88);

        //String query = "select * from movie";
        //ConnectDatabase.directDatabaseQueryExecute(query, "title");

        List<String> stName = new ArrayList<>();
        stName.add("Junaid");
        stName.add("Akbar");
        stName.add("Hashem");
        stName.add("Sharif");
        List<String> emailList = new ArrayList<>();
        emailList.add("junaid@gmail.com");
        emailList.add("akbar@gmail.com");
        emailList.add("hashem@gmail.com");
        emailList.add("sharif@gmail.com");

        // Have Issue on below two methods
       // ConnectDatabase.insertDataFromArrayListToSqlTable(stName, emailList, "StudentInformation", "studentName", "studentEmail");
        //ConnectDatabase.insertDataFromArrayListToSqlTable3(stName,"StudentInformation","studentName");

        Student1 student1=new Student1("jack","cohen","230","1");
        Student1 student2=new Student1("jack1","cohen1","330","2");
        Student1 student3=new Student1("jack2","cohen2","430","3");

        List<Student1> student1s=new ArrayList<>();
        student1s.add(student1);
        student1s.add(student2);
        student1s.add(student3);

        ConnectDatabase.insertDataFromArrayListToSqlTable2(student1s,"emailtable","stEmailList");

        //ConnectDatabase.readUserProfileFromSqlTable("movie");


    }


}

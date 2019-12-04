/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Ferrándiz Calero
 * @email sergio.ferrandiz@gmail.com
 * 
 * To create a Database the steps we have to follow are listed below:
 * 1) Load JDBC driver class
 * 2) Establish a connection with the database management system (DBMS)
 * 3) Create statement
 * 4) Create database
 */

package src.sfc.mysql;

//STEP 1. Import required packages
import java.sql.*;


public class MySQLManagement {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";      
    private final String DB_URL_WITHOUT_DB_NAME;
    private final String DB_URL_WITH_DB_NAME;
    private String DB_URL;

    //  Database credentials
    static final String USER = "root";  // "username";
    static final String PASS = "admin"; // "password";
    
    private final String FINAL_SEMICONLON_ = ";";
    private final String blankSpace_ = " ";
    
    String dataBaseName_;
    String tableName_;
    
    Connection connection_;
    Statement statement_;

    public MySQLManagement(String dataBaseName, String tableName){
        connection_ = null;
        statement_  = null;
        dataBaseName_ = dataBaseName;
        tableName_ = tableName;
        DB_URL_WITHOUT_DB_NAME = "jdbc:mysql://localhost/";
        DB_URL_WITH_DB_NAME = DB_URL_WITHOUT_DB_NAME + dataBaseName;
        DB_URL = DB_URL_WITHOUT_DB_NAME;
    }   

    
    public void DoAllNecessaryForCreatingMySqlDatabase() 
            throws SQLException, ClassNotFoundException{
        try{
            
            SetURLForDataBase();
            LoadJdbcClass();
            ConnectToDataBaseManagementSystem();
            CreateStatement();
            CreateDataBase();
            
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
           e.printStackTrace(System.out);
        }finally{
            
            CloseStatementAndConnection();
            
        }    
    }    
    
    public void DoAllNecessaryForDeletingMySqlDatabase() 
            throws SQLException, ClassNotFoundException {
        try{
            
            SetURLForDataBase();
            LoadJdbcClass();
            ConnectToDataBaseManagementSystem();
            CreateStatement();    
            DeleteDataBase();
            
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
           e.printStackTrace(System.out);
        }finally{
            
            CloseStatementAndConnection();
            
        }  
    }
    
    
    public void DoAllNecessaryForCreatingMySqlTable() 
            throws SQLException, ClassNotFoundException, Exception{
        try{
            
            SetURLForTableDataBase();
            LoadJdbcClass();
            ConnectToDataBaseManagementSystem();
            CreateStatement();
            CreateDataBaseTable();  
                    
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
           e.printStackTrace(System.out);
        }finally{
            
            CloseStatementAndConnection();
            
        }    
    }    
    
 
    public void DoAllNecessaryForDeletingMySqlTable() 
            throws SQLException, ClassNotFoundException{
        try{
            
            SetURLForTableDataBase();
            LoadJdbcClass();
            ConnectToDataBaseManagementSystem();
            CreateStatement();
            DeleteDataBaseTable();
            
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
           e.printStackTrace(System.out);
        }finally{
            
            CloseStatementAndConnection();
            
        }    
    }    
    

    public void DoAllNecessaryForInsertingNewRowIntoTable( String newRow ) 
            throws SQLException, ClassNotFoundException{
        try{
            
            SetURLForTableDataBase();
            LoadJdbcClass();
            ConnectToDataBaseManagementSystem();
            CreateStatement();
            InsertNewRowIntoTable(newRow);  
                    
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
           e.printStackTrace(System.out);
        }finally{
            
            CloseStatementAndConnection();
            
        }    
    }      
    
    
    public void DoAllNecessaryForInsertingNewColumnIntoTable(String columnToInsert, 
                                                             String columnDataType) 
            throws SQLException, ClassNotFoundException{
        try{
            
            SetURLForTableDataBase();
            LoadJdbcClass();
            ConnectToDataBaseManagementSystem();
            CreateStatement();
            InsertNewColumnIntoTable(columnToInsert, columnDataType);  
                    
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
           e.printStackTrace(System.out);
        }finally{
            
            CloseStatementAndConnection();
            
        }    
    }  
    
    
    public void DoAllNecessaryForDeletingOneColumnFromTable(String columnToDelete) 
            throws SQLException, ClassNotFoundException{
        try{
            
            SetURLForTableDataBase();
            LoadJdbcClass();
            ConnectToDataBaseManagementSystem();
            CreateStatement();
            DeleteOneColumnFromTable(columnToDelete);  
                    
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
           e.printStackTrace(System.out);
        }finally{
            
            CloseStatementAndConnection();
            
        }    
    }      
   
    
    public void DoAllNecessaryForDeletingOneRowFromTable(String rowToDelete) 
            throws SQLException, ClassNotFoundException {
        try{
            
            SetURLForTableDataBase();
            LoadJdbcClass();
            ConnectToDataBaseManagementSystem();
            CreateStatement();
            String rowIdToDelete = GetRowIdToDelete(rowToDelete);
            DeleteOneRowFromTable(rowIdToDelete);  
                    
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
           e.printStackTrace(System.out);
        }finally{
            
            CloseStatementAndConnection();
            
        }         
    }
    
    
    public void jdbcAPITestingmethods() throws SQLException, 
            ClassNotFoundException{
        /*SetURLForTableDataBase();
        LoadJdbcClass();
        ConnectToDataBaseManagementSystem();*/
        GetRowIdToDelete("Hola");
        //CreateStatement();          
        statement_ = connection_.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        System.out.println("Max rows: " + statement_.getMaxRows()); 
         
        ResultSet rs = statement_.executeQuery("SELECT * FROM TABLE_TEST");//statement_.getGeneratedKeys();      
        //rs.deleteRow();
        System.out.println("Row: " + rs.getRow());
        //TableSet mytable = null;
        //connection_.
    }
    
    
    private void SetURLForDataBase(){
       DB_URL = DB_URL_WITHOUT_DB_NAME; 
    }
    
    
    private void SetURLForTableDataBase(){
        DB_URL = DB_URL_WITH_DB_NAME;
    }
    
    
    private void ExecuteSQLInstruction(String sqlInstruction) 
            throws SQLException{
        statement_.executeUpdate(sqlInstruction);
    }
    
    private void LoadJdbcClass() throws ClassNotFoundException  {
        Class.forName(JDBC_DRIVER);
    }
          
    private void ConnectToDataBaseManagementSystem() throws SQLException{
        System.out.println("Connecting to database management system...");
        connection_ = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    
    private void CreateStatement() throws SQLException {
       System.out.println("Creating statement...");
       statement_ = connection_.createStatement();    
    }
        
    private void CreateDataBase() throws SQLException {
        String sqlStatement = "CREATE DATABASE";
        //String ddbbPath = "/home/usuario/Sergio/";
        //String sql = ddbbStatement + ddbbPath + dataBaseName + FINAL_SEMICONLON_;
        String sqlInstruction = sqlStatement + blankSpace_ + dataBaseName_ + 
                FINAL_SEMICONLON_;
        ExecuteSQLInstruction(sqlInstruction);
        System.out.println("Database " + dataBaseName_ + " created "
                + "successfully...");
    }
    
    
    private void DeleteDataBase () throws SQLException {
        String sqlStatement = "DROP DATABASE";
        String sqlInstruction = sqlStatement + blankSpace_ + dataBaseName_ + 
                FINAL_SEMICONLON_;
        ExecuteSQLInstruction(sqlInstruction);
        System.out.println("Database " + dataBaseName_ + " deleted "
                + "successfully...");                
    }
    
    
    private void CreateDataBaseTable () throws SQLException {
        String sqlStatement = "CREATE TABLE";
        String tableColumns = "(id INTEGER not NULL, " +
                              " first VARCHAR(255), " + 
                              " last VARCHAR(255), " + 
                              " age INTEGER, " + 
                              " PRIMARY KEY ( id ))";
        String sqlInstruction = sqlStatement + blankSpace_ + tableName_ + 
                blankSpace_ + tableColumns + FINAL_SEMICONLON_;
        ExecuteSQLInstruction( sqlInstruction );    
        System.out.println("Table " + tableName_ + " created successfully...");        
    }    
    
    private void DeleteDataBaseTable() throws SQLException {
        String ddbbStatement = "DROP TABLE";
        String sql = ddbbStatement + blankSpace_ + tableName_ + 
                FINAL_SEMICONLON_;
        statement_.executeUpdate( sql );    
        System.out.println("Table " + tableName_ + " deleted successfully...");             
    }
 
    
    private void InsertNewRowIntoTable ( String newRow ) throws 
            SQLException {
        String sqlStatement = "INSERT INTO";
        String columns = "(id, first, last, age)";
        String valuesKeyword = "VALUES";
        String sqlInstruction = sqlStatement + blankSpace_ + tableName_ + 
                blankSpace_ + columns + blankSpace_ + valuesKeyword + 
                blankSpace_ + newRow + FINAL_SEMICONLON_;
        ExecuteSQLInstruction( sqlInstruction );    
        System.out.println("Raw inserted successfully...");        
    }     
    
    
    private void InsertNewColumnIntoTable ( String columnToInsert, 
                                            String columnDataType ) 
            throws SQLException {
        String sqlStatement = "ALTER TABLE";       
        String addKeyword = "ADD";
        String sqlInstruction = sqlStatement + blankSpace_ + tableName_ + 
                blankSpace_ + addKeyword + blankSpace_ + columnToInsert + 
                blankSpace_ + columnDataType + FINAL_SEMICONLON_;
        ExecuteSQLInstruction( sqlInstruction );    
        System.out.println("Raw inserted successfully...");        
    }    
    
    
    private void DeleteOneColumnFromTable (String columnToDelete) 
            throws SQLException{
        String sqlStatement = "ALTER TABLE";       
        String dropKeyword = "DROP";
        String sqlInstruction = sqlStatement + blankSpace_ + tableName_ + 
                blankSpace_ + dropKeyword + blankSpace_ + columnToDelete + 
                blankSpace_ + FINAL_SEMICONLON_;
        ExecuteSQLInstruction( sqlInstruction );    
        System.out.println("Raw inserted successfully...");           
    }
    
    
    private void DeleteOneRowFromTable (String rowIdToDelete) 
                throws SQLException{
        String sqlStatement = "DELETE FROM";       
        String whereKeyword = "WHERE";
        String idColumnKeyword = "id";
        String equal = "=";
        String sqlInstruction = sqlStatement + blankSpace_ + tableName_ + 
                blankSpace_ + whereKeyword + blankSpace_ + idColumnKeyword + 
                equal + rowIdToDelete + FINAL_SEMICONLON_;
        ExecuteSQLInstruction( sqlInstruction );    
        System.out.println("Raw deleted successfully...");           
    }
    
    
    private String GetRowIdToDelete(String rowToDelete){

        String rowId = rowToDelete.substring( rowToDelete.indexOf("(")+1, 
                                              rowToDelete.indexOf(",") );
        return rowId;
    }
        
    private void CloseStatement() throws SQLException{        
        try{
           if(statement_!=null){
              statement_.close();
               System.out.println("Closing Statement");
           }                 
        }catch(SQLException se2){
            se2.getMessage();
        }       
    }
    
    
    private void CloseConnection() throws SQLException {        
        try{
           if(connection_!=null){
              connection_.close(); 
              System.out.println("Closing Connection");
           }                 
        }catch(SQLException se){
           se.printStackTrace(System.out);
        }         
    }            

    private void CloseStatementAndConnection() throws SQLException {
        CloseStatement();
        CloseConnection();
    }
    
    
}//end MySQLManagement

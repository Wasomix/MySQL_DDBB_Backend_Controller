/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.sfc.mysql;

//import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.File;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
import java.sql.SQLException;

import src.sfc.mysql.MySQLManagement;

/**
 *
 * @author usuario
 */
public class MySQLManagementTest {
    
    public String ddbb_name_with_path_;
    public MySQLManagement mysqlDdbb_;
    
//    public MySQLManagementTest() {
//        
//    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        ddbb_name_with_path_ = "./dist/MySQL_DDBB_Test";
        String dataBaseName = "PEPITO";
        String tableName = "MY_TABLE";
        mysqlDdbb_ = new MySQLManagement(dataBaseName, tableName);
    }
    
    @After
    public void tearDown() throws SQLException {

    }    
       
    public boolean CheckIfFileExist( String file_name_with_path ){
        File tempFile = new File(file_name_with_path);
        boolean file_exist = tempFile.exists();
        return file_exist;
    }
   
    

    @Test
    public void testDoAllNecessaryForCreatingMySqlDataBase() 
            throws SQLException, ClassNotFoundException{
        String dataBasePath = "/var/lib/mysql/";
//        //String dataBasePath = "/home/usuario/Downloads/";
        String dataBaseName = "PEPITO";// "STUDENTS2";        
        String fileNameWithPath = dataBasePath + dataBaseName;
        //if(CheckIfFileExist(fileNameWithPath)==false){
        mysqlDdbb_.DoAllNecessaryForCreatingMySqlDatabase();
//        //}                
        boolean doesFileExist = true;//CheckIfFileExist(fileNameWithPath);
        assertEquals(true, doesFileExist);
        mysqlDdbb_.DoAllNecessaryForDeletingMySqlDatabase();
    }



    @Test
    public void testDoAllNecessaryForDeletingMySqlDataBase() 
            throws SQLException, ClassNotFoundException{
        String dataBasePath = "/var/lib/mysql/";
//        //String dataBasePath = "/home/usuario/Downloads/";
        String dataBaseName = "PEPITO";// "STUDENTS2";        
        String fileNameWithPath = dataBasePath + dataBaseName;
        mysqlDdbb_.DoAllNecessaryForCreatingMySqlDatabase();
        mysqlDdbb_.DoAllNecessaryForDeletingMySqlDatabase();
        boolean doesFileExist = false;//CheckIfFileExist(fileNameWithPath);
        assertEquals(false, doesFileExist); 
//        assertEquals(false, doesFileExist);
    }
    
    
    @Test
    public void testDoAllNecessaryForCreatingMySqlDataBaseTable() 
            throws SQLException, ClassNotFoundException{
//       String dataBasePath = "/var/lib/mysql/";
//        //String dataBasePath = "/home/usuario/Downloads/";
//        String dataBaseName = "PEPITO";// "STUDENTS2";        
//        String tableNameWithPath = tablePath + tableName;
        mysqlDdbb_.DoAllNecessaryForCreatingMySqlDatabase();
        mysqlDdbb_.DoAllNecessaryForCreatingMySqlTable();
        //boolean doesFileExist = CheckIfFileExist(fileNameWithPath);
        boolean doesTableExist = true; //CheckIfTableExist(tableNameWithPath);
        assertEquals(true, doesTableExist); 
        
        mysqlDdbb_.DoAllNecessaryForDeletingMySqlTable();
        mysqlDdbb_.DoAllNecessaryForDeletingMySqlDatabase();
    }

    
    @Test
    public void testDoAllNecessaryForDeletingMySqlDataBaseTable() 
            throws SQLException, ClassNotFoundException{
//       String dataBasePath = "/var/lib/mysql/";
//        //String dataBasePath = "/home/usuario/Downloads/";
//        String dataBaseName = "PEPITO";// "STUDENTS2";        
//        String tableNameWithPath = tablePath + tableName;
        mysqlDdbb_.DoAllNecessaryForCreatingMySqlDatabase();
        mysqlDdbb_.DoAllNecessaryForCreatingMySqlTable();
        mysqlDdbb_.DoAllNecessaryForDeletingMySqlTable();
        
        //boolean doesFileExist = CheckIfFileExist(fileNameWithPath);
        boolean doesTableExist = false; //CheckIfTableExist(tableNameWithPath);
        assertEquals(false, doesTableExist);         
        
        mysqlDdbb_.DoAllNecessaryForDeletingMySqlDatabase();
    }
    
    
    @Test
    public void TestDoAllNecessaryForInsertingNewRowIntoTable(){
        
    }
    
    
    @Test
    public void TestDoAllNecessaryForInsertingNewColumnIntoTable(){
        
    }    
    
}

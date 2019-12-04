/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Ferrandiz Calero
 * @email sergio.ferrandiz@gmail.com
 */
package src.sfc.mysql;
//import mysql.sfc.MySQLManagement;

import java.sql.SQLException;


public class MainMySQL {
    private static MySQLManagement ddbb_mysql_;
    
    public static void main(String[] args) {
        try{
            String dataBaseName = "PEPITO";// "STUDENTS";
            String dataBaseTableName = "TABLE_TEST";
            ddbb_mysql_ = new MySQLManagement(dataBaseName, dataBaseTableName);
            String [] option = { //"Create Database", 
                                 //"Create Table",
                                 //"Insert New Row",
                                 //"Insert New Column",
                                 //"Delete One Column",
                                 "Delete One Row",
                                 //"Delete Table",
                                 //"Delete Database", 
                                 "Wiwi" };
            int numberOfOptions = option.length;
            
            for(int i=0; i < numberOfOptions; i++){
                SelectDataBaseOption(option[i]);
            }            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }
        
    private static void SelectDataBaseOption(String option) 
            throws ClassNotFoundException, SQLException, Exception{
        String [] row = { "(100, 'Zara', 'Ali', 18)",
                          "(101, 'Mahnaz', 'Fatma', 25)",
                          "(102, 'Zaid', 'Khan', 30)" };
        String column = "Email";
        String columnDataType = "varchar(255)";
        
        switch(option){
            case "Create Database":
                System.out.println("Create Database");
                ddbb_mysql_.DoAllNecessaryForCreatingMySqlDatabase();
                break;
            case "Delete Database":
                System.out.println("Delete Database");
                ddbb_mysql_.DoAllNecessaryForDeletingMySqlDatabase();
                break;
            case "Create Table":
                System.out.println("Create Table");
                ddbb_mysql_.DoAllNecessaryForCreatingMySqlTable();
                break;
            case "Delete Table": 
                System.out.println("Delete Table");
                ddbb_mysql_.DoAllNecessaryForDeletingMySqlTable();
                break;
            case "Insert New Row":
                System.out.println("Inserting New Row into Table");
                ddbb_mysql_.DoAllNecessaryForInsertingNewRowIntoTable(row[0]);
                ddbb_mysql_.DoAllNecessaryForInsertingNewRowIntoTable(row[1]);
                ddbb_mysql_.DoAllNecessaryForInsertingNewRowIntoTable(row[2]);
                break;
            case "Insert New Column":
                System.out.println("Inserting New Column into Table");
                ddbb_mysql_.DoAllNecessaryForInsertingNewColumnIntoTable(column,
                        columnDataType);
                break;
            case "Delete One Column":
                System.out.println("Deleting One Column from Table");
                ddbb_mysql_.DoAllNecessaryForDeletingOneColumnFromTable(column);
                break;      
            case "Delete One Row":
                System.out.println("Deleting One Row from Table");
                ddbb_mysql_.DoAllNecessaryForDeletingOneRowFromTable(row[0]);
                break;                 
            default:
                System.out.println("Spelling error. Please try again!!");
                ddbb_mysql_.jdbcAPITestingmethods();
                break;
        }
    }
}

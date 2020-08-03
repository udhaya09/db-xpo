package io.db.expo.serviceimpl;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;



import io.db.expo.entity.DBConnection;
import io.db.expo.entity.QueryManager;
import io.db.expo.entity.User;
import io.db.expo.repository.QueryManagerRepository;
import io.db.expo.service.ExportService;


@Service ("ExportService")
public class ExportServiceImpl implements ExportService{
	
	@Autowired
	private QueryManagerRepository qmRepo;

	@Override
	public Boolean getReportInExcel(String dBDriver, String userName, String password, String dbURL, String fileName,
			String query) {
		// TODO Auto-generated method stub
		try {
			//System.out.println("drivername:  " + dBDriver);
			//System.out.println("query:  " + query);
			//get results
		    Class.forName(dBDriver);
		    Connection con = DriverManager.getConnection(dbURL, userName, password);
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(query);
		    
		    //initiating workbook
		    XSSFWorkbook workbook = new XSSFWorkbook(); 
	        XSSFSheet sheet = workbook.createSheet("DB_EXPO_Report");
	        XSSFRow rowHead = sheet.createRow((short)0);
	        
	        //get column count
	        int columnCount = rs.getMetaData().getColumnCount();
	        
	        //create header row
	        for (int i = 0; i < columnCount; i++) {
				rowHead.createCell((short)i).setCellValue(rs.getMetaData().getColumnLabel(i+1));
			}
	        
	        //writing result records
	        int i = 1;
		    while (rs.next()){
		        XSSFRow row = sheet.createRow((short) i);
		        for (int j = 0; j < columnCount; j++) {
		        	row.createCell((short)j).setCellValue(rs.getString(j+1));
				}		        
		        i++;
		    }
		    
		    //writing and saving the file
		    FileOutputStream fileOut = new FileOutputStream(fileName);
		    workbook.write(fileOut);
		    fileOut.close();
		    System.out.println("Excel report generated successfully!!");
		    return true;
		} catch (ClassNotFoundException e1) {
		       e1.printStackTrace();
		    } catch (SQLException e1) {
		        e1.printStackTrace();
		    } catch (FileNotFoundException e1) {
		        e1.printStackTrace();
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }
		return false;
	}

	public List<QueryManager> findAllReports(User currentLoggedInUser) {
		// TODO Auto-generated method stub
		List<DBConnection> connections = currentLoggedInUser.getDbConnections();
		return qmRepo.findAllByConnections(connections);
	}

	
	
}

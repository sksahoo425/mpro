package Gen.com.mpro.business_methods;

import java.beans.PropertyChangeEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.internal.junit.ArrayAsserts;

public class ReadObject {
	static HashMap<String, String> newObject;
	static HashMap<String, String> newattributes;
	static HashMap<String, String> newObjectName;
	static HashMap<String, String> oldObject;
	static HashMap<String, String> oldObjectComments;

	public static void main(String[] args) {
		String path = ""; // .src/test/resorce/Database/accelator.xlsx
		newObjectName = new HashMap<String, String>();
		newObject = new HashMap<String, String>();
		newattributes = new HashMap<String, String>();
		File file = new File(path);

		FileInputStream inputstrem;
		try {
			inputstrem = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(inputstrem);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			System.out.println(rowCount);
			Row row = sheet.getRow(0);
			String objectName = null, attribute = null, fieldType = null;
			int colCount = row.getLastCellNum();
			for (int i = 1; i <= rowCount; i++) {
				String fieldText = null;
				row = sheet.getRow(i);
				System.out.println(row.getCell(1).getStringCellValue());
				if (!(row.getCell(0) == null || row.getCell(0).toString().isEmpty())) {
					fieldText = row.getCell(0).getStringCellValue();
				}
				if (!(row.getCell(1) == null)) {
					fieldText = row.getCell(1).getStringCellValue();
				}
				if (!(row.getCell(2) == null || row.getCell(2).toString().isEmpty())) {
					attribute = "ID";
					fieldText = row.getCell(2).getStringCellValue();
				} else if (!(row.getCell(3) == null || row.getCell(3).toString().isEmpty())) {
					attribute = "name";
					fieldText = row.getCell(3).getStringCellValue();
				} else if (!(row.getCell(5) == null || row.getCell(5).toString().isEmpty())) {
					attribute = "Class";
					fieldText = row.getCell(5).getStringCellValue();
				} else if (!(row.getCell(9) == null || row.getCell(9).toString().isEmpty())) {
					attribute = "Link";
					fieldText = row.getCell(9).getStringCellValue();
				} else if (!(row.getCell(10) == null || row.getCell(10).toString().isEmpty())) {
					attribute = "Xpath";
					fieldText = row.getCell(10).getStringCellValue();
				}
				newObject.put(objectName, fieldType);
				newattributes.put(objectName, attribute);
				if (!(newObjectName.containsKey(objectName))) {
					if (newObjectName.containsValue(fieldText)) {
						fieldText = fieldText + "_" + objectName;
						newObjectName.put(objectName, fieldText);
					} else {
						newObjectName.put(objectName, fieldText);
					}
				}

			}

			for (Entry<String, String> entry : newObject.entrySet()) {
				System.out.println(entry.getKey() + "_" + entry.getValue());
			}
			for (Entry<String, String> entry : newattributes.entrySet()) {
				System.out.println(entry.getKey() + "_" + entry.getValue());

			}
			changeClass();
			mapComparison();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void changeClass() {
		// TODO Auto-generated method stub
		String className = "OjectRepository";
		oldObject = new HashMap<String, String>();
		oldObjectComments = new HashMap<String, String>();
		String indexValues = null;
		File javaFile = new File("	" + className + ".java"); // ./src/test/java/Object_Repositary/

		try {
			BufferedReader br = new BufferedReader(new FileReader(javaFile));
			String st;
			while ((st = br.readLine()) != null) {
				String sPrefix = "public static final By";

				if (st.contains(sPrefix)) {
					int len = sPrefix.length();
					String variable = st.substring(len);
					System.out.println(variable);
					String variablekey = variable.substring(1, variable.indexOf("")).trim(); // ........................
					String variablevalue = variable.substring(variable.indexOf("") + 1).trim(); // ........................
					oldObject.put(variablekey.trim(), variablevalue.trim());
					oldObjectComments.put(variablekey.trim(), indexValues);

				} else {
					if (!st.isEmpty()) {
						indexValues = st;
					}
				}

			}

			for (Entry<String, String> entry : oldObject.entrySet()) {
				System.out.println(entry.getKey() + "-" + entry.getValue());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void mapComparison() {   // error starts from hear 
		// TODO Auto-generated method stub
		String comparisonValue = null;
		String className = "ObjectRepisitory";
		ArrayList<String> newlist = new ArrayList<String>();
		HashMap<String, String> proportyChange = new HashMap<String, String>();
		File javaFile = new File("./src/test/test/java/object_Repository/" + className + ".java");

		for (String k : newObject.keySet()) {
			if (!(newObjectName.get(k) == null || newObjectName.get(k).isEmpty())) {
				if (!oldObject.containsKey(newObjectName.get(k))) {
					System.out.println(k);
					newlist.add(k);
				}
			} else  {
				

				System.out.println(oldObject.get(newObjectName.get(k)) + "------------" + comparisonValue.toString());

				if (!oldObject.get(newObjectName.get(k)).equalsIgnoreCase(comparisonValue.toString())) {
					oldObject.put(newObjectName.get(k), comparisonValue);
					proportyChange.put(newObjectName.get(k), "Yes");
				}

			
			
			   else { if (!oldObject.containsKey(k)) { System.out.println(k);
			  newlist.add(k);
			  
			  } 
			  
			 
			  
			  System.out.println(oldObject.get(k)+" -------- "+comparisonValue.toString());
			  if(!oldObject.get(k).equalsIgnoreCase(comparisonValue.toString())) {
			//  oldObject.put(k, comparisonValue); PropertyChangeEvent.pu(k,"Yes");
			  
			  }
			  
			  
			  }
			 
		}

	}

}
	}


package com.comcast.crm.ipathconstant;
/**
 * 
 * @author Akash Deb
 *
 */
public interface IPathConstant {
	
	String PROPERTY_FILE_PATH = "./src/main/resources/commonData.properties";
	String EXCEL_FILE_PATH = "./src/test/resources/testData/Test_Script_Data_Vtiger.xlsx";
	
	int IMPLICIT_WAIT = 20;
	int EXPLICIT_WAIT = 20;
	
	String LEAD_SHEAT_NAME = "Lead";
	String ORGANIZATION_SHEAT_NAME = "Organization";
	String CAMPAIGN_SHEAT_NAME = "Campaign";
	String OPPORTUNITY_SHEAT_NAME = "Opportunity";
	String CONTACT_SHEAT_NAME = "Contact";

	
	String DB_URL = "jdbc:mysql://localhost:3306/vtiger";
	String DB_USERNAME = "root";
	String DB_PASSWORD = "root";

	
}

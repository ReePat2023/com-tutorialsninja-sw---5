package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "credentials")
    public Object[][] getData(){
        Object[][] data =new Object[][]{
                {"Riya", "Patel", "reemexperts@gmail.com","478784453", "Riya123", "Riya123"},
        };
        return data;
    }


    @DataProvider(name = "details")
    public Object[][] getData1(){
        Object[][] data =new Object[][]{
                {"reemexperts@gmail.com", "Riya123"},
        };
        return data;
    }

}

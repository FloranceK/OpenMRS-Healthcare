package com.healthcare.executepageclasses;

import org.testng.annotations.Test;

import utilities.ExcelRead;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderLogin {
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }

	@DataProvider()
	public Object[][] dp() throws IOException {
		return new Object[][] { new Object[] {ExcelRead.getStringData(2, 1) , ExcelRead.getStringData(3, 1) }, 
	    };
	  }
  @DataProvider(name = "unsucessfulLogin")
  public Object[][] dp1() throws IOException {
    return new Object[][] {
      new Object[] { ExcelRead.getStringData(2, 4) , ExcelRead.getStringData(3, 4) },
      new Object[] { ExcelRead.getStringData(2, 5) , ExcelRead.getStringData(3, 5)  },
      new Object[] { ExcelRead.getStringData(2, 6) , ExcelRead.getStringData(3, 6)  },
    };
  }
  
}

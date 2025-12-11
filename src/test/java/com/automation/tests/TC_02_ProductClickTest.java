package com.automation.tests;

import automation.Base.BaseClass;
import automation.pages.ProductClickPage;
import org.testng.annotations.Test;

public class TC_02_ProductClickTest extends BaseClass {
    @Test
    public void productList()
    {
        ProductClickPage pc=new ProductClickPage(driver);
        pc.PdClick();

    }
}

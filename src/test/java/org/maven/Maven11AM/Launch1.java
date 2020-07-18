package org.maven.Maven11AM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Launch1 extends Baseclass{

	public static void main(String[] args) throws IOException{
       WebDriver d = getDriver();
       loadUrl("https://www.facebook.com/");
       WebElement txtuser = d.findElement(By.id("email"));
       type(txtuser,readFromExcel(0,6));
       WebElement txtpass = d.findElement(By.id("pass"));
       type(txtpass,readFromExcel(0,4));
       WebElement btnclick = d.findElement(By.xpath("//input[@value='Log In']"));
       btnclick(btnclick);
       
	}

}

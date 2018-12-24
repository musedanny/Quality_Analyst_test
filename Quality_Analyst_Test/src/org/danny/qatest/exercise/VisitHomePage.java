package org.danny.qatest.exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class VisitHomePage {
	WebDriver driver;

	public void callDriver(){
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\RCA\\workspace\\Quality_Analyst_Test\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.bk.rw");
			visitHome();
			topNavigationMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void visitHome(){
		
		try {
			
			driver.findElement(By.xpath("/html/body/div[4]")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Personal Current")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/ul/li[2]/a")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			//// 
			driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/ul/li[3]/a")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/ul/li[4]/a")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/ul/li[5]/a")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			
			driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/ul/li[6]/a")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/ul/li[7]/a")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			
			
			System.out.println("LINKS ON OPEN ACCOUNT");
			
			List<WebElement> linksname= driver.findElement(By.xpath("/html/body/div[4]/div/div[1]")).findElements(By.tagName("a"));
			for(int i=0;i<linksname.size();i++){
				
				//System.out.println(linksname.get(i).getText());
				System.out.println(linksname.get(i).getAttribute("href"));
			}
			driver.get("https://www.bk.rw/business");
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div/p[2]/a")).click();
			
			
			
			 // USD FOREIGN EXCHANGE
			String bef_xpath="/html/body/div[4]/div/div/div[3]/table/tbody/tr[3]/td[";
			String after_xpath= "]";
			
			for(int i=5; i<=6; i++){
				
			String name=	driver.findElement(By.xpath(bef_xpath+i+after_xpath)).getText();
			System.out.println("Selling price and Buying Price are " + name);
			
			}
			
			String buyPrice= driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/table/tbody/tr[3]/td[5]")).getText();
			String sellPrice= driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/table/tbody/tr[3]/td[6]")).getText();

				
				System.out.println("Buy Price " + buyPrice);
				System.out.println("sell Price " + sellPrice);
				
				String actual= "800";
				if(sellPrice.equalsIgnoreCase(actual)){
					System.out.println("Test is Successiful");
				}
				else{
					System.out.println("Test failure Sell price not Match 800");
				}
				
				
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void topNavigationMenu(){
		try {
			driver.get("https://www.bk.rw");
			
			System.out.println("CURRENT & SAVING LINK");
			List<WebElement> linkName= driver.findElement(By.xpath("//*[@id='nav']/div/div/div[2]/ul[1]/li[2]")).findElements(By.tagName("a"));
			//for(int i=0;i<linkName.size();i++){
			for(int i=0;i<1;i++){
				
				System.out.println(linkName.get(i).getAttribute("href"));
			}
			
			
			driver.findElement(By.xpath("//*[@id='nav']/div/div/div[2]/ul[1]/li[2]")).click();
			Thread.sleep(5000);			
			driver.findElement(By.xpath("//*[@id='nav']/div/div/div[2]/ul[1]/li[2]/ul/li[2]/ul/li[2]/a")).click();
			Thread.sleep(3000);	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		VisitHomePage mytest= new VisitHomePage();
		mytest.callDriver();
				

	}

}

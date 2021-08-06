package mainproject;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drop_down {
	
	private static Alert alert;

	public static void main(String arg[]) throws InterruptedException {
		
            System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    
//--------------------------------------------URL check------------------------------------------------//
		
			String dhivya = "https://www.testandquiz.com/selenium/testing.html";
			driver.get(dhivya);
            driver.manage().window().maximize();
			
//-------------------------------------------Link check-------------------------------------------//
            try { 
            	
                WebElement link = driver.findElement(By.xpath("/html/body/div/div[4]/div/p/a"));
			    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			    link.click();
			    Thread.sleep(500);
		 
			    String ExpectedLink = "https://www.javatpoint.com/";
    			String ActualLink =driver.getCurrentUrl();  		
    			
    			Assert.assertEquals(ActualLink,ExpectedLink);
    			System.out.println("pass");
    		}
    		catch(AssertionError e){			
    			System.out.println("fail");			
    		}  
            	driver.navigate().back();
            	
 //-------------------------------------Text box check---------------------------------------------//
            	
            	try {
			    WebElement text_box = driver.findElement(By.cssSelector("#fname"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			    boolean text_enabled = text_box.isEnabled();
			    System.out.println(text_enabled);
	              
	              if( text_enabled==true )
	              {
	                 System.out.println("Element is enabled");
	                 text_box.click();
					 text_box.clear();
					 text_box.sendKeys("amdkjjf3857#$");
					 Thread.sleep(500);
	              }
	              else
	                 System.out.println("Element is not enabled");
	              
				
				 String expected = "amdkjjf3857#$";
				 String actual= text_box.getAttribute("value");
 
				 Assert.assertEquals(actual,expected);
				 System.out.println("pass");
            	}
            	catch(AssertionError e){
            		
            		System.out.println("fail");	
            	}
								 
//-------------------------------------Button check----------------------------------------------//
            	try {
				 WebElement button = driver.findElement(By.cssSelector("#idOfButton"));
				 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	              
	              if( button.isEnabled() )
	              {
	                 System.out.println("Button is enabled");
	                 button.click();
					 Thread.sleep(500);
	              }
	              else
	                 System.out.println("Button is not enabled");
				 
				 String exp_btn = "background: green;";
				 String act_btn= button.getAttribute("style");
				
				 Assert.assertEquals(act_btn,exp_btn);
				 System.out.println("pass");
            	}
            	catch(AssertionError e){
            		
            		System.out.println("fail");	
            	}
				 
//----------------------------------Radio button female is check----------------------------------------// 
				  
				 WebElement female_button = driver.findElement(By.cssSelector("#female"));
				 WebElement male_button = driver.findElement(By.cssSelector("#male"));
			     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			     male_button.click();
			     
			     try {
						
						if(male_button.isEnabled() && female_button.isEnabled()) {
						
							String MaleType     = male_button.getAttribute("type");
							String FemaleType   = female_button.getAttribute("type");
							String ExpectedType = "radio";
						
								if((MaleType.equals(ExpectedType))&&(FemaleType.equals(ExpectedType))) {
					
									Thread.sleep(500);	
									male_button.click();
									Thread.sleep(500);
							 
										if((male_button.isSelected() == true) && (female_button.isSelected() == false)) {
						
								 			Thread.sleep(500);
								 			System.out.println("Male radio button is selected");
								 			}	
								 			else {
						
								 				System.out.println("Input type is not a Radio");
								 				}
										}else {
								
									
											System.out.println("Input type is not a Radio");
										}
									}else {
							
										System.out.println("Radio button is diabled");
							
									}
						   Assert.assertTrue(male_button.isSelected());
						  System.out.println("Male Radio button test passed");
						  System.out.println("");
			    	 
//---------------------------------------
						  
//						  driver.navigate().refresh();
							
						  WebElement male_box= driver.findElement(By.cssSelector("#male"));
						     WebElement female_box= driver.findElement(By.cssSelector("#female"));
							Thread.sleep(200);
							
							
							if(male_box.isEnabled() && female_box.isEnabled()) {
								
								String MaleType     = male_box.getAttribute("type");
								String FemaleType   = female_box.getAttribute("type");
								String ExpectedType = "radio";
							
								if((MaleType.equals(ExpectedType))&&(FemaleType.equals(ExpectedType))) {
							
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
									female_box.click();
									Thread.sleep(500);
							 
								 		if((male_box.isSelected() == false) && (female_box.isSelected() == true)) {
								
								 			Thread.sleep(500);
								 			System.out.println("Female radio button is selected");
								 			
								 			}	
								 			else {
								
								 				System.out.println("Input type is not a Radio");
								 				System.out.println("");
								 			}
									}else {
										
											
												System.out.println("Input type is not a Radio");
												System.out.println("");
									}
								}else {
									
										System.out.println("Radio button is diabled");
										System.out.println("");
										
									
								}
								
								Assert.assertTrue(female_box.isSelected());
								
								System.out.println("Female radio button test passed");
								System.out.println("");
							
							}catch(AssertionError e) {
								
								
								System.out.println("Radio button test failed");
								System.out.println("");
							}
	 
				 
//--------------------------------------- check box check------------------------------// 
			     WebElement check_box1 = driver.findElement(By.cssSelector(".Automation "));
				 WebElement check_box2 = driver.findElement(By.cssSelector(".Performance "));	
			     driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	              
	              if(  check_box1.isEnabled() )
	              {
	                 System.out.println("Check box is enabled");
	                 check_box1.click();
					 Thread.sleep(500);
	              }
	              else
	                 System.out.println("Check box is not enabled");
	              
				 
				 if( check_box1.isSelected() && (check_box2.isSelected() == false)  )
	              {
	                 System.out.println("Automation Testing is selected");
	              }
	              else
	                 System.out.println("Automation Testing is not selected");

//.....................................Testcase-2.......................................//
				 
//				 driver.navigate().refresh();
					
				     WebElement automation_box1 = driver.findElement(By.cssSelector(".Automation "));
					 WebElement performance_box2 = driver.findElement(By.cssSelector(".Performance "));	
				     driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		              
		              if(  performance_box2.isEnabled() )
		              {
		                 System.out.println("Check box is enabled");
		                 performance_box2.click();
						 Thread.sleep(500);
		              }
		              else
		                 System.out.println("Check box is not enabled");
		              
					 
					 if( performance_box2.isSelected() && (automation_box1.isSelected() == false)  )
		              {
		                 System.out.println("Performance Testing is selected");
		              }
		              else
		                 System.out.println("Performance Testing is not selected");
				 
//--------------------------------------------Test-3-----------------------------------//
					 
//					 driver.navigate().refresh();
						
				     WebElement automation = driver.findElement(By.cssSelector(".Automation "));
					 WebElement performance = driver.findElement(By.cssSelector(".Performance "));	
				     driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		              
		              if( (automation.isEnabled() == true) && (performance.isEnabled() == true)  )
		              {
		                 System.out.println("Check box is enabled");
		                 automation.click();
		                 performance.click();
						 Thread.sleep(500);
		              }
		              else
		                 System.out.println("Check box is not enabled");
		              
					 
					 if( performance.isSelected() && (automation.isSelected())  )
		              {
		                 System.out.println("Automation and Performance check box is selected");
		              }
		              else
		                 System.out.println("Performance Testing is not selected");
					 
//-----------------------------------------------Test-4----------------------------------------//
					 
//					 driver.navigate().refresh();
//						
				     WebElement automation_1 = driver.findElement(By.cssSelector(".Automation "));
					 WebElement performance_2 = driver.findElement(By.cssSelector(".Performance "));	
				     driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		              
		              if( (automation_1.isEnabled() == false) && (performance_2.isEnabled() == false)  )
		              {
		                 System.out.println("Check box is enabled");
		                 automation_1.click();
		                 performance_2.click();
						 Thread.sleep(500);
		              }
		              else
		                 System.out.println("Check box is not enabled");
		              
					 
		              if((automation_1.isSelected()) == false && (performance_2.isSelected() == false))
		              {
		                 System.out.println("Automation and Performance check box is not selected");
		              }
		              else
		                 System.out.println("Performance and performance check box is not selected");
				 
				 
//---------------------------------------Drop_down check--------------------------------------//	
		              
				 WebElement dropdown = driver.findElement(By.id("testingDropdown")); 
				 
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					 if( dropdown.isEnabled() )
		              {
		                 System.out.println("Drop down is enabled");
		                 dropdown.click();
						 Thread.sleep(500);
		              }
		              else
		                 System.out.println("Drop down is not enabled");
					    
				    WebElement manual = driver.findElement(By.id("manual")); 
					 
				    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
						
				    manual.click();
	
	              

//-----------------------------------Double-click to generate alert box check---------------------------------//			 
				
				Actions action = new Actions(driver);
				WebElement btn = driver.findElement(By.id("dblClkBtn"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				  
	              if( btn.isEnabled() )
	              {
	                 System.out.println("Button is enabled");
	                 action.doubleClick(btn).perform();
					 Thread.sleep(500);
	              }
	              else
	                 System.out.println("Button is not enabled");
				     driver.switchTo().alert().accept(); 
				     
				     if( btn.isDisplayed() )
		              {
		                 System.out.println("hi, JavaTpoint Testing");
		              }
		              else
		                 System.out.println("Fail");
				
				     
//-------------------------------------Generate alert box check------------------------------------------//				
				
                Actions act = new Actions(driver);
				WebElement box = driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				  
	              if( box.isEnabled() )
	              {
	                 System.out.println("Button is enabled");
	                 action.click(box).perform();
					 Thread.sleep(500);

	              }
	              else
	                 System.out.println("Button is not enabled");
				     driver.switchTo().alert().accept(); 
				     
				     if( box.isDisplayed() )
		              {
		                 System.out.println("hi, JavaTpoint Testing");
		              }
		              else
		                 System.out.println("Fail");
				
//-----------------------------------Generate confirm box check----------------------------------------//
				
                Actions confirm = new Actions(driver);
				WebElement generate_confirm = driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			
	              if( generate_confirm.isEnabled() )
	              {
	                 System.out.println("Button is enabled");
	                 action.click(generate_confirm).perform();
					 Thread.sleep(500);
	              }
	              else
	                 System.out.println("Button is not enabled");
				     driver.switchTo().alert().accept(); 
				     
				     if( generate_confirm.isDisplayed() )
		              {
		                 System.out.println("Press a button!");
		              }
		              else
		                 System.out.println("Fail");

				  

	}

	}

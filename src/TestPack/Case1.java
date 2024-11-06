	package TestPack;

	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Case1 {
		
		@SuppressWarnings("deprecation")
		@Test(groups="groupname")
		public void URLhit()
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
			driver.findElement(By.id("nav-link-accountList")).click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.findElement(By.className("a-input-text")).sendKeys("number");
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys("password");
			driver.findElement(By.id("signInSubmit")).click();
			String Name = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
			System.out.println(Name + " " + " Loged-in Succesfully");
			//
			String OfferOptions = driver.findElement(By.id("nav-main")).getText();
			System.out.println(OfferOptions);
			System.out.println("This is Offer Options available");
			//
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Minimalist Face Serum");
			driver.findElement(By.id("nav-search-submit-button")).click();
			//
			driver.findElement(By.xpath("//span[text()='Get It in 2 Days']")).click();
			System.out.println("As per your selection, Your Order delivery in 2 days");
			driver.findElement(By.xpath("//span[text()='Minimalist']")).click();
			System.out.println("Your Successfully selected Minimalist brand");
			driver.findElement(By.xpath("//span[text()='Eligible for Pay On Delivery']")).click();
			System.out.println("Your Eligible for Pay On Delivery");
			driver.findElement(By.xpath("//span[text()='All Discounts']")).click();
			System.out.println("Applied All Discounts");
			driver.findElement(By.xpath("//span[text()='Minimalist Inc']")).click();
			System.out.println("Your Seller is Minimalist Inc");
			System.out.println("Done");
			//
			List<WebElement> Products = driver.findElements(By.xpath("//*[contains(@class, 'puis-card-container')]"));
			System.out.println(Products.size()+ " " + "This is total number of products in search results");
			
			for(WebElement ele: Products) {
				String ProductPrice = ele.findElement(By.className("a-price-whole")).getText();
				System.out.println(ProductPrice);
			}
			//
			String Location = driver.findElement(By.id("glow-ingress-line2")).getText();
			assert Location.contains("5600"): "7600 is not in the string";
			System.out.println(Location + " " + "This is the location of your account");
			//
			driver.findElement(By.id("nav-hamburger-menu")).click();
			String MenuList = driver.findElement(By.cssSelector("ul.hmenu-visible")).getText();
			System.out.println(MenuList);
			System.out.println("This is Options found in BarMenu");
			//
			if(MenuList.contains("Sign Out"))
			{
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				System.out.println("Your Account has been Signed Out successfully");
			}
		}	
		@Test
		public void ExcludeMe()
		{
			System.out.println("Excluded me");
		}
		
		@BeforeTest
		public void BeforeTestAm()
		{
			System.out.println("Am Before Test");
		}
		
		@AfterTest
		public void AfterTestAm()
		{
			System.out.println("Am After Test");
		}
		@Test(dependsOnMethods= {"Dependedme"}) //1st dependedme will execute then asdf
		public void Asdf()
		{
			System.out.println("Am Asdf");
		}
		@Test
		public void Dependedme()
		{
			System.out.println("Am Depended");
		}
		@Test(enabled=false) //enabled is false test will be skipped by testNG script instead of commenting if enable is true test will be executed
		public void Enableme()
		{
			System.out.println("This test should me enable by true or false");
		}
}

package KitchenNote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

    //WebDriver
    private WebDriver driver;
    
    private WebElement webElement;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "D:\\LeeWonHee/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public Selenium() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
                
        //Driver SetUp
         ChromeOptions options = new ChromeOptions();
         options.setCapability("ignoreProtectedModeSettings", true);
         options.addArguments("headless");
         driver = new ChromeDriver(options);
        
        base_url = "https://haemukja.com/main";
        
    }
    
    public List<Category> getCategory(){
    	try {
        	driver.get(base_url);
        	WebElement click = driver.findElement(By.cssSelector("a.btn_all"));
        	click.click();
			List<WebElement> list = driver.findElements(By.cssSelector("div.menu_over ul li ul li label"));
			List<Category> set = new ArrayList<>();
			int i = 1;
			for (WebElement webElement : list) {
				Category cate = new Category();
				cate.setCategory_id(i);
				cate.setCategory_name(webElement.getText());
				set.add(cate);
				i++;
			}
			System.out.println(set);
			
    
			/*
			 * 
			 * 
			 * //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다) driver.get(base_url);
			 * 
			 * //iframe으로 구성된 곳은 해당 프레임으로 전환시킨다.
			 * driver.switchTo().frame(driver.findElement(By.id("loginForm")));
			 * 
			 * //iframe 내부에서 id 필드 탐색 webElement = driver.findElement(By.id("id")); String
			 * daum_id ="your id"; webElement.sendKeys(daum_id);
			 * 
			 * //iframe 내부에서 pw 필드 탐색 webElement = driver.findElement(By.id("inputPwd"));
			 * String daum_pw ="your pw"; webElement.sendKeys(daum_pw);
			 * 
			 * 
			 * //로그인 버튼 클릭 webElement = driver.findElement(By.id("loginSubmit"));
			 * webElement.submit();
			 */
			return set;
			
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
		return null;
    }
 
    public Set<Dto> crawl() {
 
        try {
        	driver.get(base_url);
        	int man = 10000;
        	
			List<WebElement> list = driver.findElements(By.cssSelector("ul.big_sort li a"));
			Set<Dto> set = new HashSet<>();
			ArrayList<Dto> ingre_list = new ArrayList<>();
			for (WebElement webElement : list) {
				webElement.click();
				Thread.sleep(5000);
				List<WebElement> ing_list = driver.findElements(By.cssSelector("ul.small_sort li a"));
				for (WebElement webElement2 : ing_list) {
					Dto dto = new Dto(Integer.parseInt(webElement.getAttribute("data-id")),webElement.getText(),Integer.parseInt(webElement2.getAttribute("ingre_id")),webElement2.getText());
					if(man==10000&&dto.getIng_id()==2002) {
						dto.setIng_id(dto.getIng_id()+man);
						man=0;
					}
					set.add(dto);
					System.out.println(dto);
				}
			}
			
			
        	 
			/*
			 * 
			 * 
			 * //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다) driver.get(base_url);
			 * 
			 * //iframe으로 구성된 곳은 해당 프레임으로 전환시킨다.
			 * driver.switchTo().frame(driver.findElement(By.id("loginForm")));
			 * 
			 * //iframe 내부에서 id 필드 탐색 webElement = driver.findElement(By.id("id")); String
			 * daum_id ="your id"; webElement.sendKeys(daum_id);
			 * 
			 * //iframe 내부에서 pw 필드 탐색 webElement = driver.findElement(By.id("inputPwd"));
			 * String daum_pw ="your pw"; webElement.sendKeys(daum_pw);
			 * 
			 * 
			 * //로그인 버튼 클릭 webElement = driver.findElement(By.id("loginSubmit"));
			 * webElement.submit();
			 */
			return set;
			
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
		return null;
        
        
 
    }
}

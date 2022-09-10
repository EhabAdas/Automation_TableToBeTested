import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableToBeTested {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		List <WebElement> elements = driver.findElements(By.cssSelector(".container td:nth-of-type(3)"));      //.container (the class) td(the data):n(number)th(table header)-of-type(3 the header number)
		int sum = 0;
		for (int i = 0; i < elements.size(); i++) {
			sum += Integer.parseInt(elements.get(i).getText());
		}
		String total = driver.findElement(By.id("total")).getText();
		 int tot = Integer.parseInt(total.split(":")[1].trim());
	// you can use .. int tot = Integer.parseInt(total.substring(total.indexOf(':')+1,total.length()).trim());
		if(sum == tot) {
			System.out.println("Match");
		}else {
			System.out.println("Don't mach");
		}
	}
}

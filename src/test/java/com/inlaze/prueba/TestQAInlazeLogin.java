package com.inlaze.prueba;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestQAInlazeLogin {

	// Crear objeto para instanciar el webdriver.
	private WebDriver driver;
	
	@Before
	public void setUp() {
		// Configuración y ejecución del webdriver.
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Ingresar a la web.
		driver.get("https://test-qa.inlaze.com/");
	}
	

	@Test
	public void testInlaze() {
		// Completar email / Email
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/form/div[1]/input"));
		email.clear();
		email.sendKeys("fernandoguerrero.free@gmail.com");
		
		// Contraseña / Password
		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/form/div[2]/app-password/div/input"));
		password.clear();
		password.sendKeys("F1234567e*");
		
		// Ingresar / LogIn
		WebElement loginUser = driver.findElement(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/form/button"));
		if (loginUser.isEnabled()) {
			loginUser.click();
		}
		
		// Validar que se hubiera creado el usuario.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/app-root/app-panel-root/main/section[1]/h2"), "Welcome to Lorem"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

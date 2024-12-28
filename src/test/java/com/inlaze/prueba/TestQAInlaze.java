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

public class TestQAInlaze {

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
		// Dar clic en el botón sign up.
		WebElement singUp = driver.findElement(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/span/a"));
		singUp.click();
		
		// Usamos esperas explicitas. / Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/span"), "Do you have an account? Sign in"));
		
		// Completar nombre / Fullname
		WebElement fullName = driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[1]/input"));
		fullName.clear();
		fullName.sendKeys("Fernando Guerrero");
		
		// Completar email / Email
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[2]/input"));
		email.clear();
		email.sendKeys("fernandoguerrero.free@gmail.com");
		
		// Contraseña / Password
		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[3]/app-password/div/input"));
		password.clear();
		password.sendKeys("F1234567e*");
		
		// Confirmar contraseña / Confirm Password
		WebElement ConfirmPassword = driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[4]/app-password/div/input"));
		ConfirmPassword.clear();
		ConfirmPassword.sendKeys("F1234567e*");
		
		// Crear usuario / Create user
		WebElement createUser = driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/button"));
		if (createUser.isEnabled()) {
			createUser.click();
		}
		
		// Validar que se hubiera creado el usuario.
		wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/app-root/app-toasts-container/div/app-toast[1]/div/div[2]"), "Successful registration!"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

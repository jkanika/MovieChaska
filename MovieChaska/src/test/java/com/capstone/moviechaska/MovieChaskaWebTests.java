//package com.capstone.moviechaska;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//
//class MovieChaskaWebTests {
//
//	final String siteURL = "https://localhost:4200/";
//	final String driverPath = "driver/geckodriver";
//	WebDriver driver;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		// setup up
//		System.setProperty("webdriver.gecko.driver", driverPath);
//		driver = new FirefoxDriver();
//		driver.get(siteURL);
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		// close driver
//		driver.close();
//	}
//
//	@Test
//	@DisplayName("Application SignIn Test")
//	void testSignInLink() {		
//		//find mobile link
//		WebElement signin = driver.findElement(By.id("signin"));
//		// test evaluation
//		assertTrue(signin.isDisplayed());
//		assertTrue(signin.isEnabled());
//		// click action
//		signin.click();	
//		String expected = "Movie Chaska";
//		assertEquals(expected, driver.getTitle());
//	}
//	
//	@Test
//	@DisplayName("Application SignUp Test")
//	void testSignUpLink() {		
//		//find mobile link
//		WebElement signin = driver.findElement(By.id("signup"));
//		// test evaluation
//		assertTrue(signin.isDisplayed());
//		assertTrue(signin.isEnabled());
//		// click action
//		signin.click();	
//		String expected = "Movie Chaska";
//		assertEquals(expected, driver.getTitle());
//	}
//}

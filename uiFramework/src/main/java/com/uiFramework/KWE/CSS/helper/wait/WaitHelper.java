package com.uiFramework.KWE.CSS.helper.wait;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.KWE.CSS.helper.logger.LoggerHelper;

public class WaitHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
	}
		public void setImplicitWait(long timeout, TimeUnit unit)
	{
			log.info("In=mplicit wait has beed set to "+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
		
	}
		
		private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec)
		{
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(ElementNotVisibleException.class);
			wait.ignoring(StaleElementReferenceException.class);
			wait.ignoring(NoSuchFrameException.class);
			return wait;
		}

		public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec)
		{
			log.info("waiting for :"+element.toString()+" for :"+timeOutInSeconds+" seconds");
			WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("element is visible");
		}
		
		public void WaitForElementClickable(WebElement element, int timeOutInSeconds)
		{
			log.info("waiting for :"+element.toString()+" for :"+timeOutInSeconds+" seconds");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			log.info("element is clickable now");
		}

		public void WaitForframeToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds)
		{
			log.info("waiting for :"+element.toString()+" for :"+timeOutInSeconds+" seconds");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			log.info("Frame is availabe and switched");	
		}
}

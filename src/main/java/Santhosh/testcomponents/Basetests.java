package Santhosh.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import SanFrameworkPractice.Pageobjectmodel.Page1Login;

public class Basetests {

	protected  WebDriver d = null;
	public  WebDriver initializetest() throws IOException {
		
		
		//for Chrome
		Properties ps = new Properties();
		String path = "C:\\Users\\santh\\eclipse-workspace\\SaleniumFramework1\\src\\main\\java\\GloablDatas\\Datas.properties";
		FileInputStream Fis = new FileInputStream(path);
		ps.load(Fis);
		String Browsername = ps.getProperty("browser");
		
		if(Browsername.equals("chrome"))
		{
		 d = new ChromeDriver();
		 
		}
		else if(Browsername.equals("firefox")) {
			//firefox code
		}
		
		else if(Browsername.equals("edge")) {
			//edge code
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		return d;
		
		
	}
	
	public  Page1Login LaunchURL() throws IOException {
	d=	initializetest();
	Page1Login p1 = new Page1Login(d);
	p1.gotoURL();
	return p1;
	}
}

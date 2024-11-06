package TestPack;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener{

		public void ontestfailure(ITestResult result)
		{
			System.out.println("OOPs Test is Failed you can capture SS by implementing code");
		}
	}
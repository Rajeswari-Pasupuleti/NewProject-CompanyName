package wrappers;

public interface Wrapper {

	public void invokeApp(String BrowserName,String URL);
	
	public void enterByXPath(String xpath,String text);
	
	public void clickByXPath(String xpath);
	
	public void closeWindow();
	
	public void closeAllWindows();
	
}

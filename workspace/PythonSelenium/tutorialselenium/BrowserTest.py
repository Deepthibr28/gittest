from selenium import webdriver
import unittest
import time

class BrowserTest(unittest.TestCase):
    def setUp(self):
        driver= webdriver.Chrome("C:\\Users\\Arjun BR\\workspace\\Downloads\\drivers\\chromedriver.exe");
        driver.implicitly_wait(2)
        driver.maximize_window()
        self.driver=driver
        
    def test_method(self):
        self.driver.get("http://www.letskodeit.com/")
        title= self.driver.title
        print ("Title of the page is: " + title)
        currentUrl= self.driver.current_url
        print ("Current URL is: " + currentUrl)
        urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?reset_purchase_session=1";
        self.driver.get(urlToNavigate)
        time.sleep(2)
        self.driver.back()
        currentUrl= self.driver.current_url
        print ("Current URL is: " + currentUrl)
        time.sleep(2)
        self.driver.forward()
        currentUrl= self.driver.current_url
        print ("Current URL is: " + currentUrl)
        time.sleep(2)
        self.driver.refresh()
        print("Navigate Refresh")
        #pageSource = self.driver.page_source
        #print(pageSource)
        
        
        
    def tearDown(self):
        time.sleep(2)
        self.driver.quit()
        
        
        
if __name__=='__main__':
    unittest.main()
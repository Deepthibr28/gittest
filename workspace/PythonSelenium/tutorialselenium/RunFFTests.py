from selenium import webdriver
#from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
#from selenium.webdriver.firefox.firefox_binary import FirefoxBinary

# Problem faced: upgraded selenium version to 2.53.6 "address isnt valid"
# pip show selenium 
# pip install selenium ==2.53.6
class RunFFTests():

    def test(self):
        # Instantiate FF Browser Command
        #binary=FirefoxBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")
        #driver = webdriver.Firefox(firefox_binary=binary)
        driver = webdriver.Firefox()
        
        # Open the provided URL
        driver.get("http://www.google.com")
        driver.implicitly_wait(20)
        driver.quit()

ff = RunFFTests()
ff.test()
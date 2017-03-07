'''
Created on 06-Mar-2017

@author: Arjun BR
'''
import unittest
from selenium import webdriver
import time
import SearchPageFactory as searchPage
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

class Test(unittest.TestCase):


    def setUp(self):
        driver= webdriver.Firefox()
        baseUrl = "https://www.expedia.com/";
        driver.maximize_window()
        driver.implicitly_wait(2)
        self.driver=driver
        self.driver.get(baseUrl)

    def testName(self):
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("San Francisco");
        searchPage.setDepartureDate("10/28/2017");
        searchPage.setReturnDate("10/31/2017");
        searchPage.clickSearchButton();
        
        
        
    def tearDown(self):
        WebDriverWait(60).until(EC.invisibility_of_element_located((By.ID, 'acol-interstitial')))
        # WebDriverWait(driver, 10, poll_frequency=1, ignored_exceptions=[ElementNotVisibleException, ElementNotSelectableException])
        time.sleep(2)
        self.driver.quit()
       


    
if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()
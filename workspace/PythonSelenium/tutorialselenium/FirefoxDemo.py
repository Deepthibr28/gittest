'''
Created on 25-Feb-2017

@author: Arjun BR
'''
import unittest
import time
from selenium import webdriver

class Test(unittest.TestCase):


    def setUp(self):
        driver= webdriver.Firefox();
        driver.implicitly_wait(2)
        driver.maximize_window()
        self.driver=driver      


    def testFirefox(self):
        self.driver.get("http://www.facebook.com")
        
    def tearDown(self):
        time.sleep(30)
        self.driver.quit()


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testFirefox']
    unittest.main()
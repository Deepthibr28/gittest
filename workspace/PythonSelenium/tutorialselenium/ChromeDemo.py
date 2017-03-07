'''
Created on 09-Feb-2017

@author: Arjun BR
'''
import unittest
import time
from selenium import webdriver


class Test(unittest.TestCase):


    def setUp(self):
        driver = webdriver.Chrome("C:\\Users\\Arjun BR\\workspace\\Downloads\\drivers\\chromedriver.exe")
        self.driver=driver


    def tearDown(self):
        time.sleep(3)
        #self.driver.implicitly_wait(10)
        self.driver.quit()


    def testName(self):
        self.driver.get("http://www.facebook.com")


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()
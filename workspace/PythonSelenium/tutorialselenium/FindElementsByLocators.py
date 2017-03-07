'''
Created on 26-Feb-2017

@author: Arjun BR
'''
import unittest
import time
from selenium import webdriver


class FindElementByLocatorsTest(unittest.TestCase):

    def setUp(self):
        driver= webdriver.Firefox()
        baseurl1="file:///D:/Deepthi_Home/Selenium/webtesting/workspace/helloworld.html"
        baseurl2="file:///D:/Deepthi_Home/Selenium/webtesting/workspace/search.html"
        baseurl3="file:///D:/Deepthi_Home/Selenium/webtesting/workspace/links.html"
        self.baseurl1,self.baseurl2,self.baseurl3=baseurl1,baseurl2,baseurl3
        self.driver=driver
       
        
    def test_find_element_by_id(self):
        self.driver.get(self.baseurl1)
        el= self.driver.find_element_by_id("title")
        self.assertEqual(el.text,"Hello World" )
        
    
    def test_find_element_by_name(self):
        self.driver.get(self.baseurl2)
        el=self.driver.find_element_by_name("keyword")
        el.clear()
        el.send_keys("Deepthi")
        self.assertEqual(el.get_attribute("value"), "Deepthi")
        
    def test_find_element_by_class_name(self):
        self.driver.get(self.baseurl2)
        element = self.driver.find_element_by_class_name('label')
        self.assertEqual('Search', element.text)
        
    def test_find_element_by_link_text(self):
        self.driver.get(self.baseurl3)
        element = self.driver.find_element_by_link_text('Google site')
        self.assertEqual('https://www.google.com/', element.get_attribute('href'))
        
    def test_find_element_by_partial_link_text(self):
        self.driver.get(self.baseurl3)
        element = self.driver.find_element_by_partial_link_text('MSN')
        self.assertEqual('http://www.msn.com/', element.get_attribute('href'))
        
    def test_find_elements_by_tag_name(self):
        self.driver.get(self.baseurl3)
        links = self.driver.find_elements_by_tag_name('a')
        self.assertEqual(7, len(links))
        
    
    def tearDown(self):
        time.sleep(10)
        self.driver.quit()


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testid']
    unittest.main()
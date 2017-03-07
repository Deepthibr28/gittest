'''
Created on 26-Feb-2017

@author: Arjun BR
'''
import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.select import Select
#from lib2to3.tests.support import driver

class FindWebElements(unittest.TestCase):

    def setUp(self):
        driver= webdriver.Firefox()
        baseurl1="http://letskodeit.teachable.com/p/practice"
        baseurl2="http://output.jsbin.com/osebed/2"
        baseurl3="file:///D:/Deepthi_Home/Selenium/webtesting/workspace/select.html"
        self.baseurl1,self.baseurl2,self.baseurl3=baseurl1,baseurl2,baseurl3
        self.driver=driver
        
       
        
    def test_RadiobuttonAndCheckBoxes(self):
        self.driver.get(self.baseurl1)
        bmwradiobtn= self.driver.find_element_by_id("bmwradio")
        bmwradiobtn.click()
        time.sleep(2)
        benzradiobtn=self.driver.find_element_by_id("benzradio")
        benzradiobtn.click()
        time.sleep(2)
        radiolist=self.driver.find_elements_by_xpath("//input[@name='cars' and @type='radio']")
        self.assertEqual(len(radiolist), 3)
        for i in radiolist:
            print (i.get_attribute("value"))
        time.sleep(2)
        bmwchkbox=self.driver.find_element_by_id("bmwcheck")
        bmwchkbox.click()
        benzchkbox=self.driver.find_element_by_id("benzcheck")
        benzchkbox.click()
        self.assertTrue("True", benzchkbox.is_selected)
         
    
    def test_DropDowns(self):
        self.driver.get(self.baseurl1)
        sel=Select(self.driver.find_element_by_id("carselect"))
        self.assertEqual(len(sel.options), 3)
        sel.select_by_value("benz")
        time.sleep(2)
        sel.select_by_index(0)
    
        
    def test_MultiSelect(self):
        self.driver.get(self.baseurl2)
        sel=Select(self.driver.find_element_by_id("fruits"))
        self.assertEqual(sel.is_multiple, True)
        sel.select_by_visible_text("Apple")
        time.sleep(2)
        
        sel.deselect_by_value("apple")
        time.sleep(2)
        
        sel.select_by_index(3)
        sel.select_by_value("orange")
        
        print(list(sel.all_selected_options))
        time.sleep(2)
        sel.deselect_all()
        
    def test_SingleSelect(self):  
        self.driver.get(self.baseurl3)
        select = Select(self.driver.find_element_by_id('car'))
        actual_options = list(map(lambda option: option.text, select.options))
        expect_options = ['Pick a car', 'Volvo', 'Saab', 'Mercedes', 'Audi']
        self.assertListEqual(actual_options, expect_options)
        
    
    def tearDown(self):
        time.sleep(3)
        self.driver.quit()


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testid']
    unittest.main()
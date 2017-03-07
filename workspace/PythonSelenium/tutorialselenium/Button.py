import os
import unittest
from selenium import webdriver

class FindElementByIdTest(unittest.TestCase):
    def setUp(self):
        chromedriver = "C:/Users/santoshakumar/Downloads/selenium/chromedriver_win32/chromedriver"
        os.environ["webdriver.chrome.driver"] = chromedriver
        self.driver = webdriver.Chrome(chromedriver)

        #self.driver = webdriver.Firefox()
        self.driver.maximize_window()
        #base_url = 'https://selenium-testing-winwust.c9users.io/button.html'
        base_url = 'https://selenium-testing-winwust.c9users.io/input.html'
        self.driver.get(base_url)

    def test_find_element_by_id(self):
        #element = self.driver.find_element_by_id('btn')
        element = self.driver.find_element_by_id('name')
        element.getAttribute("hi")  
        element.click()
        self.assertEqual('button', element.text)
        #element = self.driver.find_element_by_id('display')
        #self.assertEqual('Hello', element.text)
        element = self.driver.find_element_by_id('btn')

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()



#import os
import unittest
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

class ExplicitlyWaitTest(unittest.TestCase):
    def setUp(self):
        #chromedriver = "C:/Users/santoshakumar/Downloads/selenium/chromedriver_win32/chromedriver"
        #os.environ["webdriver.chrome.driver"] = chromedriver
        self.driver = webdriver.Chrome("C:\\Users\\Arjun BR\\workspace\\Downloads\\drivers\\chromedriver.exe")
        self.driver.maximize_window()
        base_url = 'file:///D:/Deepthi_Home/Selenium/webtesting/workspace/jswait.html'
        self.driver.get(base_url)

    def test_click_button(self):
        name = self.driver.find_element_by_id('name')
        name.send_keys('John')
        button = self.driver.find_element_by_id('btn')
        button.click()

        WebDriverWait(self.driver, 5).until(EC.presence_of_element_located((By.ID, 'display')))
        self.assertEqual("John", self.driver.find_element_by_id('display').text)

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()

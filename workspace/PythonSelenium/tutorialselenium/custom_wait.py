import unittest
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

class CustomWaitTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()
        base_url = 'https://selenium-testing-winwust.c9users.io/jswaitec.html'
        self.driver.get(base_url)

    def test_click_button(self):
        name = self.driver.find_element_by_id('name')
        name.send_keys('John')
        button = self.driver.find_element_by_id('btn')
        button.click()

        WebDriverWait(self.driver, 5).until(lambda s: s.find_element_by_id('display').text != '')
        self.assertEqual("John", self.driver.find_element_by_id('display').text)

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()

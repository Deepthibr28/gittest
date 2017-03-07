import os
import unittest
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select

class MouseKeyTest(unittest.TestCase):
    def setUp(self):
        #self.driver = webdriver.Firefox()
        chromedriver = "resources/chromedriver"
        os.environ["webdriver.chrome.driver"] = chromedriver
        self.driver = webdriver.Chrome(chromedriver)
        self.driver.maximize_window()
        base_url = 'https://selenium-testing-winwust.c9users.io/longselect.html'
        self.driver.get(base_url)

    def test_shift_click(self):
        expected_options = ['row 2', 'row 3', 'row 4', 'row 5', 'row 6']

        options = self.driver.find_elements_by_xpath('//select/option')
        ActionChains(self.driver).click(options[1]).key_down(Keys.SHIFT).click(options[5]).key_up(Keys.SHIFT).perform()

        self.assertEqual(5, len(Select(self.driver.find_element_by_xpath('//select')).all_selected_options))

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()

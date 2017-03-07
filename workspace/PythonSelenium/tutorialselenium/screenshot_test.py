import unittest
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains

class ScreenShotTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()
        base_url = 'https://selenium-testing-winwust.c9users.io/dblclick.html'
        self.driver.get(base_url)

    def test_double_click(self):
        square = self.driver.find_element_by_id('square')
        self.driver.get_screenshot_as_file('yellow_page.png')
        self.assertEqual('rgba(255, 255, 0, 1)', square.value_of_css_property('background-color'))
        ActionChains(self.driver).double_click(square).perform()
        self.driver.get_screenshot_as_file('red_page.png')
        self.assertEqual('rgba(255, 0, 0, 1)', square.value_of_css_property('background-color'))

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()

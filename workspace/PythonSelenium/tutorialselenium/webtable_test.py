import unittest
from selenium import webdriver
from webtable import WebTable

class WebTableTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()
        self.driver.get('https://selenium-testing-winwust.c9users.io/webtable.html')

    def tearDown(self):
        self.driver.quit()

    def test_web_table(self):
        table = WebTable(self.driver.find_element_by_id('students'))
        self.assertTrue(table.has_header)
        self.assertEqual(table.row_count, 4)
        self.assertEqual(table.column_count, 4)

if __name__ == '__main__':
    unittest.main()

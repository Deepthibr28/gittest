import unittest
from ddt import ddt, data, unpack
import csv
from selenium import webdriver
from tutorialselenium.bmi_page import BmiPage

def get_csv_data(csv_path):            
        rows = []
        csv_data = open(str(csv_path), "r")
        content = csv.reader(csv_data)
        
        for row in content:
            rows.append(row)
        return rows

@ddt
class BmiPomTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()
        self.driver.get('file:///D:/Deepthi_Home/Selenium/webtesting/workspace/bmicalculator.html')
        

    
    @data(*get_csv_data('D:\Deepthi_Home\Selenium\WebTesting_UCSC\data.csv'))

    @unpack
    def test_bmi_calc(self, height, weight, bmi, category):
        driver = self.driver

        bmi_calc = BmiPage(driver)
        bmi_calc.calculate(height, weight)

        self.assertEqual(bmi, bmi_calc.bmi_value)
        self.assertEqual(category, bmi_calc.bmi_category)
        
    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()    

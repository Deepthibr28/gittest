import unittest
from ddt import ddt, data, unpack
import csv
from selenium import webdriver

def get_csv_data(csv_path):            
        rows = []
        with open(str(csv_path), "r") as csv_data:
            content = csv.reader(csv_data,delimiter=',')
            for row in content:
                rows.append(row)
            return rows

@ddt
class BmiDDTCSVTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()
        #self.driver.get('http://selenium-testing-winwust.c9users.io/bmicalculator.html')
        self.driver.get('file:///D:/Deepthi_Home/Selenium/webtesting/workspace/bmicalculator.html')
    
    
    @data(*get_csv_data('D:\Deepthi_Home\Selenium\WebTesting_UCSC\data.csv'))

    @unpack
    def test_bmi_calc(self, height, weight, bmi, category):
        driver = self.driver

        height_field = driver.find_element_by_name("heightCMS")
        height_field.clear()
        height_field.send_keys(height)

        weight_field = driver.find_element_by_name("weightKg")
        weight_field.clear()
        weight_field.send_keys(weight)

        calculate_button = driver.find_element_by_id("Calculate")
        calculate_button.click()

        bmi_label = driver.find_element_by_name("bmi")
        self.assertEqual(bmi, bmi_label.get_attribute("value"))
        
        bmi_category_label = driver.find_element_by_name("bmi_category")
        self.assertEqual(category, bmi_category_label.get_attribute("value"));

        
        
        
    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()

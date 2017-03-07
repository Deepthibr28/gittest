class BmiPage(object):
    def __init__(self, driver):
        self.driver = driver;

    @property
    def bmi_value(self):
        bmi_value_field = self.driver.find_element_by_name('bmi')
        return bmi_value_field.get_attribute('value')

    @property
    def bmi_category(self):
        bmi_category_field = self.driver.find_element_by_name('bmi_category')
        return bmi_category_field.get_attribute('value')

    def calculate(self, height, weight):
        height_field = self.driver.find_element_by_name('heightCMS')
        weight_field = self.driver.find_element_by_name('weightKg')
        calc_button = self.driver.find_element_by_id('Calculate')

        height_field.send_keys(height)
        weight_field.send_keys(weight)
        calc_button.click()

        #self.assertEqual("160", bmi_label.get_attribute("value"))
	    #self.assertEqual("45", bmi_category_label.get_attribute("value"))



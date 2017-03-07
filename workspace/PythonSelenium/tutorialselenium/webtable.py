from selenium.common.exceptions import NoSuchElementException

class WebTable(object):
    def __init__(self, table):
        self.table = table

    @property
    def row_count(self):
        return len(self.table.find_elements_by_xpath('.//tr/td/..'))

    @property
    def column_count(self):
        first_row = self.table.find_element_by_xpath('.//td/..')
        return len(first_row.find_elements_by_tag_name('td'))

    @property
    def has_header(self):
        try:
            self.table.find_element_by_css_selector('tr > th')
            return True
        except NoSuchElementException:
            return False

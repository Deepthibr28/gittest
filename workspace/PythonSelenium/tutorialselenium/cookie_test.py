import unittest

from selenium import webdriver

class CookieTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        base_url = 'https://selenium-testing-winwust.c9users.io/cookie.php'
        self.driver.get(base_url)

    def test_cookie(self):
        self.assertEqual('JohnDoe', self.driver.get_cookie('user')['value'])
        print(self.driver.get_cookies())

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()

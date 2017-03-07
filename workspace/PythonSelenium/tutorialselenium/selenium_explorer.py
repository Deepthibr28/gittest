from selenium import webdriver

driver = webdriver.Firefox()
driver.maximize_window()
driver.get('https://selenium-testing-winwust.c9users.io/xpath.html')

#element = driver.find_element_by_xpath('//ul/li[position()=3]')
#print(element.text)

script = ("var head = document.getElementsByTagName('head')[0];"
          "var newScript = document.createElement('script');"
          "newScript.type = 'text/javascript';"
          "newScript.src='https://code.jquery.com/jquery-2.2.3.min.js';"
          "head.appendChild(newScript);")

driver.execute_script(script)

elements = driver.execute_script("return jQuery.find('tr:contains(\"Toys\")')")
print(elements[0].text)

driver.quit()

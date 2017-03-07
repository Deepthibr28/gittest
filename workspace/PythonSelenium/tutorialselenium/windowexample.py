driver.get('http://www.naukri.com/')

    WebDriverWait(driver,15).until(lambda d: len(driver.window_handles)==3)

    print(driver.title)

    driver.switch_to.window(driver.window_handles[1])
    print(driver.title)

    driver.switch_to.window(driver.window_handles[2])
    print(driver.title)`

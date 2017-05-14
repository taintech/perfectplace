package com.taintech.app

import org.openqa.selenium.chrome.ChromeDriver

object MainApp extends App {

  val dubizzle =
    "https://dubai.dubizzle.com/property-for-rent/residential/apartmentflat/#filters=site.id%3A2%20AND%20category_slug_tree.lvl2%3A%27property-for-rent%20%3E%20residential%20%3E%20apartmentflat%27&page=1&configure%5BhitsPerPage%5D=25"

  System.setProperty("webdriver.chrome.driver", "/Users/rtainov/IdeaProjects/perfectplace/chromedriver")

  def iteratePages(): Unit ={
    val driver = new ChromeDriver()
    driver.get(dubizzle)
    println(driver.getTitle)
    List(4, 5, 6, 6, 6, 6, 6, 6, 6).foreach { i =>
      Thread.sleep(5000)
      driver
        .findElementByCssSelector(
          s"div.is-flex.listings-container > div.algolia-page-content.is-flex > div.hits-panel-container > div.pagination-container > ul > li:nth-child($i)")
        .click()
    }
    //  driver.quit()
  }

}

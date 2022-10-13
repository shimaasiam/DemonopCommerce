@smoke
Feature: user could follow the site through social media
  Scenario: user follow the site facebook page and verify that it opens successfully
    When user press on site "facebook" link
    Then URL "https://www.facebook.com/nopCommerce" open successfully

  Scenario: user follow the site twitter page and verify that it opens successfully
    When user press on site "twitter" link
    Then URL "https://twitter.com/nopCommerce" open successfully

  Scenario: user follow the site rss link and verify that it opens successfully
    When user press on site "rss" link
    Then URL "https://demo.nopcommerce.com/new-online-store-is-open" open successfully

  Scenario: user follow the site youtube channel and verify that it opens successfully
    When user press on site "youtube" link
    Then URL "https://www.youtube.com/user/nopCommerce" open successfully
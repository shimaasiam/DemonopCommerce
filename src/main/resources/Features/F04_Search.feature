@smoke
  Feature: Search for product
    Scenario Outline: user could search using product name and verify it in search results
      When user enter "<productName>" in search
      And user press on search button
      Then search results will have "<productName>" displayed
    Examples:
      | productName |
      |   book      |
      |   laptop    |
      |   nike      |

    Scenario Outline: user could search for product using sku and verify it in search results
      When user enter "<sku>" in search
      And user press on search button
      Then user could click on product search result
      And search result details will have "<sku>" displayed
      Examples:
      |    sku     |
      | SCI_FAITH  |
      | APPLE_CAM  |
      | SF_PRO_11  |

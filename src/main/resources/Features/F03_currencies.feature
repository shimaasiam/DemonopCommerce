@smoke
  Feature: F03_currencies| user could change currency
    Scenario: user choose Euro currency and verify symbol displayed on products
      When user select euro currency
      Then products prices will have euro symbol
Feature: Credit Payment

  @C7
  Scenario: Create Payment Credit Card
    Given user generate payment link
    When user open payment link
    When user select credit payment method
    When user input card number "4137198118415892" on credit payment page
    When user input card holder name "testing 16" on credit payment page
    When user select expireddate "12" - "2023" on credit payment page
    When user input cvv number "222" on credit payment page
    When user click button bayar on credit payment page
    Then the payment status will be success

  @C11
  Scenario: Create Payment Credit Card Not Valid Card Number
    Given user generate payment link
    When user open payment link
    When user select credit payment method
    When user input card number "4222222222222222" on credit payment page
    When user input card holder name "testing 16" on credit payment page
    When user select expireddate "12" - "2023" on credit payment page
    When user input cvv number "222" on credit payment page
    When user click button bayar on credit payment page
    Then user see error message card not valid on credit payment page

  @C12
  Scenario: Create Payment Credit Card Transaction Over Limit
    Given user generate payment link with more limit
    When user open payment link
    When user select credit payment method
    When user input card number "4137198118415892" on credit payment page
    When user input card holder name "testing 16" on credit payment page
    When user select expireddate "12" - "2023" on credit payment page
    When user input cvv number "222" on credit payment page
    When user click button bayar on credit payment page
    Then user see error message transaction will be not success on credit payment page

  @C13
  Scenario: Create Payment Credit Card Timeout Transaction
    Given user generate payment link
    When user open payment link
    When user select credit payment method
    When user input card number "4137198118415892" on credit payment page
    When user input card holder name "testing 16" on credit payment page
    When user select expireddate "12" - "2023" on credit payment page
    When user input cvv number "222" on credit payment page
    When user click button bayar on credit payment page
    Then the payment status will be success

  @C14
  Scenario: Create Payment Credit Card Not Valid CVV
    Given user generate payment link
    When user open payment link
    When user select credit payment method
    When user input card number "4137198118415892" on credit payment page
    When user input card holder name "testing 16" on credit payment page
    When user select expireddate "12" - "2023" on credit payment page
    When user input cvv number "@#Q@" on credit payment page
    When user click button bayar on credit payment page
    Then user see error message cvv not valid on credit payment page

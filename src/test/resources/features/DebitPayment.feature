Feature: Debit Payment

  @C1
  Scenario: Create Payment Debit Card
    Given user generate payment link
    When user open payment link
    When user select debit payment method
    When user input card number "41111111111111111" on debit payment page
    When user input card holder name "testing 16" on debit payment page
    When user select expireddate "12" - "2023" on debit payment page
    When user input cvv number "123" on debit payment page
    When user click button bayar on debit payment page
    Then the payment status will be success

  @C2
  Scenario: Create Payment Debit Card Not Valid Card Number
    Given user generate payment link
    When user open payment link
    When user select debit payment method
    When user input card number "42222222222222222" on debit payment page
    When user input card holder name "testing 16" on debit payment page
    When user select expireddate "12" - "2023" on debit payment page
    When user input cvv number "123" on debit payment page
    When user click button bayar on debit payment page
    Then user see error message card not valid on debit payment page

  @C3
  Scenario: Create Payment Debit Card Transaction Over Limit
    Given user generate payment link with more limit
    When user open payment link
    When user select debit payment method
    When user input card number "41111111111111111" on debit payment page
    When user input card holder name "testing 16" on debit payment page
    When user select expireddate "12" - "2023" on debit payment page
    When user input cvv number "123" on debit payment page
    When user click button bayar on debit payment page
    Then user see eror message transaction will be not success on debit payment page

  @C4
  Scenario: Create Payment Debit Card Timeout Transaction
    Given user generate payment link
    When user open payment link
    When user select debit payment method
    When user input card number "41111111111111111" on debit payment page
    When user input card holder name "testing 16" on debit payment page
    When user select expireddate "12" - "2023" on debit payment page
    When user input cvv number "123" on debit payment page
    When user click button bayar on debit payment page
    Then the payment status will be success

  @C5
  Scenario: Create Payment Debit Card Not Valid CVV
    Given user generate payment link
    When user open payment link
    When user select debit payment method
    When user input card number "41111111111111111" on debit payment page
    When user input card holder name "testing 16" on debit payment page
    When user select expireddate "12" - "2023" on debit payment page
    When user input cvv number "$#$A" on debit payment page
    When user click button bayar on debit payment page
    Then user see error message cvv not valid on debit payment page
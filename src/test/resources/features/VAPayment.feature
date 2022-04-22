Feature: VA Payment

@C8
  Scenario: Create VA Payment
    Given user generate payment link
    When user open payment link
    When user select BCA VA payment method
    When user copy VA number and pay on VA Payment Detail Page
    When user click button selesai on VA Payment Detail Page
    Then the payment status will be success

  @C9
  Scenario: Create VA Payment inquiryWithUsedCustomerNumber
    Given user generate payment link
    When user open payment link
    When user select BCA VA payment method
    Then user unable to pay using use customer number

  @C10
  Scenario: Create VA Payment PaymentVAInvalidTotalAmount
    Given user generate payment link
    When user open payment link
    When user select BCA VA payment method
    Then user unable to pay using invalid total amount

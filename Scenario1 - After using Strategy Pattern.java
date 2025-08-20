interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy { /* CreditCardPayment logic */ }
class PayPalPayment implements PaymentStrategy { /* PayPalPayment logic */ }
class CryptoPayment implements PaymentStrategy { /* CryptoPayment logic */ }

class PaymentGateway {
    private PaymentStrategy strategy;
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}
{ /*
    HOW IT WORKS
    1. Client selects a payment method (e.g., CreditCardPayment)
    2. PaymentGateway sets the strategy using setPaymentStrategy()
    3. Client calls processPayment(amount)
    4. PaymentGateway delegates to the current strategy's pay(amount) method
    5. Concrete strategy (e.g., CreditCardPayment) handles the specific payment processing
*/}

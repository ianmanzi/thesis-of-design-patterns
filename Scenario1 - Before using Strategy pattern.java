{/* The following is an example of a class used to handle payments*/}
class PaymentGateway {
    public void processPayment(String method, double amount) {
        if (method.equals("CreditCard")) { /* credit card logic */ }
        else if (method.equals("PayPal")) { /* paypal logic */ }
        else if (method.equals("Crypto")) { /* crypto logic */ }
        //... more methods
    }
}

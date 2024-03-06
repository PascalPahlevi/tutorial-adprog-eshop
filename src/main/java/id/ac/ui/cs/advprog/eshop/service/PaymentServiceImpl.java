package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Payment createPayment(Payment payment) {
        if (paymentRepository.findById(payment.getId()) == null) {
            paymentRepository.save(payment);
            return payment;
        }
        return null;
    }
    @Override
    public Payment updateStatus(String paymentId, String status) {
        Payment payment = paymentRepository.findById(paymentId);
        if (payment != null) {
            Payment newPayment = new Payment(payment.getId(), payment.getMethod(),
                    payment.getPaymentData(), status);
            paymentRepository.save(newPayment);
            return newPayment;
        } else {
            throw new NoSuchElementException();
        }
    }
    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
    @Override
    public Payment findById(String paymentId) {
        return paymentRepository.findById(paymentId);
    }
}

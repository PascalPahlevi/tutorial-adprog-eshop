package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
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
    public Payment createPaymentByVoucherCode(String voucherCode) {
        return null;
    }

    @Override
    public Payment createPaymentByBankTransfer(String bankName, String referenceCode) {
        return null;
    }

    @Override
    public Payment findById(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public String validatePaymentWithVoucherCode(String voucherCode) {
        if (isPaymentVoucherCodeValid(voucherCode)) {
            return "SUCCESS";
        } else {
            return "REJECTED";
        }
    }

    private boolean isPaymentVoucherCodeValid(String voucherCode) {
        if (voucherCode == null || voucherCode.length() != 16 || !voucherCode.startsWith("ESHOP")) {
            return false;
        }

        long digitCount = voucherCode.substring(5).chars().filter(Character::isDigit).count();

        return digitCount >= 8;
    }

    public boolean isBankTransferValid(Map<String, String> paymentData) {
        String bankName = paymentData.get("bankName");
        String referenceCode = paymentData.get("referenceCode");

        return isStringValid(bankName) && isStringValid(referenceCode);
    }

    private boolean isStringValid(String str) {
        return str != null && !str.isEmpty();
    }
}

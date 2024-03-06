package id.ac.ui.cs.advprog.eshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PaymentByBankTransferTest {
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    private Map<String, String> createPaymentData(String bankName, String referenceCode) {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", bankName);
        paymentData.put("referenceCode", referenceCode);
        return paymentData;
    }

    @Test
    void testValidBankTransferPayment() {
        Map<String, String> validPaymentData = createPaymentData("ABC Bank", "654321");
        assertTrue(paymentService.isBankTransferValid(validPaymentData));
    }

    @Test
    void testInvalidBankTransferPaymentMissingBankName() {
        Map<String, String> invalidPaymentData = createPaymentData(null, "654321");
        assertFalse(paymentService.isBankTransferValid(invalidPaymentData));
    }

    @Test
    void testInvalidBankTransferPaymentMissingReferenceCode() {
        Map<String, String> invalidPaymentData = createPaymentData("ABC Bank", null);
        assertFalse(paymentService.isBankTransferValid(invalidPaymentData));
    }

    @Test
    void testInvalidBankTransferPaymentEmptyBankNameAndReferenceCode() {
        Map<String, String> invalidPaymentData = createPaymentData("", "");
        assertFalse(paymentService.isBankTransferValid(invalidPaymentData));
    }
}

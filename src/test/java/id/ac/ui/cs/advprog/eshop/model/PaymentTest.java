package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {

    private Map<String, String > paymentData;
    @BeforeEach
    void setUp() {
        paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testCreateVoucher() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentData);

        assertEquals("2c61b6d0-5619-4f81-9254-a2390fc275f7", payment.getId());
        assertEquals("voucherCode", payment.getMethod());
        assertEquals(paymentData, payment.getPaymentData());
    }

    @Test
    void testCreateVoucherSuccessStatus() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentData, "SUCCESS");
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreateVoucherRejectedStatus() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentData, "REJECTED");
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetStatusToRejected() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentData);
        payment.setStatus("REJECTED");
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetStatusToInvalid() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}

package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {

    private Map<String, String > paymentVoucher;
    @BeforeEach
    void setUp() {
        paymentVoucher = new HashMap<>();
        paymentVoucher.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testCreateVoucher() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher);

        assertEquals("2c61b6d0-5619-4f81-9254-a2390fc275f7", payment.getId());
        assertEquals("voucherCode", payment.getMethod());
        assertEquals(paymentVoucher, payment.getPaymentType());
    }

    @Test
    void testCreateVoucherSuccessStatus() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher, "SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreateVoucherRejectedStatus() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher, "REJECTED");
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testSetStatusToRejected() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher);
        payment.setStatus("REJECTED");
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testSetStatusToInvalid() {
        Payment payment = new Payment("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}

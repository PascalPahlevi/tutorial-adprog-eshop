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
        Voucher voucher = new Voucher("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher);

        assertEquals("2c61b6d0-5619-4f81-9254-a2390fc275f7", voucher.getId());
        assertEquals("voucherCode", voucher.getMethod());
        assertEquals(paymentVoucher, voucher.getPaymentType());
    }

    @Test
    void testCreateVoucherSuccessStatus() {
        Voucher voucher = new Voucher("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher, "SUCCESS");
        assertEquals("SUCCESS", voucher.getStatus());
    }

    @Test
    void testCreateVoucherRejectedStatus() {
        Voucher voucher = new Voucher("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher, "REJECTED");
        assertEquals("REJECTED", voucher.getStatus());
    }

    @Test
    void testSetStatusToRejected() {
        Voucher voucher = new Voucher("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher);
        voucher.setStatus("REJECTED")
        assertEquals("REJECTED", voucher.getStatus());
    }

    @Test
    void testSetStatusToInvalid() {
        Voucher voucher = new Voucher("2c61b6d0-5619-4f81-9254-a2390fc275f7", "voucherCode", paymentVoucher);
        assertThrows(IllegalArgumentException.class, () -> voucher.setStatus("MEOW"));
    }
}

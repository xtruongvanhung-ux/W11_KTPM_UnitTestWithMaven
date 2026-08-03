package com.mycompany.w11_ktpm_unittestwithmaven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RationalTest {

    // Test 1: Kiểm tra khởi tạo mặc định phải là 0/1
    @Test
    public void testDefaultConstructor() {
        Rational r = new Rational();
        assertEquals(0, r.numerator, "Tử số mặc định phải là 0");
        assertEquals(1, r.denominator, "Mẫu số mặc định phải là 1");
    }

    // Test 2: Kiểm tra khởi tạo và tự động tối giản (2/4 -> 1/2)
    @Test
    public void testValidConstructorAndSimplestForm() throws Illegal {
        Rational r = new Rational(2, 4);
        assertEquals(1, r.numerator, "Tử số sau tối giản phải là 1");
        assertEquals(2, r.denominator, "Mẫu số sau tối giản phải là 2");
    }

    // Test 3: Kiểm tra ném ngoại lệ Illegal khi mẫu số = 0
    @Test
    public void testZeroDenominatorException() {
        assertThrows(Illegal.class, () -> {
            new Rational(1, 0);
        }, "Phải ném ngoại lệ Illegal khi mẫu số bằng 0");
    }

    // Test 4: Phép cộng (1/3 + 1/6 = 1/2)
    @Test
    public void testAdd() throws Illegal {
        Rational r1 = new Rational(1, 3);
        Rational r2 = new Rational(1, 6);
        r1.add(r2);
        assertEquals(new Rational(1, 2), r1, "1/3 + 1/6 phải bằng 1/2");
    }

    // Test 5: Phép trừ (1/2 - 1/3 = 1/6)
    @Test
    public void testSubtract() throws Illegal {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        r1.subtract(r2);
        assertEquals(new Rational(1, 6), r1, "1/2 - 1/3 phải bằng 1/6");
    }

    // Test 6: Phép nhân (2/3 * 3/4 = 1/2)
    @Test
    public void testMultiply() throws Illegal {
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(3, 4);
        r1.multiply(r2);
        assertEquals(new Rational(1, 2), r1, "2/3 * 3/4 phải bằng 1/2");
    }

    // Test 7: Phép chia (1/2 / 1/4 = 2/1)
    @Test
    public void testDivide() throws Illegal {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 4);
        r1.divide(r2);
        assertEquals(new Rational(2, 1), r1, "1/2 chia 1/4 phải bằng 2/1");
    }

    // Test 8: So sánh bằng nhau (2/4 equals 1/2)
    @Test
    public void testEquals() throws Illegal {
        Rational r1 = new Rational(2, 4);
        Rational r2 = new Rational(1, 2);
        assertTrue(r1.equals(r2), "2/4 phải bằng 1/2");
    }

    // Test 9: So sánh giá trị (3/4 > 1/2)
    @Test
    public void testCompareTo() throws Illegal {
        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(1, 2);
        assertTrue(r1.compareTo(r2) > 0, "3/4 phải lớn hơn 1/2");
    }

    // Test 10: Chuyển đổi sang chuỗi (3/4 -> "3/4")
    @Test
    public void testToString() throws Illegal {
        Rational r1 = new Rational(3, 4);
        assertEquals("3/4", r1.toString(), "Chuỗi hiển thị phải là '3/4'");
    }
}
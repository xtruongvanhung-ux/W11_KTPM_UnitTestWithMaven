package com.mycompany.w11_ktpm_unittestwithmaven;

public class Rational {
    long numerator, denominator;

    // Constructor 1: Khởi tạo mặc định (0/1)
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    // Constructor 2: Khởi tạo có tham số (bắt lỗi mẫu số = 0)
    public Rational(long numerator, long denominator) throws Illegal {
        if (denominator == 0) {
            throw new Illegal("Mẫu số không thể bằng 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplestForm();
    }

    // Tối giản phân số & chuẩn hóa dấu
    private void simplestForm() {
        long computeGCD = GCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= computeGCD;
        denominator /= computeGCD;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Tìm ước số chung lớn nhất (UCLN)
    private long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    // Phép cộng
    public void add(Rational x) {
        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    // Phép trừ
    public void subtract(Rational x) {
        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    // Phép nhân
    public void multiply(Rational x) {
        numerator = numerator * x.numerator;
        denominator = denominator * x.denominator;
        simplestForm();
    }

    // Phép chia
    public void divide(Rational x) throws Illegal {
        if (x.numerator == 0) {
            throw new Illegal("Không thể chia cho phân số có tử số bằng 0");
        }
        numerator = numerator * x.denominator;
        denominator = denominator * x.numerator;
        simplestForm();
    }

    // So sánh bằng nhau
    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null || getClass() != x.getClass()) return false;
        Rational other = (Rational) x;
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    // So sánh giá trị (> 0, == 0, < 0)
    public long compareTo(Object x) {
        Rational other = (Rational) x;
        return (this.numerator * other.denominator) - (other.numerator * this.denominator);
    }

    // Chuyển thành chuỗi hiển thị
    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }
}
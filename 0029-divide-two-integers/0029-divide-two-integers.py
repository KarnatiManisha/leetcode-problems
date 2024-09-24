class Solution:
    def divide(self, dividend, divisor):
        if dividend == 0:
            return 0
        if divisor == 0:
            return None  # Division by zero is undefined
        sign = 1
        if (dividend < 0) ^ (divisor < 0):
            sign = -1

        dividend = abs(dividend)
        divisor = abs(divisor)
        quotient = 0
        while dividend >= divisor:
            temp_divisor, num_divisors = divisor, 1
            while dividend >= (temp_divisor << 1):
                temp_divisor <<= 1
                num_divisors <<= 1
            dividend -= temp_divisor
            quotient += num_divisors
        quotient = sign * quotient       
        return min(max(-2**31, quotient), 2**31 - 1)
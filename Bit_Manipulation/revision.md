# 🧠 Bit Manipulation — Complete Notes (Java Edition)

> Golden rule: **a computer only understands 0s and 1s.**
> Whenever you write `int x = 13;`, the computer silently converts and stores it as binary under the hood. This entire README is built around that one idea.

---

## 📑 Table of Contents
1. [Decimal ↔ Binary Conversion](#1-decimal--binary-conversion)
2. [1's Complement & 2's Complement](#2-1s-complement--2s-complement)
3. [Int Range — Max & Min Value](#3-int-range--max--min-value)
4. [Bitwise Operators](#4-bitwise-operators)
5. [Classic Bit Manipulation Problems](#5-classic-bit-manipulation-problems)
6. [Complexity Cheat Sheet](#6-complexity-cheat-sheet)
7. [Pro Tips (Competitive Programming Style)](#7-pro-tips-competitive-programming-style)

---

## 1. Decimal ↔ Binary Conversion

### Decimal → Binary (Divide-by-2 method)

```
        13 ÷ 2 → Quotient 6   Remainder 1   ↑
        6  ÷ 2 → Quotient 3   Remainder 0   |  Read
        3  ÷ 2 → Quotient 1   Remainder 1   |  bottom → top
        1  (stop when quotient becomes 1)   ↓

        Binary = 1 1 0 1  →  13 in decimal
```

### Binary → Decimal (Power-of-2 method)

```
        Binary:     1     1     0     1
        Position:   3     2     1     0
        Value:    2³=8   2²=4  2¹=2  2⁰=1

        Sum (wherever bit = 1):  8 + 4 + 0 + 1 = 13 ✅
```

### Java Code — Decimal to Binary (String)

```java
public class BinaryConversion {

    // Decimal -> Binary string
    public static String toBinary(int n) {
        StringBuilder result = new StringBuilder();
        while (n >= 1) {
            if (n % 2 == 1) {
                result.append('1');
            } else {
                result.append('0');
            }
            n = n / 2;
        }
        return result.reverse().toString(); // reversing is essential!
    }

    // Binary string -> Decimal
    public static int toDecimal(String binary) {
        int number = 0;
        int powerOf2 = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                number += powerOf2;
            }
            powerOf2 *= 2; // move to next power of 2
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(toBinary(13));      // 1101
        System.out.println(toDecimal("1101"));  // 13
    }
}
```

> 💡 **Extra knowledge:**
> - Time Complexity: `O(log₂ n)` — same log complexity you see in binary search, because the number keeps getting divided by 2.
> - `StringBuilder.reverse()` is required because remainders are collected **LSB (Least Significant Bit) first**, but binary is read MSB first.
> - Java has a built-in `Integer.toBinaryString(13)` — good to know both the manual and built-in versions.

---

## 2. 1's Complement & 2's Complement

```
Number:            13  →  1101
1's Complement:  flip every bit  →  0010
2's Complement:  1's complement + 1  →  0011
```

- **1's Complement** → flip (invert) every single bit.
- **2's Complement** → take the 1's complement, then add `1`.

### Why does this matter?
The computer **stores negative numbers using 2's complement.** Here's how `-3` gets stored:

```
Step 1: Write +3 in binary              → 00000000 00000000 00000000 00000011
Step 2: Flip every bit (1's complement) → 11111111 11111111 11111111 11111100
Step 3: Add 1 (2's complement)          → 11111111 11111111 11111111 11111101
                                            ↑
                                    This is the sign bit (1 = negative, 0 = positive)
```

```java
// You can verify this directly in Java
System.out.println(Integer.toBinaryString(-3));
// output: 11111111111111111111111111111101
```

---

## 3. Int Range — Max & Min Value

In Java, `int` is **32-bit**. The leftmost (31st) bit is the **sign bit**.

```
        Sign Bit                     31 more bits
           ↓
         [ 0 | 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ]
           ↑ positive                    ↑ all 1s → maximum value
```

| Concept | Value | Formula |
|---|---|---|
| `Integer.MAX_VALUE` | 2147483647 | `2³¹ - 1` |
| `Integer.MIN_VALUE` | -2147483648 | `-2³¹` |

```java
System.out.println(Integer.MAX_VALUE); // 2147483647
System.out.println(Integer.MIN_VALUE); // -2147483648
```

> 🔑 **Interesting fact:** MIN_VALUE has one more magnitude of range than MAX_VALUE, because the "all zeros with sign bit = 1" combination has no positive counterpart.

---

## 4. Bitwise Operators

### 🎯 Visual Truth Table

```
   AND (&)        OR (|)         XOR (^)        NOT (~)
   1 & 1 = 1      1 | 1 = 1      1 ^ 1 = 0      ~1 = 0
   1 & 0 = 0      1 | 0 = 1      1 ^ 0 = 1      ~0 = 1
   0 & 1 = 0      0 | 1 = 1      0 ^ 1 = 1
   0 & 0 = 0      0 | 0 = 0      0 ^ 0 = 0

   AND → "everyone must be 1"        OR  → "even one 1 is enough"
   XOR → "true only if odd number of 1s"   NOT → "flip everything"
```

### Example: `13 & 7`

```
       1 1 0 1   (13)
     & 0 1 1 1   (7)
     -----------
       0 1 0 1   = 5
```

### Example: `13 | 7`

```
       1 1 0 1   (13)
     | 0 1 1 1   (7)
     -----------
       1 1 1 1   = 15
```

### Example: `13 ^ 7`

```
       1 1 0 1   (13)
     ^ 0 1 1 1   (7)
     -----------
       1 0 1 0   = 10
```

### Shift Operators

```
   Right Shift (>>)  →  number ÷ 2^k     (bits move right, right-most bits fall off)
   Left Shift  (<<)  →  number × 2^k     (bits move left, new 0s fill in from the right)

   13 (1101) >> 1  =  0110  =  6     (13 / 2 = 6)
   13 (1101) << 1  =  11010 = 26     (13 * 2 = 26)
```

```java
int a = 13, b = 7;
System.out.println(a & b);   // 5
System.out.println(a | b);   // 15
System.out.println(a ^ b);   // 10
System.out.println(a >> 1);  // 6
System.out.println(a << 1);  // 26
System.out.println(~a);      // -14 (NOT = 2's complement flip)
```

> ⚠️ **Java-specific note:** In Java, `>>` is an **arithmetic (sign-preserving) shift**, while `>>>` is a **logical (unsigned) shift**. This distinction is a very common interview question when dealing with negative numbers.

```java
System.out.println(-8 >> 1);   // -4  (sign bit is preserved)
System.out.println(-8 >>> 1);  // 2147483644 (sign bit also gets shifted)
```

---

## 5. Classic Bit Manipulation Problems

### 🔄 5.1 Swap Two Numbers (without a temp variable)

```
Idea: XOR-ing a number with itself cancels it out (x ^ x = 0)

a = a ^ b
b = a ^ b   // this becomes the original 'a'
a = a ^ b   // this becomes the original 'b'
```

```java
public static void swap(int a, int b) {
    a = a ^ b;
    b = a ^ b;  // now equals original a
    a = a ^ b;  // now equals original b
    System.out.println("a = " + a + ", b = " + b);
}
```

> 💡 A common interview follow-up: "why can't you just write `b = a`?" — because by that point `a`'s original value has already been overwritten. The XOR trick avoids needing a third variable entirely.

---

### 🔍 5.2 Check if the i-th Bit is Set

```
        n = 13 = 1 1 0 1
        i = 2  (0-indexed from the right)
                    ↑
              this is the bit we're checking
```

**Method 1: Left Shift + AND**
```java
public static boolean isBitSet(int n, int i) {
    return (n & (1 << i)) != 0;
}
```

**Method 2: Right Shift + AND**
```java
public static boolean isBitSetV2(int n, int i) {
    return ((n >> i) & 1) == 1;
}
```

---

### ✅ 5.3 Set the i-th Bit

```
   n = 9 = 1 0 0 1     i = 2
   1 << i    →   0 1 0 0
   n | (1<<i) →  1 1 0 1  = 13   (bit is now set!)
```

```java
public static int setBit(int n, int i) {
    return n | (1 << i);
}
```

---

### ❌ 5.4 Clear the i-th Bit

```
   n = 13 = 1 1 0 1     i = 2
   1 << i          → 0 1 0 0
   ~(1 << i)        → 1 0 1 1
   n & ~(1<<i)      → 1 0 0 1  = 9   (bit is now cleared!)
```

```java
public static int clearBit(int n, int i) {
    return n & (~(1 << i));
}
```

---

### 🔁 5.5 Toggle the i-th Bit

```
   n = 13 = 1 1 0 1     i = 2
   1 << i          → 0 1 0 0
   n ^ (1<<i)       → 1 0 0 1  = 9   (1 became 0)
```

```java
public static int toggleBit(int n, int i) {
    return n ^ (1 << i);
}
```

---

### 🧹 5.6 Remove the Last Set Bit (Rightmost 1)

```
   n     = 40 = 1 0 1 0 0 0
   n - 1 = 39 = 1 0 0 1 1 1
   n & (n-1)  = 1 0 1 0 0 0
              & 1 0 0 1 1 1
              -----------
              1 0 0 0 0 0   = 32  (rightmost set bit is gone!)
```

**Why does this work?**  
`n - 1` turns the rightmost set bit to `0`, and every bit **to its right** flips from `0` to `1`. ANDing with the original `n` then wipes out exactly that rightmost bit, leaving everything else unchanged.

```java
public static int removeLastSetBit(int n) {
    return n & (n - 1);
}
```

---

### ⚡ 5.7 Check if a Number is a Power of 2

```
   Powers of 2 always have EXACTLY ONE set bit
   (2, 4, 8, 16, 32, 64 ... write any of them in binary and check!)

   n = 16 = 1 0 0 0 0
   n-1=15 = 0 1 1 1 1
   n & (n-1) = 0 0 0 0 0  = 0  → POWER OF 2 ✅

   n = 13 = 1 1 0 1
   n-1=12 = 1 1 0 0
   n & (n-1) = 1 1 0 0  ≠ 0  → NOT a power of 2 ❌
```

```java
public static boolean isPowerOfTwo(int n) {
    if (n <= 0) return false; // don't forget this edge case!
    return (n & (n - 1)) == 0;
}
```

> ⚠️ **Common trap:** For `n = 0`, `n & (n-1)` also equals `0`, but 0 is NOT a power of 2. That's why the `n <= 0` check must come first.

---

### 🔢 5.8 Count Number of Set Bits

**Brute Force (bit by bit check):**
```java
public static int countSetBitsBrute(int n) {
    int count = 0;
    while (n > 0) {
        count += (n & 1);   // check last bit
        n = n >> 1;         // shift right
    }
    return count;
}
```

**Better Approach — Brian Kernighan's Algorithm** (turns off the rightmost set bit each iteration):

```
   n = 84 = 1 0 1 0 1 0 0 0    → has 3 set bits
   
   Step 1: n & (n-1) → rightmost set bit off → count = 1
   Step 2: n & (n-1) → next rightmost bit off → count = 2
   Step 3: n & (n-1) → last set bit off       → count = 3
   Step 4: n == 0 → loop ends
```

```java
public static int countSetBitsFast(int n) {
    int count = 0;
    while (n != 0) {
        n = n & (n - 1);  // turns off rightmost set bit
        count++;
    }
    return count;
}
```

```java
// Java's built-in equivalent (used in production code)
System.out.println(Integer.bitCount(84)); // 3
```

> 🚀 **Pro move:** Brian Kernighan's algorithm runs in `O(number of set bits)` — worst case `O(31)`, but on average much faster than the brute-force `O(log n)` approach.

---

## 6. Complexity Cheat Sheet

| Operation | Time Complexity | Space Complexity |
|---|---|---|
| Decimal → Binary | O(log n) | O(log n) |
| Binary → Decimal | O(length of string) | O(1) |
| Check / Set / Clear / Toggle i-th bit | O(1) | O(1) |
| Remove last set bit | O(1) | O(1) |
| Check power of 2 | O(1) | O(1) |
| Count set bits (brute force) | O(log n) | O(1) |
| Count set bits (Brian Kernighan) | O(number of set bits) | O(1) |

---

## 7. Pro Tips (Competitive Programming Style)

```
✅ n % 2 == 1        →  write   n & 1
✅ n / 2             →  write   n >> 1
✅ n * 2             →  write   n << 1
✅ (low + high) / 2  →  write   (low + high) >> 1   (also overflow-safer)
```

- Bitwise operations are **faster than arithmetic operations** because the CPU works directly on bits.
- Competitive programmers habitually write odd/even checks, division, and multiplication using bitwise operators — practice it until it becomes muscle memory.
- XOR isn't just for swapping — it's the backbone of famous problems like **"find the unique element in an array"** and **"find the missing number"**. Those are natural next steps after this README.

---

### 🎯 What to do next

1. Rewrite every problem above in Java from scratch, without looking — that's what builds real muscle memory.
2. Search LeetCode for: *"Number of 1 Bits"*, *"Power of Two"*, *"Single Number"*, *"Missing Number"* — all of them build directly on the concepts here.
3. Next milestone: **XOR-based problems** (Single Number I/II/III) — the natural next level of bit manipulation, and extremely common in interviews.
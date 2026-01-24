# 🔢 Java Array Output Questions 

---

## Question 1: Array Length

```java
int[] arr = {10, 20, 30};
System.out.println(arr.length);
```

**Output**
- 3

**Explanation**
- `length` is a property of arrays
- It returns the number of elements
- The array has 3 elements → output is 3

---

## Question 2: Default Values in Array

```java
int[] arr = new int[3];

System.out.println(arr[0]);
System.out.println(arr[1]);
System.out.println(arr[2]);
```

**Output**
- 0  
- 0  
- 0  

**Explanation**
- Array is created with size 3
- No values are assigned
- Java assigns default value `0` to `int` array elements

---

## Question 3: Partially Initialized Array

```java
int[] arr = new int[3];
arr[0] = 10;
arr[1] = 20;

System.out.println(arr[0]);
System.out.println(arr[1]);
System.out.println(arr[2]);
```

**Output**
- 10  
- 20  
- 0  

**Explanation**
- Index 0 and 1 are assigned values
- Index 2 is not assigned
- Default value `0` is printed

---

## Question 4: Array Reference Sharing

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = arr1;

arr2[0] = 100;

System.out.println(arr1[0]);
System.out.println(arr2[0]);
```

**Output**
- 100  
- 100  

**Explanation**
- `arr1` and `arr2` point to the same array
- Updating through one reference affects the other
- Arrays are objects; assignment copies the reference

---

## Question 5: Printing Array Directly

```java
int[] arr = {1, 2, 3};
System.out.println(arr);
```

**Output**
- `[I@xxxxxx` (reference value)

**Explanation**
- Printing an array directly prints its reference
- Java does not print array elements automatically
- Use `Arrays.toString(arr)` to print values

---

## Question 6: Reference vs Value

```java
int[] arr = {1, 2, 3};

System.out.println(arr);
System.out.println(arr[0]);
```

**Output**
- `[I@xxxxxx`  
- 1  

**Explanation**
- `arr` prints reference
- `arr[0]` prints value at index 0

---

## Question 7: Same Reference Printed Twice

```java
int[] a = {10, 20};
int[] b = a;

System.out.println(a);
System.out.println(b);
```

**Output**
- `[I@xxxxxx`  
- `[I@xxxxxx`  

**Explanation**
- `a` and `b` refer to the same array
- Both print the same reference

---

## Interview Key Takeaways

- `arr` → reference  
- `arr[index]` → value  
- Printing array prints reference, not elements  
- Array assignment copies reference, not data  

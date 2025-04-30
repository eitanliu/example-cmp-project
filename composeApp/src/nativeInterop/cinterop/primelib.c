

char *return_string(int isPrime) {
    return (isPrime == 0) ? "is prime" : "is not prime";
}


int is_prime(int num) {
    int count = 0;
    for (int i = 1; i <= num; i++) {
        if (num % i == 0) {
            count++;
        }
    }
    if (count == 2)
        return 0;
    else
        return 1;
}
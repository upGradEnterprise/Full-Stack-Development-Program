public class Statistics {
    public static long factorial(int number) {
        return number == 0 ? 1 : number * factorial(number - 1);
    }
}
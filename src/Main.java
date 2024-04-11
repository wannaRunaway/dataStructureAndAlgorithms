//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] twoDimensionalArray = new int[11][11];
        twoDimensionalArray[1][2] = 10;
        twoDimensionalArray[4][6] = 20;
        //打印这个二维数组
        TwoDimensionalArray.printTwoDimensional(twoDimensionalArray);
    }
}
public class bigint {

    public static void main(String[] args) {
        int array = array [4,7, 2, 8, 9];
        int check = 0;
        int check2 = 0;
        public secondLargest() {
            for(int i = 0; i < array.length; i++)
            {
                if (i > check) {
                    check = i;
                }
            }
            for(int i = 0; i < array.length; i++)
            {
                if (i > check2 && i < check) {
                    check2 = i;
                }
            }
            return check2;
        }

    }


}

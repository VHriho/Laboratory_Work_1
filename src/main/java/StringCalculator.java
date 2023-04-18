public class StringCalculator{
    public int add(String numbers){
        if (numbers.isEmpty())
            return 0;
        else
            return sum(numbers);
    }

    public int sum(String args){
        String[] str = args.split(",");
        int result = 0;
        int summing;
        for (int i = 0; i < str.length; i++){
            try{
                summing = Integer.parseInt(str[i]);
            }
            catch (Exception e){
                throw new RuntimeException("INPUT INCORRECT! contains invalid: delimiter");
            }
            result += summing;
        }
        return result;
    }

}

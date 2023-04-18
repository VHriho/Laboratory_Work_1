public class StringCalculator{
    public int add(String numbers){
        if (numbers.isEmpty())
            return 0;
        if (numbers.contains(",\n") || numbers.contains("\n,"))
            throw new RuntimeException("INPUT INCORRECT! contains invalid: \\n");
        else
            return sum(numbers);
    }

    public int sum(String args){
        args = args.replaceAll("\n", ",");
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

public class StringCalculator{
    public int add(String numbers){
        if (numbers.isEmpty())
            return 0;
        if (numbers.charAt(0) == '/')
            return sum(delimiter(numbers));
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

    public String delimiter(String args) {
        Character delimiter_in_char;
        args = args.substring(2);
        delimiter_in_char = args.charAt(0);
        args = args.substring(2);
        args = args.replaceAll(delimiter_in_char.toString(), ",");
        return args;
    }

}

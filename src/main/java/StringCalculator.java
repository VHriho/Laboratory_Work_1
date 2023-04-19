import java.util.ArrayList;
import java.util.List;

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
        if(args.charAt(0) == ',')
            throw new RuntimeException("INPUT INCORRECT! contains invalid: delimiter");
        List<Integer> list_of_negatives = new ArrayList<Integer>();
        args = args.replaceAll("\n", ",");
        String[] str = args.split(",");
        int result = 0;
        int summing;
        for (int i = 0; i < str.length; i++){
            if(!str[i].isEmpty()){
                try {
                    summing = Integer.parseInt(str[i]);
                }
                catch (Exception e) {
                    throw new RuntimeException("INPUT INCORRECT! contains invalid: delimiter");
                }
                if (summing < 0)
                    list_of_negatives.add(summing);
                if (summing > 1000)
                    continue;
                result += summing;
            }
            else
                continue;
        }
        if(!list_of_negatives.isEmpty())
            throw new RuntimeException("INPUT INCORRECT! contains: negative " + list_of_negatives);
        return result;
    }

    public String delimiter(String args){
        StringBuilder str_of_delimiter = new StringBuilder();
        Character delimiter_in_char;
        args = args.substring(2);
        if (args.charAt(0) == '['){
            for (int i = 1; args.charAt(i) != '\n'; i++) {
                if (args.charAt(0) == '[') {
                    str_of_delimiter.append(args.charAt(i));
                    if (args.charAt(i + 1) == ']') {
                        args = args.replace(str_of_delimiter.toString(), ",");
                        str_of_delimiter = new StringBuilder();
                        args = args.substring(3);
                        i = 0;
                    }
                }
                else
                    break;
            }
        }
        else{
            delimiter_in_char = args.charAt(0);
            args = args.substring(2);
            args = args.replaceAll(delimiter_in_char.toString(), ",");
        }
        return args;
    }

}

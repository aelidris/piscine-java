public class DoOp {
    public static String operate(String[] args) {
        if (args.length == 0) {
            return "Error";
        }
        if (args.length >=3) {
            for (int i=0; i<args.length ; i++) {
                int first = Integer.parseInt(args[0]);
                int last = Integer.parseInt(args[2]);
                if (args[1] == "+") {
                    return String.valueOf(first + last);
                } else if (args[1] == "-") {
                    return String.valueOf(first - last);
                } else if (args[1] == "%") {
                    if (last == 0) {
                        return "Error";
                    } else {
                        return String.valueOf(first % last);
                    }
                }
            }
        }
        return "0";
    }
}
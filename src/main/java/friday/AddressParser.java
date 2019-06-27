package friday;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressParser {

    private Pattern isAlphaNumeric = Pattern.compile("^\\d+[a-zA-Z]*$");
    private Pattern isNumeric = Pattern.compile("^\\d+,?$");
    private Pattern isString = Pattern.compile("^[A-Za-z][^0-9@!#$%^&*_]+$");
    private Pattern isSingleChar = Pattern.compile("^[A-Za-z],?$");
    private Pattern isNo = Pattern.compile("\\bNo\\s\\d+\\b");

    public ParsedAddress parse(String address){
        String[] str = address.split(" ");

        StringBuilder streetBuilder = new StringBuilder();
        StringBuilder houseBuilder = new StringBuilder();

        if(str.length < 2)
            return null;

        Matcher isNoMatcher = isNo.matcher(address);
        if(isNoMatcher.find()){
            houseBuilder.append(address.substring(isNoMatcher.start(), isNoMatcher.end()).trim());
            streetBuilder.append(address.replace(houseBuilder.toString(), ""));
        } else {
            for (int i = 0; i < str.length; i++) {

                String curr = str[i];

                Matcher isAlphaNumericMatcher = isAlphaNumeric.matcher(curr);
                Matcher isNumericMatcher = isNumeric.matcher(curr);
                Matcher isStringMatcher = isString.matcher(curr);


                if(isStringMatcher.matches()){
                    streetBuilder.append(curr).append(" ");
                } else if (isNumericMatcher.matches()){
                    if(i+1 < str.length){
                        String next = str[i+1];
                        Matcher isSingleCharMatcher = isSingleChar.matcher(next);
                        if(isSingleCharMatcher.matches()){
                            houseBuilder.append(curr).append(" ").append(next);
                            i++;
                        } else {
                            houseBuilder.append(curr);
                        }
                    } else {
                        houseBuilder.append(curr);
                    }
                } else if (isAlphaNumericMatcher.matches()){
                    houseBuilder.append(curr);
                }
            }
        }

        return new ParsedAddress(removeTrailingSpaceComma(streetBuilder),
                removeTrailingSpaceComma(houseBuilder));
    }

    private static String removeTrailingSpaceComma(StringBuilder builder){
        String str = builder.toString().trim();
        if(str.endsWith(",")){
            return str.substring(0, str.length()-1).trim();
        } else if (str.startsWith(",")){
            return str.substring(1).trim();
        }
        return str.trim();
    }
}

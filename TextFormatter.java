import javax.xml.bind.MarshalException;
import java.util.ArrayList;

class TextFormatter {

  private int max;
  private static ArrayList<String> lines = new ArrayList<String>();
  private static ArrayList<String> rightText = new ArrayList<String>();
  
  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {

    TextFormatter formatter = new TextFormatter(30);
    System.out.println("LeftJustified: \n");
    String leftJustified = formatter.printLeftJustified(text);
    System.out.println(leftJustified);
    System.out.println("RightJustified: \n");
    String rightJustified = formatter.printRightJustified(formatter,text);
    System.out.println(rightJustified);
    System.out.println("With separations: \n");
    formatter.printWithSeparation(text);
    System.out.print("\n");

  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    
    max = maxLineLength;

  }

  public String printLeftJustified(String aText) {

    int temp = 0;
    String output = "";
    int spacecounter = 0;

    for (int i=0; i < aText.length(); i++){
      if (temp < max){
        output = output + aText.charAt(i);
        temp++;
      }
      if (temp == max) {
        if (aText.charAt(i) == (' ')){
          output = output + ("\n");
          temp = 0;
        }
        if (aText.charAt(i) != (' ')){
          while (true){
            if (aText.charAt(i) == (' ')){
              output = output + getSpace(spacecounter) + ("\n");
              temp = 0;
              spacecounter = 0;
              break;
            } else {
              output = output.substring(0, output.length()-1);
              spacecounter++;
              i--;
            }
          }
        }
      }
    }
    output = output + "\n";
    return(output);
  }

  public void printWithSeparation(String aText) {

    for (int i=1; i<= aText.length(); i++){
        if (i % max != 0){
          System.out.print(aText.charAt(i-1));
        } else{
          if(aText.charAt(i-1) == ' '){
            System.out.print("\n");
          }else{
            System.out.print(aText.charAt(i-1));
            System.out.print("-\n");
          }
        }
      }
    }

  public String printRightJustified(TextFormatter formatter, String aText) {
    
    String left = formatter.printLeftJustified(text);
    storeLinesInArray(left);  
  
    for (int i=0; i<lines.size()-1; i++){

        String line = lines.get(i);
        int length = line.length()-1;
        int space = lookHowMuchSpace(line);
        line = getSpace(space) + line;
        rightText.add(line);
        
        }
        String lastline = lines.get(lines.size()-1);
        String conLine = convertLastLine(lastline);
        rightText.add(conLine);
        String rightJustified = convertArrayToString(rightText);
    
      return (rightJustified);
    } 

  public String convertLastLine(String line){
    
    int length = line.length();
    int space = max - length + 1;
    String conLine = getSpace(space) + line;

    return(conLine);
  }
 
  public int lookHowMuchSpace(String line){

    int counter = 0;  
    int pos = line.length()-2;

    while(line.charAt(pos) == ' '){
        counter++;
        pos--;
        if(line.charAt(pos) != ' '){
          break;
        }
    }
    return(counter);
  }

  public String getSpace(int space){

    String frontspace = "";

    for (int i=0; i<space; i++){
      frontspace += " ";
    }

    return(frontspace);
  }

  public String convertArrayToString(ArrayList<String> rightText){
    
    String rightJustified = "";

    for(String i : rightText){
      rightJustified += i;
    }

    return(rightJustified);
  }

  public void storeLinesInArray(String aText){
    
    int temp = 0;
    String line = "";
    
    for(int i=0; i<aText.length(); i++){

      if (temp < max){
        line = line + aText.charAt(i);
        temp++;
      }else{
          line = line + aText.charAt(i);
          lines.add(line);
          temp = 0; 
          line = "";
        }
      }
      lines.add(line);
    }
}


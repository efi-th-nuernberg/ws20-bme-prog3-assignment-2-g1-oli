import javax.xml.bind.MarshalException;

class TextFormatter {

  private int max;
  
  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    //formatter.printWithSeparation(text);
    //System.out.println("\n");
    //formatter.printLeftJustified(text);
    //System.out.println("\n");
    formatter.printRightJustified(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    
    max = maxLineLength;

  }

  // Ausgabe als linken Flattersatz
  public void printLeftJustified(String aText) {
    int temp = 0;
    String output = "";
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
              output = output + ("\n");
              temp = 0;
              break;
            } else {
              output = output.substring(0, output.length()-1);
              i--;
            }
          }
        }
      }
    }
    System.out.println(output);
  }

  // Ausgabe als rechten Flattersatz
  public void printRightJustified(String aText) {
    // Durch aText gehen
    // Wenn temp > max dann muss ein Umbruch geschehen
    // Line nach rechts verschieben -> eigene Methode mit Rückgabewert?
    // Weiter gehen
    // Am Schluss veränderten String ausgeben

    int temp = 0;
    int counter = 0;
    String output = "";
  
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
             
              output = output + ("\n");
              output = paddLine(output, counter);
              
              temp = 0;
              counter = 0;
              break;
              // schauen wie der groß der Space ist
            } else {
              output = output.substring(0, output.length()-1);
              i--;
              counter++;
            }
          }
        }
      }
    }
    System.out.println(output);
  }

  public String paddLine(String input, int counter){
    
    String space = "";
    //System.out.println("Counter: " + counter);

    for(int i=0 ; i < counter; i++){
      
      space += " "; 

    }
    //System.out.println("Space:+" + space + "+");
    String line = input + space;
    //System.out.println("Line:" + line);
    return(line);
  }

  // Ausgabe als Block mit Trennungsstrichen
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
}


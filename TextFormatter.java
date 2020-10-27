import javax.xml.bind.MarshalException;

class TextFormatter {

  private int max;
  private int counter;

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    
    max = maxLineLength;

  }

  // Ausgabe
  public void print(String aText) {
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
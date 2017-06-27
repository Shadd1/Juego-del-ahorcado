
public class Comida extends Word {

  //palabras faciles de 4-7 letras
  private String[] easyWords = {"MANZANA", "CARNE", "TOCINO", "HUEVO", "MIEL",
    "PESCADO", "MAIZ"};
  // palabras medias 8-12 letras
  private String[] mediumWords = {"ESPARRAGUS", "HAMBURGESA",
    "PEPPERONI", "SPAGHETTI", "PANCAKES"};
  //palabras dificiles 12-25 letras
  private String[] hardWords = {"CHIMICHANGA", "HUEVOS DIVORCIADOS",
    "CREMA DE MANI", "SHUANGBAOTAI", "TAMAGO KAKE GOHAN", "VIENNOISERIE"};

  public Comida(int nivel) {
    super(nivel);
  }

  @Override
  public void generateWord() {
    int option = (int) (Math.random() * 8);
    String word = "";
    switch (getnivel()) {
      case 1:
        word = easyWords[option];
        setWord(word);
        break;
      case 2:
        word = mediumWords[option];
        setWord(word);
        break;
      case 3:
        word = hardWords[option];
        setWord(word);
        break;

    }
  }
}

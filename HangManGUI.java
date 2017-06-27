
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangManGUI extends JFrame implements ActionListener {

  //main 
  private JPanel panel;
  // labels
  private JLabel wordL; 
  private JLabel letterL; 
  private JLabel result; // muestra la dificultad
  private JLabel guessesLeft;
  // espacio para poder adivinar
  private JTextField letterTF;
 
  private JButton play;
  //para volver a jugar
  private JButton playAgain;
  //area de texto del ahorcado
  private JTextArea hangman;
  // para adivinar
  private int counter = 6;
  private StringBuffer displayWord = new StringBuffer();
  private String randomWord;

  /**
   * 2-argumentos para el constructor
   *
   * @param category tipo de palabra
   * @param level facil, medio y dificil
   */
  public HangManGUI(int category, int level) {
    super("VAMOS A JUGAR AHORCADO!");
    setSize(350, 300); //tamaño
    setResizable(false);
    setVisible(true); 
    setLocationRelativeTo(null); // centrar pantalla
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    addComponents();
    gameSetup(category, level); // logica del juego
  }

  private void addComponents() {
    panel = new JPanel(null);
    // entrar etiqueta
    letterL = new JLabel("Enter letter:");
    letterL.setBounds(10, 10, 100, 25);
    letterL.setFont(new Font("SansSerif", Font.BOLD, 15));
    panel.add(letterL);
    letterTF = new JTextField(3);
    letterTF.setBounds(120, 10, 30, 25);
    letterTF.setBackground(Color.LIGHT_GRAY);
    letterTF.setFont(new Font("SansSerif", Font.BOLD, 15));
    panel.add(letterTF);
    play = new JButton("GO");
    play.setBounds(180, 10, 70, 25);
    play.addActionListener(this);
    panel.add(play);
    //para mostrar si es correcto
    result = new JLabel();
    result.setBounds(10, 80, 200, 25);
    panel.add(result);
    guessesLeft = new JLabel();
    guessesLeft.setBounds(10, 100, 100, 25);
    panel.add(guessesLeft);
    // area para el ahorcado
    hangman = new JTextArea(Hangs.Hang1());
    hangman.setBounds(190, 65, 120, 190);
    hangman.setFont(new Font("SansSerif", Font.BOLD, 18));
    hangman.setEnabled(false);
    panel.add(hangman);
    // jugar nuevamente
    playAgain = new JButton("Play again");
    playAgain.setBounds(10, 230, 120, 25);
    playAgain.addActionListener(this);
    playAgain.setEnabled(false); // 
    panel.add(playAgain);
    panel.setBackground(Color.white); 
    add(panel, BorderLayout.CENTER);
  }

  private void gameSetup(int category, int level) {
    Word word = null;
    if (category == 1) { //palabra random deportes
      word = new Deportes(nivel); // empezar el nivel con la  dificultad
      word.generateWord(); // genera una palabra de la lista de palabras del nivel elevido
    }
    else if (category == 2) { // palabra random peliculas
      word = new Peliculas(nivel);// empezar el nivel con la  dificultad
      word.generateWord();// genera una palabra de la lista de palabras del nivel elevido
    }
    else if (category == 3) { // palabra random comida
      word = new Comida(nivel);// empezar el nivel con la  dificultad
      word.generateWord(); //genera una palabra de la lista de palabras del nivel elevido
    }
    else if (category == 4) { // palabra random paises
      word = new Paises(nivel);// empezar el nivel con la  dificultad
      word.generateWord();// genera una palabra de la lista de palabras del nivel elevido
    }
    playGame(word);
  }

  /**
   * empezar el juego con algo de logica
   */
  private void playGame(Word word) {
    randomWord = word.getWord(); // obtiene una palabra random de la categoria y el nivel
    //encripta la palabra
    for (int i = 0; i < randomWord.length(); i++)
      displayWord = displayWord.append("_");
    int index = randomWord.indexOf(" "); //
    while (index >= 0) {
      displayWord.setCharAt(index, ' ');
      index = randomWord.indexOf(" ", index + 1);// empeiza a buscar la palabra
    }
    wordL = new JLabel(displayWordSoFar());
    wordL.setBounds(10, 45, 340, 25);
    wordL.setFont(new Font("SansSerif", Font.BOLD, 12));
    panel.add(wordL);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // si se presiona para jugar otra vez
    if ((JButton) e.getSource() == playAgain) {
      this.setVisible(false); // esconde juego anterior
      this.dispose(); // termina juego anterior
      new FirstWindow(); // empieza nuevo juego
    }
    else {
      boolean checkGuess = false; // adivino correctamente ?
      if (!letterTF.getText().isEmpty()) {
        String randomWordletter = letterTF.getText().toUpperCase();
        // revisa si es correcto
        for (int i = 0; i < randomWord.length(); i++) { // itera la palabra
          if (randomWordletter.charAt(0) == randomWord.charAt(i)) { // si encuentra iguales 
            displayWord.setCharAt(i, randomWordletter.charAt(0)); // cambia la letra
            checkGuess = true; // adivina correcto
          }
        }
        if (checkGuess) { // si adivina correctamente
          result.setText("Correcto");
          letterTF.setText("");
          guessesLeft.setText(counter + " aciertos faltantes");
          wordL.setText(displayWordSoFar());
        }
        else { // si se equivoca
          counter--; 
          //si el jugador pierde
          if (counter == 0) {
            wordL.setText("Te has ahorcado, la palabra es:");
            result.setText(randomWord);
            guessesLeft.setText("");
            hangman.setText(Ahorcado.Hang7());
            play.setEnabled(false); // boton de cerrar
            playAgain.setEnabled(true); // quieres jugar de nuevo ?
            letterTF.setEnabled(false); // cierra el texto
          }
          else { // aun faltan algunos juegos
            result.setText("Wrong");
            guessesLeft.setText(counter + "aciertos faltantes");
            letterTF.setText("");
          }
        }
        checkGuess = false; 
        if ((displayWord.toString()).equals(randomWord)) {
          wordL.setText("Has adivinado la palabra!");
          result.setText(randomWord);
          guessesLeft.setText("");
          letterTF.setEnabled(false); 
          play.setEnabled(false); 
          playAgain.setEnabled(true);
          counter = 0;
        }
        //show hangman
        if (counter == 6) // sin fallos
          hangman.setText(Ahorcado.Hang1());
        else if (counter == 5)  // sin fallos
          hangman.setText(Ahorcado.Hang2());
        else if (counter == 4)  // 2 sin fallos
          hangman.setText(Ahorcado.Hang3());
        else if (counter == 3)  // 3 sin fallos
          hangman.setText(Ahorcado.Hang4());
        else if (counter == 2)  // 4 sin fallos
          hangman.setText(Ahorcado.Hang5());
        else if (counter == 1)  // 5 sin fallos
          hangman.setText(Ahorcado.Hang6());
      }
    }
  }

   private String displayWordSoFar() {
    StringBuffer randomWordWord = new StringBuffer();
    for (char ch : displayWord.toString().toCharArray()) {
      if (ch == ' ')
        randomWordWord.append("   "); // espacio
      else
        randomWordWord.append(ch + "  "); // letra
    }
    return randomWordWord.toString();
  }
}

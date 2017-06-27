
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstWindow extends JFrame implements ActionListener {

  //main panel
  private JPanel panel;
  //category
  private JLabel categoryL;
  private JComboBox categoryCB;
  //level
  private JLabel levelL;
  private JRadioButton facilRB;
  private JRadioButton mediumRB;
  private JRadioButton dificilRB;
  //buttons
  private JButton startGame;
  private JButton exitGame;

  public FirstWindow() {
    super("JUEGO DEL AHORCADO");
    setSize(320, 180);
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    addComponents();
  }

  private void addComponents() {
    panel = new JPanel(null);
    //etiqueta categoria
    categoryL = new JLabel("Categorias del juego :");
    categoryL.setBounds(10, 10, 100, 25);
    panel.add(categoryL);
    // box para dificultad
    categoryCB = new JComboBox(new Object[]{"", "Deportes", "Peliculas", "Comida", "Paises"});
    categoryCB.setBounds(120, 10, 155, 25);
    panel.add(categoryCB);
    //etiqueta de nivel
    levelL = new JLabel("Elige dificultad:");
    levelL.setBounds(10, 50, 100, 25);
    panel.add(levelL);
    facilRB = new JRadioButton("Facil");
    facilRB.setBounds(100, 50, 55, 25);
    facilRB.setSelected(true); // elegir dificiltad
    mediumRB = new JRadioButton("Medio");
    mediumRB.setBounds(155, 50, 70, 25);
    dificilRB = new JRadioButton("Dificil");
    dificilRB.setBounds(225, 50, 70, 25);
    ButtonGroup BG = new ButtonGroup();
    BG.add(facilRB);
    BG.add(mediumRB);
    BG.add(dificilRB);
    panel.add(facilRB);
    panel.add(mediumRB);
    panel.add(dificilRB);
    // inciar y salir 
    startGame = new JButton("Empezar");
    startGame.addActionListener(this);// cuando se oprime un boton
    startGame.setBounds(50, 100, 80, 25);
    panel.add(startGame);
    exitGame = new JButton("Salir");
    exitGame.addActionListener(this); // agregar accion cuando se oprime
    exitGame.setBounds(170, 100, 80, 25);
    panel.add(exitGame);
    add(panel, BorderLayout.CENTER);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton pressed = (JButton) e.getSource();// precionar boton
    if (pressed == exitGame)
      System.exit(0); // terminar game
    int category = categoryCB.getSelectedIndex();
    if (category == 0) //sin seleccion de categoria
      JOptionPane.showMessageDialog(this, "Por favor elige categoria!");
    else { // empezar
      int level;
      if (facilRB.isSelected()) // if facil
        level = 1;
      else if (mediumRB.isSelected()) // if medio
        level = 2;
      else // if dificil
        level = 3;
      this.setVisible(false); 
      new HangManGUI(category, level); // empieza el juego
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new FirstWindow();
      }
    });
  }
}

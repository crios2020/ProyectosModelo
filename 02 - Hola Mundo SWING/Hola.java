import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.WindowConstants;
public class Hola extends JFrame {

    public Hola(){
        super("Hola");  //Llama al constructor de la clase padre y coloca titulo
        inicializar();
    }

    public void inicializar(){
        getContentPane().setLayout(new FlowLayout());                   //Crea el layout (organización de elementos)
        JLabel label = new JLabel("Introduce tu nombre:");              //Agrega un Label
        JTextField textfield = new JTextField("nombre",20);             //Agrega un TextField
        JButton boton = new JButton("Enviar");                          //Agrega un Button
        getContentPane().add(label);                                    //Agrega elementos al layout
        getContentPane().add(textfield);                                //Agrega elementos al layout
        getContentPane().add(boton);                                    //Agrega elementos al layout
        setSize(400,300);                                               //Establece dimensiones del form
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        //Para que se cierre la app(JVM) al presionar el boton X
        setVisible(true);                                               //Hace Visible el form         
        
        //Ejemplo de evento para boton
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Hola "+textfield.getText());
                //Ejemplo Cuadro de dialogo
                JOptionPane.showMessageDialog(null, "Hola "+textfield.getText(), "Hola", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    public static void main(String[] args) {
        new Hola();                                    //Instancia un objeto del JFrame y lo hace visible
    }
}
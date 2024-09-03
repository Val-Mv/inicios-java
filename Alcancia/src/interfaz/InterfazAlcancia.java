package interfaz;

import mundo.Alcancia;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class InterfazAlcancia extends JFrame {
    // Atributos
    private Alcancia alcancia;

    // Atributos de la Interfaz
    private PanelImagen panelImagen;
    private PanelAlcancia panelAlcancia;
    private PanelBotones panelBotones;
    private PanelMonedas panelMonedas;

    // Constructor
    public InterfazAlcancia() {
        setTitle("Alcancía");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        alcancia = new Alcancia();

        panelImagen = new PanelImagen();
        getContentPane().add(panelImagen, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        panelMonedas = new PanelMonedas(this);
        panelCentral.add(panelMonedas, BorderLayout.NORTH);

        panelAlcancia = new PanelAlcancia();
        panelCentral.add(panelAlcancia, BorderLayout.CENTER);

        panelBotones = new PanelBotones(this);
        panelCentral.add(panelBotones, BorderLayout.EAST);

        getContentPane().add(panelCentral, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    // Métodos

    public void agregarMoneda(int pDenominacion) {
        if (alcancia.darEstado().equals("NO ROTA")) {
            switch (pDenominacion) {
                case 1000:
                    alcancia.agregarMoneda1000();
                    break;
                case 50:
                    alcancia.agregarMoneda50();
                    break;
                case 100:
                    alcancia.agregarMoneda100();
                    break;
                case 200:
                    alcancia.agregarMoneda200();
                    break;
                case 500:
                    alcancia.agregarMoneda500();
                    break;
                default:
                    throw new IllegalArgumentException("Denominación desconocida: " + pDenominacion);
            }

            actualizarPanelMonedas();
            panelAlcancia.cambiarMensaje("Se agregaron $" + pDenominacion + " a la alcancía.\nEn la alcancía hay $" + alcancia.calcularTotalDinero() + " pesos.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pueden agregar monedas a una alcancía rota.", "Agregar moneda", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarPanelMonedas() {
        panelMonedas.cambiarCantidad(50, alcancia.darNumeroMonedas50());
        panelMonedas.cambiarCantidad(100, alcancia.darNumeroMonedas100());
        panelMonedas.cambiarCantidad(200, alcancia.darNumeroMonedas200());
        panelMonedas.cambiarCantidad(500, alcancia.darNumeroMonedas500());
        panelMonedas.cambiarCantidad(1000, alcancia.darNumeroMonedas1000());
    }

    public void nuevaAlcancia() {
        alcancia = new Alcancia();

        panelAlcancia.cambiarImagenAlcancia(false);
        panelAlcancia.cambiarMensaje("La alcancía está vacía.");
        actualizarPanelMonedas();
    }

    public void romperAlcancia() {
        // Generar el mensaje manualmente basado en el estado de la alcancía
        String mensaje = "La alcancía tenía:\n" +
                alcancia.darNumeroMonedas50() + " moneda(s) de $50\n" +
                alcancia.darNumeroMonedas100() + " moneda(s) de $100\n" +
                alcancia.darNumeroMonedas200() + " moneda(s) de $200\n" +
                alcancia.darNumeroMonedas500() + " moneda(s) de $500\n" +
                alcancia.darNumeroMonedas1000() + " moneda(s) de $1000\n" +
                "Para un total de $" + alcancia.calcularTotalDinero() + " pesos.";

        alcancia.romperAlcancia();

        panelAlcancia.cambiarImagenAlcancia(true);
        panelAlcancia.cambiarMensaje("La alcancía está rota.");
        JOptionPane.showMessageDialog(this, mensaje, "Romper alcancía", JOptionPane.INFORMATION_MESSAGE);
    }

    public void reqFunc1() {
        int resultado = alcancia.obtenerDenominacionMasNumerosa();
        JOptionPane.showMessageDialog(this,
                "La moneda más numerosa en la alcancía es la de " + resultado + " pesos",
                "Respuesta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void reqFunc2() {
        String resultado = alcancia.valiosa()
                ? "La alcancía es valiosa, solo posee monedas de 500 y de 1000"
                : "La alcancia no es valiosa, posee monedas de denominaciones diferentes a 1000 o de 500";
        JOptionPane.showMessageDialog(this,
                resultado,
                "Respuesta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] pArgs) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            InterfazAlcancia ia = new InterfazAlcancia();
            ia.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

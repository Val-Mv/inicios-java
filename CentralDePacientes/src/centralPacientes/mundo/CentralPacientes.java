package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) throws YaExisteException {
        // Verifica si ya existe un paciente con el mismo c�digo
        if (localizar(pac.darCodigo()) != null) {
            throw new YaExisteException(pac.darCodigo());
        }
        // Agrega el paciente al comienzo de la lista
        pacientes.add(0, pac);
    }


    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) throws YaExisteException {
        // Verifica si ya existe un paciente con el mismo c�digo
        if (localizar(pac.darCodigo()) != null) {
            throw new YaExisteException(pac.darCodigo());
        }
        // Agrega el paciente al final de la lista
        pacientes.add(pac);
    }


    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException, YaExisteException {
        // Verifica si el paciente a agregar ya existe
        if (localizar(pac.darCodigo()) != null) {
            throw new YaExisteException(pac.darCodigo());
        }

        // Localiza el paciente antes del cual se agregar� el nuevo paciente
        int indice = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            throw new NoExisteException(cod);
        }

        // Inserta el paciente antes del encontrado
        pacientes.add(indice, pac);
    }


    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException, YaExisteException {
        // Verifica si el paciente a agregar ya existe
        if (localizar(pac.darCodigo()) != null) {
            throw new YaExisteException(pac.darCodigo());
        }

        // Localiza el paciente despu�s del cual se agregar� el nuevo paciente
        int indice = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            throw new NoExisteException(cod);
        }

        // Inserta el paciente despu�s del encontrado
        pacientes.add(indice + 1, pac);
    }


    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == codigo) {
                return paciente;
            }
        }
        return null; // Si no se encuentra el paciente, retorna null
    }


    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        Paciente paciente = localizar(cod);
        if (paciente == null) {
            throw new NoExisteException(cod);
        }
        pacientes.remove(paciente);
    }


    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int count = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == Paciente.HOMBRE) {
                count++;
            }
        }
        return count;
    }

    public int cantMujeres() {
        int count = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == Paciente.MUJER) {
                count++;
            }
        }
        return count;
    }


    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
        int[] conteoClinicas = new int[listaClinicas.size()];

        for (Paciente paciente : pacientes) {
            int indiceClinica = listaClinicas.indexOf(paciente.darClinica());
            if (indiceClinica != -1) {
                conteoClinicas[indiceClinica]++;
            }
        }

        int maxIndice = 0;
        for (int i = 1; i < conteoClinicas.length; i++) {
            if (conteoClinicas[i] > conteoClinicas[maxIndice]) {
                maxIndice = i;
            }
        }

        return listaClinicas.get(maxIndice);
    }



}
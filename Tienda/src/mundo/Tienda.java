/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2
 * Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

/**
 * Tienda que maneja 4 productos.
 */
public class Tienda {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Producto 1 - Tipo: PAPELERIA, Nombre: L�piz, Valor unitario: 550.0, Cantidad en bodega: 18, Cantidad m�nima: 5, Imagen: lapiz.png. <br>
     * Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5, Cantidad en bodega: 25, Cantidad m�nima: 8, Imagen: aspirina.png. <br>
     * Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3, Cantidad en bodega: 30, Cantidad m�nima: 10, Imagen: borrador.png. <br>
     * Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0, Cantidad en bodega: 15, Cantidad m�nima: 20, Imagen: pan.png. <br>
     */
    public Tienda() {
        producto1 = new Producto("papeleria", "Lapiz", 550.0, 18, 5, "lapiz.png");
        producto2 = new Producto("drogueria", "Aspirina", 109.5, 25, 8, "aspirina.png");
        producto3 = new Producto("papeleria", "Borrador", 207.3, 30, 10, "borrador.png");
        producto4 = new Producto("supermercado", "Pan", 150.0, 15, 20, "pan.png");
        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el producto 1.
     *
     * @return Producto 1 de la tienda.
     */
    public Producto darPrimerProducto() {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     *
     * @return Producto 2 de la tienda.
     */
    public Producto darSegundoProducto() {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     *
     * @return Producto 3 de la tienda.
     */
    public Producto darTercerProducto() {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     *
     * @return Producto 4 de la tienda.
     */
    public Producto darCuartoProducto() {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     *
     * @return Dinero en caja.
     */
    public double darDineroEnCaja() {
        return dineroEnCaja;
    }

    /**
     * Retorna el producto con el nombre dado por par�metro.
     *
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre != "".
     * @return Producto con el nombre dado por par�metro, null si no lo encuentra.
     */
    public Producto darProducto(String pNombre) {
        if (producto1.darNombre().equals(pNombre)) {
            return producto1;
        } else if (producto2.darNombre().equals(pNombre)) {
            return producto2;
        } else if (producto3.darNombre().equals(pNombre)) {
            return producto3;
        } else if (producto4.darNombre().equals(pNombre)) {
            return producto4;
        } else {
            return null;
        }
    }


    /**
     * Retorna el promedio de las ventas.
     *
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas() {
        int totalUnidadesVendidas = producto1.darCantidadUnidadesVendidas() +
                producto2.darCantidadUnidadesVendidas() +
                producto3.darCantidadUnidadesVendidas() +
                producto4.darCantidadUnidadesVendidas();

        if (totalUnidadesVendidas == 0) {
            return 0.0;
        }

        return dineroEnCaja / totalUnidadesVendidas;
    }

    /**
     * Retorna el producto con m�s unidades vendidas.
     *
     * @return Producto con m�s unidades vendidas. Null si ning�n producto tiene unidades vendidas.
     */
    public Producto darProductoMasVendido() {
        Producto masVendido = null;
        int maxUnidadesVendidas = 0;

        if (producto1.darCantidadUnidadesVendidas() > maxUnidadesVendidas) {
            masVendido = producto1;
            maxUnidadesVendidas = producto1.darCantidadUnidadesVendidas();
        }
        if (producto2.darCantidadUnidadesVendidas() > maxUnidadesVendidas) {
            masVendido = producto2;
            maxUnidadesVendidas = producto2.darCantidadUnidadesVendidas();
        }
        if (producto3.darCantidadUnidadesVendidas() > maxUnidadesVendidas) {
            masVendido = producto3;
            maxUnidadesVendidas = producto3.darCantidadUnidadesVendidas();
        }
        if (producto4.darCantidadUnidadesVendidas() > maxUnidadesVendidas) {
            masVendido = producto4;
            maxUnidadesVendidas = producto4.darCantidadUnidadesVendidas();
        }

        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     *
     * @return Producto con menos unidades vendidas. Null si ning�n producto tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido() {
        Producto menosVendido = null;
        int minUnidadesVendidas = Integer.MAX_VALUE;

        if (producto1.darCantidadUnidadesVendidas() < minUnidadesVendidas && producto1.darCantidadUnidadesVendidas() > 0) {
            menosVendido = producto1;
            minUnidadesVendidas = producto1.darCantidadUnidadesVendidas();
        }
        if (producto2.darCantidadUnidadesVendidas() < minUnidadesVendidas && producto2.darCantidadUnidadesVendidas() > 0) {
            menosVendido = producto2;
            minUnidadesVendidas = producto2.darCantidadUnidadesVendidas();
        }
        if (producto3.darCantidadUnidadesVendidas() < minUnidadesVendidas && producto3.darCantidadUnidadesVendidas() > 0) {
            menosVendido = producto3;
            minUnidadesVendidas = producto3.darCantidadUnidadesVendidas();
        }
        if (producto4.darCantidadUnidadesVendidas() < minUnidadesVendidas && producto4.darCantidadUnidadesVendidas() > 0) {
            menosVendido = producto4;
            minUnidadesVendidas = producto4.darCantidadUnidadesVendidas();
        }

        return menosVendido;
    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre por par�metro. <br>
     * <b>post: </b> Disminuy� la cantidad de unidades del producto dado
     * y se actualiz� el dinero de la caja a partir de la cantidad real vendida multiplicada
     * por el precio final (con IVA) del producto vendido..
     *
     * @param pNombreProducto Nombre del producto a vender.
     * @param pCantidad       Cantidad de unidades del producto a vender. pCantidad > 0.
     * @return Cantidad que fue efectivamente vendida.
     */
    public int venderProducto(String pNombreProducto, int pCantidad) {
        Producto producto = darProducto(pNombreProducto);
        if (producto != null) {
            int cantidadVendida = producto.vender(pCantidad);
            dineroEnCaja += cantidadVendida * producto.calcularPrecioFinal();
            return cantidadVendida;
        }
        return 0;
    }

    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aument� la cantidad de unidades en bodega del producto dado.
     *
     * @param pNombreProducto Nombre del producto a abastecer.
     * @param pCantidad       La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto(String pNombreProducto, int pCantidad) {
        Producto producto = darProducto(pNombreProducto);
        if (producto != null) {
            producto.abastecer(pCantidad);
            return true;
        }
        return false;
    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores dados por par�metro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad m�nima fueron cambiados con los valores dados por par�metro.
     *
     * @param pNombreActual   Nombre actual del producto.
     * @param pNombreNuevo    Nuevo nombre del producto.
     * @param pTipo           Tipo del producto.
     * @param pValorUnitario  Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto.
     * @param pCantidadMinima Cantidad m�nima en bodega para hacer un pedido del producto.
     * @param pRutaImagen     Ruta de la imagen del producto.
     * @return Retorna true si cambi� la informaci�n del producto,
     * Retorna false si ya exist�a un producto con el nuevo nombre.
     */
    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, String pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        if (darProducto(pNombreNuevo) == null) {
            Producto producto = darProducto(pNombreActual);
            if (producto != null) {
                producto.cambiarNombre(pNombreNuevo);
                producto.cambiarTipo(pTipo);
                producto.cambiarValorUnitario(pValorUnitario);
                producto.cambiarCantidadBodega(pCantidadBodega);
                producto.cambiarCantidadMinima(pCantidadMinima);

                return true;
            }
        }
        return false;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Obtiene la cantidad de productos que tienen un precio inferior al promedio de los precios
     */
    public int metodo1() {
        double promedioPrecio = (producto1.darValorUnitario() +
                producto2.darValorUnitario() +
                producto3.darValorUnitario() +
                producto4.darValorUnitario()) / 4;

        int contador = 0;

        if (producto1.darValorUnitario() < promedioPrecio) contador++;
        if (producto2.darValorUnitario() < promedioPrecio) contador++;
        if (producto3.darValorUnitario() < promedioPrecio) contador++;
        if (producto4.darValorUnitario() < promedioPrecio) contador++;

        return contador;
    }


    /**
     * Obtiene el nombre del producto m�s barato de la tienda
     */
    public String metodo2() {
        Producto masBarato = producto1;

        if (producto2.darValorUnitario() < masBarato.darValorUnitario()) {
            masBarato = producto2;
        }
        if (producto3.darValorUnitario() < masBarato.darValorUnitario()) {
            masBarato = producto3;
        }
        if (producto4.darValorUnitario() < masBarato.darValorUnitario()) {
            masBarato = producto4;
        }

        return masBarato.darNombre();
    }
}
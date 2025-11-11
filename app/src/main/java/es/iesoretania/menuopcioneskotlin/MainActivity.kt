package es.iesoretania.menuopcioneskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import es.iesoretania.menuopcioneskotlin.databinding.ActivityMainBinding

/**
 * Actividad principal que demuestra los 3 tipos de menús en Android:
 * 1. Menú de Opciones (Options Menu): Aparece en la barra superior
 * 2. Menú Contextual (Context Menu): Aparece al mantener pulsado un elemento
 * 3. Menú Emergente (Popup Menu): Aparece al hacer clic en un botón
 */
class MainActivity : AppCompatActivity() {

    // Declaramos la variable binding para ViewBinding
    // ViewBinding nos permite acceder a las vistas del layout de forma segura
    // sin usar findViewById()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos ViewBinding inflando el layout
        // inflate() crea una instancia de la clase de binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Establecemos la vista raíz como contenido de la actividad
        // binding.root contiene la vista raíz del layout
        setContentView(binding.root)

        // ===== CONFIGURACIÓN DEL MENÚ CONTEXTUAL =====
        // Registramos el ImageView para que muestre un menú contextual
        // Esto permite que al mantener pulsado sobre la imagen, aparezca el menú
        registerForContextMenu(binding.idimageView1)

        // ===== CONFIGURACIÓN DEL MENÚ EMERGENTE (POPUP) =====
        // Configuramos el botón para que muestre un menú popup al hacer clic
        binding.idBoton.setOnClickListener { view ->
            // Creamos el objeto PopupMenu asociado a la vista que se ha pulsado
            // 'this' es el contexto de la actividad
            // 'view' es la vista (botón) sobre la que aparecerá el menú
            val popup = PopupMenu(this, view)

            // Inflamos el menú desde el archivo XML menu.xml
            // Esto carga las opciones del menú en el objeto popup
            popup.menuInflater.inflate(R.menu.menu, popup.menu)

            // Configuramos el listener para manejar los clics en las opciones del menú
            popup.setOnMenuItemClickListener { menuItem ->
                // Usamos when para evaluar qué opción se ha seleccionado
                when (menuItem.itemId) {
                    R.id.idmenu1 -> {
                        // Si se selecciona la opción 1, mostramos un Toast
                        Toast.makeText(
                            this,
                            "Popup Menú opción 1",
                            Toast.LENGTH_SHORT
                        ).show()
                        true // Devolvemos true para indicar que hemos manejado el evento
                    }
                    R.id.idmenu2 -> {
                        // Si se selecciona la opción 2, mostramos otro Toast
                        Toast.makeText(
                            this,
                            "Popup Menú opción 2",
                            Toast.LENGTH_SHORT
                        ).show()
                        true // Devolvemos true para indicar que hemos manejado el evento
                    }
                    else -> false // Si no reconocemos la opción, devolvemos false
                }
            }

            // Mostramos el menú popup en pantalla
            popup.show()
        }
    }

    // ===== CREACIÓN DEL MENÚ CONTEXTUAL =====
    /**
     * Este método se llama automáticamente cuando se registra una vista para menú contextual
     * y el usuario mantiene pulsado sobre ella
     * @param menu El menú contextual que se está creando
     * @param v La vista sobre la que se ha hecho long-click
     * @param menuInfo Información adicional sobre el elemento seleccionado
     */
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        // Obtenemos el inflater de menús de la actividad
        val inflater: MenuInflater = menuInflater

        // Inflamos el archivo XML del menú en el menú contextual
        // Esto carga las opciones desde menu.xml
        inflater.inflate(R.menu.menu, menu)
    }

    // ===== MANEJO DE SELECCIÓN EN MENÚ CONTEXTUAL =====
    /**
     * Este método se ejecuta cuando el usuario selecciona una opción
     * del menú contextual
     * @param item El elemento del menú que se ha seleccionado
     * @return true si hemos manejado el evento, false en caso contrario
     */
    override fun onContextItemSelected(item: MenuItem): Boolean {
        // Usamos when para evaluar qué opción se ha seleccionado
        return when (item.itemId) {
            R.id.idmenu1 -> {
                // Si selecciona la opción 1 del menú contextual
                Toast.makeText(this, "Menú Contextual - Opción 1", Toast.LENGTH_LONG).show()
                true // Indicamos que hemos manejado el evento
            }
            R.id.idmenu2 -> {
                // Si selecciona la opción 2 del menú contextual
                Toast.makeText(this, "Menú Contextual - Opción 2", Toast.LENGTH_LONG).show()
                true // Indicamos que hemos manejado el evento
            }
            // Si no reconocemos la opción, delegamos al método padre
            else -> super.onContextItemSelected(item)
        }
    }

    // ===== CREACIÓN DEL MENÚ DE OPCIONES =====
    /**
     * Este método se llama automáticamente cuando Android necesita crear
     * el menú de opciones (el que aparece en la barra superior)
     * @param menu El menú de opciones que se está creando
     * @return true para mostrar el menú, false para ocultarlo
     */
    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        // Inflamos el archivo XML del menú en el menú de opciones
        // Esto añade las opciones desde menu.xml a la barra superior
        menuInflater.inflate(R.menu.menu, menu)

        // Devolvemos true para indicar que queremos mostrar el menú
        return true
    }

    // ===== MANEJO DE SELECCIÓN EN MENÚ DE OPCIONES =====
    /**
     * Este método se ejecuta cuando el usuario selecciona una opción
     * del menú de opciones (barra superior)
     * @param item El elemento del menú que se ha seleccionado
     * @return true si hemos manejado el evento, false en caso contrario
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Usamos when para evaluar qué opción se ha seleccionado
        return when (item.itemId) {
            R.id.idmenu1 -> {
                // Si selecciona la opción 1 del menú de opciones
                Toast.makeText(this, "Menú de Opciones - Opción 1", Toast.LENGTH_LONG).show()
                true // Indicamos que hemos manejado el evento
            }
            R.id.idmenu2 -> {
                // Si selecciona la opción 2 del menú de opciones
                Toast.makeText(this, "Menú de Opciones - Opción 2", Toast.LENGTH_LONG).show()
                true // Indicamos que hemos manejado el evento
            }
            // Si no reconocemos la opción, delegamos al método padre
            else -> super.onOptionsItemSelected(item)
        }
    }
}
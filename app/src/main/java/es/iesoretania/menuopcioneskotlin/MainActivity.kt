package es.iesoretania.menuopcioneskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import es.iesoretania.menuopcioneskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Registramos el menú contextual
        registerForContextMenu(binding.idimageView1)

        binding.idBoton.setOnClickListener {
            val popup = android.widget.PopupMenu(this, it)
            popup.menuInflater.inflate(R.menu.menu, popup.menu)
            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.idmenu1 -> {
                        Toast.makeText(this, "Popup Menú opción 1",
                            Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.idmenu2 -> {
                        Toast.makeText(this, "Popup Menú opción 2",
                            Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    //Creamos el menú contextual.
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
    }

    //Creamos el menú de opciones.
    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    //Controlamos las acciones del menú contextual.
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.idmenu1 -> {
                Toast.makeText(this, "Opción 1", Toast.LENGTH_LONG).show()
                true
            }
            R.id.idmenu2 -> {
                Toast.makeText(this, "Opción 2", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    //Controlamos las acciones del menú de opciones.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.idmenu1 -> {
                Toast.makeText(this, "Opción 1", Toast.LENGTH_LONG).show()
                true
            }
            R.id.idmenu2 -> {
                Toast.makeText(this, "Opción 2", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
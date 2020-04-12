package araikovich.inc.bekind.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import araikovich.inc.bekind.R
import araikovich.inc.bekind.ui.menu.MenuItem

class MainActivity : AppCompatActivity() {

    private val mainFragment get() = supportFragmentManager.primaryNavigationFragment?.childFragmentManager?.primaryNavigationFragment as? MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

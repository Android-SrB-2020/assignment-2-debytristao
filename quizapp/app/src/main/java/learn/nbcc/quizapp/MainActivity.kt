package learn.nbcc.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import learn.nbcc.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var navegation: NavController


    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main)

        drawerLayout = binding.drawerLayout


        navegation = this.findNavController(R.id.mainFragmentPage)


        NavigationUI.setupActionBarWithNavController(this,navegation)

        NavigationUI.setupWithNavController(binding.navView, navegation)

        NavigationUI.setupActionBarWithNavController(this, navegation, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navegation, drawerLayout)
    }
}

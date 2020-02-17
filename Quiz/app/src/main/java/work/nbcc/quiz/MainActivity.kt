package work.nbcc.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var layout: DrawerLayout
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityNavigator>(this,
            R.layout.activity_main)

        navController = this.findNavController(R.id.myNavHostFragment)
        layout = binding.layout

        NavigationUI.setupActionBarWithNavController(binding.navViewe, navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, layout)


    }


}
